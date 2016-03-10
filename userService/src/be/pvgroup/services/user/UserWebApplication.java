package be.pvgroup.services.user;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories("be.pvgroup.services.user")
public class UserWebApplication {

	protected Logger logger = Logger.getLogger(UserWebApplication.class
			.getName());

}
