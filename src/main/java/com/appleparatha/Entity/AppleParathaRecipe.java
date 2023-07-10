package com.appleparatha.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class AppleParathaRecipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeId;
	private String recipeTitle;
	private String veg_nonVeg;
	private String[] ingredients;
	private String[] recipeSteps;
	private String summery;
	private float rating;
	@Lob
	private MultipartFile recipeImage;
//	@Transient
//	private MultipartFile recipeImage;
	
	public AppleParathaRecipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppleParathaRecipe(long recipeId, String recipeTitle, String veg_nonVeg, String[] ingredients,
			String[] recipeSteps, String summery, float rating, MultipartFile recipeImage) {
		super();
		this.recipeId = recipeId;
		this.recipeTitle = recipeTitle;
		this.veg_nonVeg = veg_nonVeg;
		this.ingredients = ingredients;
		this.recipeSteps = recipeSteps;
		this.summery = summery;
		this.rating = rating;
		this.recipeImage = recipeImage;
	}

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
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

//	public MultipartFile getRecipeImage() {
//		return recipeImage;
//	}
//
//	public void setRecipeImage(MultipartFile recipeImage) {
//		this.recipeImage = recipeImage;
//	}
	

	public MultipartFile getRecipeImage() {
		return recipeImage;
	}

	public void setRecipeImage(MultipartFile file) {
		this.recipeImage = file;
	}

//	@Override
//	public String toString() {
//		return "AppleParathaRecipe [recipeId=" + recipeId + ", recipeTitle=" + recipeTitle + ", veg_nonVeg="
//				+ veg_nonVeg + ", ingredients=" + Arrays.toString(ingredients) + ", recipeSteps="
//				+ Arrays.toString(recipeSteps) + ", summery=" + summery + ", rating=" + rating + ", recipeImage="
//				+ Arrays.toString(recipeImage) + "]";
//	}
	
	
	
	
	
}
