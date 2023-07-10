package com.appleparatha.serviceimpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appleparatha.Entity.AppleParathaRecipe;
import com.appleparatha.repository.AppleParathaRecipeRepository;
import com.appleparatha.service.AppleParathaRecipeService;

@Service
public class AppleParathaRecipeServiceImpl implements AppleParathaRecipeService {

	@Autowired
	private AppleParathaRecipeRepository appleRepository;

	@Override
	public AppleParathaRecipe createRecipe(String recipeTitle,String veg_nonVeg,String[] ingredients,
			                               String[] recipeSteps,String summery,Float rating, MultipartFile file) throws IOException
	{
		AppleParathaRecipe apr= new AppleParathaRecipe();
		apr.setRecipeTitle(recipeTitle);
		apr.setVeg_nonVeg(veg_nonVeg);
		apr.setIngredients(ingredients);
		apr.setRecipeSteps(recipeSteps);
		apr.setSummery(summery);
		apr.setRating(rating);
		apr.setRecipeImage(file);
		return appleRepository.save(apr);		  
	}

	@Override
	public AppleParathaRecipe updateRecipe(Long recipeId,String recipeTitle,String veg_nonVeg,String[] ingredients,
            String[] recipeSteps,String summery,Float rating, MultipartFile file)throws IOException {
		 AppleParathaRecipe existingrecipe=appleRepository.findById(recipeId).get();
		 existingrecipe.setRecipeTitle(recipeTitle);
		 existingrecipe.setVeg_nonVeg(veg_nonVeg);
		 existingrecipe.setIngredients(ingredients);
		 existingrecipe.setRecipeSteps(recipeSteps);
		 existingrecipe.setSummery(summery);
		 existingrecipe.setRating(rating);
		 existingrecipe.setRecipeImage(file);
		 
		 AppleParathaRecipe updatedrecipe = appleRepository.save(existingrecipe);
		 
		return updatedrecipe;
	}

	@Override
	public AppleParathaRecipe getRecipeById(Long recipeId) {
		 Optional<AppleParathaRecipe> optionalrecipe = appleRepository.findById(recipeId);
		return optionalrecipe.get();
	}

	@Override
	public List<AppleParathaRecipe> getAllRecipies() {
		 List<AppleParathaRecipe> allrecipe = appleRepository.findAll();
		return allrecipe;
	}

	@Override
	public void deleteRecipeById(Long recipeId) {
	 appleRepository.deleteById(recipeId);
		
	}
}
