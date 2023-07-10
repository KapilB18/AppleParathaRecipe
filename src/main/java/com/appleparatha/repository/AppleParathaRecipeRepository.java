package com.appleparatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appleparatha.Entity.AppleParathaRecipe;

@Repository
public interface AppleParathaRecipeRepository extends JpaRepository<AppleParathaRecipe, Long>{

}
