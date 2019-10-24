package prof.leu.shiro1.conf;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
//import prof.leu.shiro1.domain.User;
import prof.leu.shiro1.domain.User;
import prof.leu.shiro1.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService ;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		System.err.println("执行授权逻辑");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set set = new HashSet() ;


//		User user = this.getUser(username) ;
		Subject subject = SecurityUtils.getSubject() ;
		User user = (User) subject.getPrincipal();

		set.add(user.getPerms()) ;
		info.setStringPermissions(set);
		return info ;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.err.println("执行认证逻辑");


		// db username and password
//		String db_uname = "tom" ;
//		String db_pwd = "123456" ;
		UsernamePasswordToken utoken =(UsernamePasswordToken) token ;
	String	username = utoken.getUsername() ;
		char[]	password = utoken.getPassword() ;


		User user;
        user = userService.findByName(username);



        if (user==null){
			return  null ;
		}


		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}


}
