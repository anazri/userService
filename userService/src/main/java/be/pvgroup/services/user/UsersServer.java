package be.pvgroup.services.user;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Import(UserWebApplication.class)
public class UsersServer {

	@Autowired
	protected UserRepository userRepository;
	
	protected Logger logger = Logger.getLogger(UsersServer.class.getName());
	
	public static void main(String[] args) {
		SpringApplication.run(UsersServer.class, args);
	}
}
