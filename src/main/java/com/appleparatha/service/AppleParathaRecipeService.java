package com.appleparatha.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.appleparatha.Entity.AppleParathaRecipe;

public interface AppleParathaRecipeService {

	
	public AppleParathaRecipe createRecipe(String recipeTitle,String veg_nonVeg,String[] ingredients,
            String[] recipeSteps,String summery,Float rating, MultipartFile file) throws IOException;
	
	public AppleParathaRecipe updateRecipe(Long recipeId,String recipeTitle,String veg_nonVeg,String[] ingredients,
            String[] recipeSteps,String summery,Float rating, MultipartFile file)throws IOException;
	
	public AppleParathaRecipe getRecipeById(Long recipeId);
	
	public List<AppleParathaRecipe> getAllRecipies();
	
	public void deleteRecipeById(Long recipeId);
}
