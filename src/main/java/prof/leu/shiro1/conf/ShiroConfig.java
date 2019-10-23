package prof.leu.shiro1.conf;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

@Bean(name = "shiroFilterFactoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean( @Qualifier("securityManager") DefaultWebSecurityManager securityManager ){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		shiroFilterFactoryBean.setSecurityManager( securityManager);

		Map<String ,String> filter_map = new LinkedHashMap<String ,String>() ;
//		filter_map.put("/add" ,"authc") ;
//		filter_map.put("/update" ,"authc") ;
//	filter_map.put("/user/add" ,"authc") ;
	filter_map.put("/user/update" ,"authc") ;
	filter_map.put("/user/add" ,"perms[user:add]") ;
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filter_map);
	shiroFilterFactoryBean.setLoginUrl("/login");
		return shiroFilterFactoryBean;
	}

@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager ;
	}

	@Bean(name = "userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
}
