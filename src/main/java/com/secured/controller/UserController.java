package com.secured.controller;

import com.secured.entity.User;
import com.secured.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/public")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public String addUser(@RequestBody User user) {
		boolean b = userService.add(user);
		return "success";
	}

	@GetMapping("/name/{name}")
	public User getUserByName(@PathVariable String name) throws Exception{
		return userService.getUserByName(name);
	}
	
	@GetMapping("/getall")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@DeleteMapping("/delete")
	public void deleteAll() {
		userService.deleteAll();
	}
}
