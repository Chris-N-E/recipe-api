package com.codingblackfemales.recipe.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public List<Recipe> getRecipes() {
        return recipeRepository.findAll(); //returns a list

    }

    public void addNewRecipe(Recipe recipe) {
        Optional<Recipe> recipeOptional =
                recipeRepository.findRecipeByName(recipe.getName());
        if (recipeOptional.isPresent()){
            throw new IllegalStateException("recipe exists");
        }
        recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long recipeId) {
        boolean exists = recipeRepository.existsById(recipeId);
        if (!exists) {
            throw new IllegalStateException(
                    "recipe id" + recipeId + " does not exist");
        }
        recipeRepository.deleteById(recipeId);
    }

    @Transactional
    public void updateRecipe(Long recipeId, Recipe recipeContent) {

        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException(
                        "recipe id " + recipeId + " does not exist."
                ));
        if (recipeContent.getName() != null && recipeContent.getName().length() > 0 &&
                !Objects.equals(recipe.getName(), recipeContent.getName())) {
            recipe.setName(recipeContent.getName());
        }

        if (recipeContent.getIngredients() != null && recipeContent.getIngredients().size() > 0 &&
                !Objects.equals(recipe.getIngredients(), recipeContent.getIngredients())) {
            recipe.setIngredients(recipeContent.getIngredients());
        }

        if (recipeContent.getInstructions() != null && recipeContent.getInstructions().length() > 0 &&
                !Objects.equals(recipe.getInstructions(), recipeContent.getInstructions())) {
            recipe.setInstructions(recipeContent.getInstructions());
        }
        recipeRepository.save(recipe);

    }

}

