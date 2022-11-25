package com.codingblackfemales.recipe.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT s FROM Recipe s WHERE s.name = ?1")
    Optional<Recipe> findRecipeByName(String name);

    @Query("SELECT s FROM Recipe s WHERE s.name IN (:ingredients)")
    Optional<Recipe> findRecipeByIngredients(List<Ingredient> ingredients);

}

