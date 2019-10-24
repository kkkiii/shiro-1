package prof.leu.shiro1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prof.leu.shiro1.domain.User;
import prof.leu.shiro1.mapper.UserMapper;
@Service("UserService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper ;
  public  User findByName(String name) {
      return   userMapper.findByName(name) ;
  }
    public  User findById(Integer id) {
        return   userMapper.findById(id) ;
    }
}
