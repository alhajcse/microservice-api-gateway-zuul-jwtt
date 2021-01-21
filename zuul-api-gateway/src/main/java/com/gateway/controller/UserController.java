package com.gateway.controller;

import com.gateway.model.User;
import com.gateway.response.CustomResponseStatus;
import com.gateway.response.JSONCustomResponse;
import com.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.gateway.dto.AuthenticationRequest;
import com.gateway.dto.AuthenticationResponse;
import com.gateway.serviceImp.JwtUtil;



@RestController
@RequestMapping(value = "v1/api/")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;


	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping("/")
	public String getM() {

		return "Welcome Dude!";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {

			System.out.println("username");
			System.out.println(authenticationRequest.getUserName());
			System.out.println("password");
			System.out.println(authenticationRequest.getPassword());

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(),
					authenticationRequest.getPassword()
			));



//			final UserDetails userDetails = userDetailsService
//					.loadUserByUsername(authenticationRequest.getUsername());
//
//			final String token = jwtUtil.generateToken(userDetails);



		} catch (Exception e) {

			System.out.println("error exception message");
			System.out.println(e.getMessage());

			throw new Exception("Invalid UserName /Password");
		}
		final String jwt = jwtUtil.generateToken(authenticationRequest.getUserName());

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	  @PostMapping("/register") public JSONCustomResponse addUsers(@RequestBody User
	  user) {


		  JSONCustomResponse jsonCustomResponse = new JSONCustomResponse();


		  if (userService.existsByUserName(user.getUserName())) {

			  try {
				  //jsonCustomResponse.getData().put("user", null);
				  //jsonCustomResponse.getUser();
				  jsonCustomResponse.setStatus(CustomResponseStatus.SUCCESS);
				  jsonCustomResponse.setMessage("Error: Username is already taken!");
			  } catch (Exception e) {
				  jsonCustomResponse.setStatus(CustomResponseStatus.FAILURE);
				  jsonCustomResponse.setMessage("Unable to fetch the list.");
			  }

			  return jsonCustomResponse;
		  }

		  if (userService.existsByEmail(user.getEmail())) {

			  try {
				  //jsonCustomResponse.getData().put("user", null);
				  //jsonCustomResponse.getUser();
				  jsonCustomResponse.setStatus(CustomResponseStatus.SUCCESS);
				  jsonCustomResponse.setMessage("Error: Email is already in use!");
			  } catch (Exception e) {
				  jsonCustomResponse.setStatus(CustomResponseStatus.FAILURE);
				  jsonCustomResponse.setMessage("Unable to fetch the list.");
			  }
			  return jsonCustomResponse;
		  }

//		  if (userService.existsByUserName(user.getUserName())) {
//			  return ResponseEntity
//					  .badRequest()
//					  .body(new MessageResponse("Error: Username is already taken!"));
//		  }
//
//		  if (userService.existsByEmail(user.getEmail())) {
//			  return ResponseEntity
//					  .badRequest()
//					  .body(new MessageResponse("Error: Email is already in use!"));
//		  }

		  userService.savUser(user);

		  jsonCustomResponse.setUser(user);

		  try {
			  //jsonCustomResponse.getData().put("user", user);
			  jsonCustomResponse.getUser();
			  jsonCustomResponse.setStatus(CustomResponseStatus.SUCCESS);
			  jsonCustomResponse.setMessage("User registered successfully!");
		  } catch (Exception e) {
			  jsonCustomResponse.setStatus(CustomResponseStatus.FAILURE);
			  jsonCustomResponse.setMessage("Unable to fetch the list.");
		  }


		 // return new ResponseEntity<JSONCustomResponse>(new MessageResponse("User registered successfully!"), HttpStatus.OK);
		  return jsonCustomResponse;
	  }





}
