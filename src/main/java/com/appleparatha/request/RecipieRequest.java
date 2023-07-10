package com.appleparatha.request;

import org.springframework.web.multipart.MultipartFile;

public class RecipieRequest {
	
	private String recipeTitle;
	private String veg_nonVeg;
	private String[] ingredients;
	private String[] recipeSteps;
	private String summery;
	private float rating;
	private MultipartFile recipeImageFile;
	
	public RecipieRequest() {
		super();
	}
	public RecipieRequest(long recipeId, String recipeTitle, String veg_nonVeg, String[] ingredients,
			String[] recipeSteps, String summery, float rating) {
		super();
		this.recipeTitle = recipeTitle;
		this.veg_nonVeg = veg_nonVeg;
		this.ingredients = ingredients;
		this.recipeSteps = recipeSteps;
		this.summery = summery;
		this.rating = rating;
	}
	public String getRecipeTitle() {
		return recipeTitle;
	}
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	public String getVeg_nonVeg() {
		return veg_nonVeg;
	}
	public void setVeg_nonVeg(String veg_nonVeg) {
		this.veg_nonVeg = veg_nonVeg;
	}
	public String[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(String[] ingredients) {
		this.ingredients = ingredients;
	}
	public String[] getRecipeSteps() {
		return recipeSteps;
	}
	public void setRecipeSteps(String[] recipeSteps) {
		this.recipeSteps = recipeSteps;
	}
	public String getSummery() {
		return summery;
	}
	public void setSummery(String summery) {
		this.summery = summery;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public MultipartFile getRecipeImageFile() {
		return recipeImageFile;
	}
	public void setRecipeImageFile(MultipartFile recipeImageFile) {
		this.recipeImageFile = recipeImageFile;
	}
}
