package prof.leu.shiro1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("prof.leu.shiro1.mapper")
public class Shiro1Application {

	public static void main(String[] args) {
		SpringApplication.run(Shiro1Application.class, args);
	}

}
