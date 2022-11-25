package com.codingblackfemales.recipe.recipe;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class recipeConfig {

    @Bean
    CommandLineRunner commandLineRunner(RecipeRepository repository) {
        return args -> {
            Recipe creamyCourgetteLasagne = new Recipe(
                            "Creamy courgette lasagne",
                    Arrays.asList(
                            new Ingredient("Dried lasagne sheets","9"),
                            new Ingredient ("Courgette coarsely grated", "700g (about 6)")),
                            "Heat oven to 220C/fan 200C/gas 7. Put a pan of water on to boil, then cook the lasagne sheets for about 5 mins until softened, but not cooked through...");

            Recipe blackberryPie = new Recipe(
                    "Blackberry pie",
                    Arrays.asList(
                            new Ingredient("Blackberries", "600g"),
                            new Ingredient("Self-raising flour", "300g (plus extra for dusting)" )),
                    "First, make the pastry. Tip both flour and sugar into a bowl with a large pinch of salt...");

            Recipe cheeseburger = new Recipe(
                    "Cheeseburger",
                    Arrays.asList(
                            new Ingredient("Minced beef", "1.5kg"),
                            new Ingredient("Breadcrumbs", "300g" )),
                    "Crumble the mince in a large bowl, then tip in the breadcrumbs, cheese, Worcestershire sauce, parsley and eggs with 1 tsp ground pepper and 1-2 tsp salt....");

            Recipe porkTacos = new Recipe(
                    "Pork tacos",
                    Arrays.asList(
                            new Ingredient("Pork shoulder", "750g"),
                            new Ingredient("Garlic cloves", "2"),
                            new Ingredient("Avocado", "1" )),
                    "Put the pork in a large, lidded ovenproof dish with the remaining ingredients and mix well to coat. If you can, chill and marinate overnight...");

            repository.saveAll(
                    List.of(creamyCourgetteLasagne, blackberryPie, cheeseburger, porkTacos)
            );
        };
    }
}
