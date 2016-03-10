package be.pvgroup.services.user;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Inject UserRepository userRepository;
	
	@ApiOperation(value = "get a user by ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@ApiParam(value = "", required = true)@PathVariable("id") Long id) {
		User user = userRepository.findById(id);
		if(user == null){
			throw new UserNotFoundException(id);
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
	}

	@ApiOperation(value = "create a user")
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> addUser(@RequestBody User user) {
		
		User result = userRepository.save(user);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);

	}
	
	@ApiOperation(value = "get all users")
	@RequestMapping( method = RequestMethod.GET )
	ResponseEntity<?> findAllUsers() {
		List<User> users = userRepository.findAll();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<>(users, httpHeaders, HttpStatus.OK);
	}
	
	@ApiOperation(value = "delete a user by ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> deleteUserById(@ApiParam(value = "", required = true)@PathVariable("id") String id) {
		userRepository.delete(id);
		return new ResponseEntity<>(HttpStatus.GONE);
	}
}
