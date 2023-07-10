package com.appleparatha.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appleparatha.Entity.AppleParathaRecipe;
import com.appleparatha.authentication.AuthenticationRequest;
import com.appleparatha.authentication.AuthenticationResponse;
import com.appleparatha.jwtutility.JwtUtil;
import com.appleparatha.service.AppleParathaRecipeService;

@RestController
public class AppleParathaController {

	@Autowired
	private AppleParathaRecipeService appleService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping(value = "/create-recipe" ,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	ResponseEntity<AppleParathaRecipe> createRecipe(@RequestParam("recipeTitle") String recipeTitle,
			                                        @RequestParam("veg_nonVeg") String veg_nonVeg,
			                                        @RequestParam("ingredients") String[] ingredients,
			                                        @RequestParam("recipeSteps") String[] recipeSteps,
			                                        @RequestParam("summery") String summery,
			                                        @RequestParam("rating") Float rating,
			                                        @RequestPart("file") MultipartFile file) throws IOException
	{
		
		AppleParathaRecipe newrecipe = appleService.createRecipe(recipeTitle,veg_nonVeg,ingredients,recipeSteps,summery,rating,file);	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newrecipe);
	}
	
	
	@PutMapping(value = "/update-recipe/{recipeId}",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = "application/json")
	ResponseEntity<AppleParathaRecipe> updateRecipe(@PathVariable Long recipeId,
			                                        @RequestParam("recipeTitle") String recipeTitle,
                                                    @RequestParam("veg_nonVeg") String veg_nonVeg,
                                                    @RequestParam("ingredients") String[] ingredients,
                                                    @RequestParam("recipeSteps") String[] recipeSteps,
                                                    @RequestParam("summery") String summery,
                                                    @RequestParam("rating") Float rating,
                                                    @RequestPart("file") MultipartFile file
			                                        ) throws IOException{
		 
		AppleParathaRecipe updateRecipe = appleService.updateRecipe(recipeId,recipeTitle,veg_nonVeg,ingredients,recipeSteps,summery,rating,file);
		return ResponseEntity.status(HttpStatus.OK).body(updateRecipe);
	}
	
	
	@GetMapping(value = "/get-recipe/{recipeId}")
	ResponseEntity<AppleParathaRecipe> getRecipeById(@PathVariable Long recipeId){
		
		AppleParathaRecipe recipeById = appleService.getRecipeById(recipeId);
		return ResponseEntity.status(HttpStatus.OK).body(recipeById);
	}
	
	@GetMapping(value = "/get-allrecipe")
	ResponseEntity<Iterable<AppleParathaRecipe>> getAllRecipe(){
		List<AppleParathaRecipe> allRecipies = appleService.getAllRecipies();
		return ResponseEntity.status(HttpStatus.OK).body(allRecipies);
	}
	
	@DeleteMapping(value = "/delete-recipe")
	ResponseEntity<String> deleteById(@PathVariable Long recipeId){
		
		appleService.deleteRecipeById(recipeId);
		
		return ResponseEntity.status(HttpStatus.OK).body("Recipe with "+recipeId+" has been deleted successfully");
		
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
	{
		try
		{
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			 throw new Exception("Incorrect usernaem or password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwtToken = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponse(jwtToken));
	}
}
