package poc.restdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.restdemo.model.ResponseDTO;
import poc.restdemo.model.User;
import poc.restdemo.service.UserService;

@RestController
@RequestMapping("/user-service")
public class UserController {

	private final String UPDATE_KEY = "update";
	private final String SAVE_KEY = "save";

	@Autowired
	private UserService userService;

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {

		System.err.println(id + " id");
		User user = userService.findById(id);
		System.err.println(user + " user");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<ResponseDTO<List<User>>> getUser() {

		List<User> user = userService.findAll();
		ResponseDTO<List<User>> response = new ResponseDTO<>();
		response.setData(user);
		return new ResponseEntity<ResponseDTO<List<User>>>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<Map<String, String>> deleteUserById(@PathVariable("id") Integer id) {

		Map<String, String> map = new HashMap<>(2);
		String usertext = userService.deleteById(id);
		map.put("status", usertext);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
	}

	@PostMapping(value = "/post", produces = "application/json", consumes = "application/json")
	public ResponseEntity<User> saveUserById(@RequestBody User user) {
		user = userService.saveOrUpdateUser(user, SAVE_KEY);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<User> updateById(@RequestBody User user) {

		user = userService.saveOrUpdateUser(user, UPDATE_KEY);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
