package prof.leu.shiro1.mapper;

import org.springframework.stereotype.Service;
import prof.leu.shiro1.domain.User;
@Service
public interface UserMapper {
     User findByName(String name) ;
     User findById(Integer id) ;
}
