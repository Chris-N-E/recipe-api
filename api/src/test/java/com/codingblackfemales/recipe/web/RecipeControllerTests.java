package com.codingblackfemales.recipe.web;

import com.codingblackfemales.recipe.recipe.Ingredient;
import com.codingblackfemales.recipe.recipe.Recipe;
import com.codingblackfemales.recipe.recipe.RecipeController;
import com.codingblackfemales.recipe.recipe.RecipeService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@ContextConfiguration
@ComponentScan(basePackages = "com.codingblackfemales.recipe")
@SpringBootTest(classes = {RecipeControllerTests.class})



@DisplayName("The recipe controller should")

public class RecipeControllerTests {

    private static final String RECIPE_ENDPOINT = "/api/v1/recipe";

    @Autowired
    MockMvc mockMvc; //create variable for the MockMvc framework

    @Mock
    RecipeService recipeService;

    @InjectMocks
    RecipeController recipeController;

    List<Recipe> myRecipes;
//    Recipe recipe;

    @BeforeEach
//    execute before every test method
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();
    }

    @Test
    @DisplayName("Getting recipes")
    public void test_getAllRecipes() throws Exception {

        //given - precondition/setup
        myRecipes = new ArrayList<>();
        myRecipes.add(new Recipe(1L,"Apple pie",
                Arrays.asList(new Ingredient("Apples", "10"),
                        new Ingredient("Butter", "225g")),
                "Peel apples and cut into 1/8th pieces. Pour into a bowl with half the sugar. Mix well"));
        myRecipes.add(new Recipe(2L,"Brownies",
                Arrays.asList(new Ingredient("Dark chocolate", "140g"),
                        new Ingredient("Sugar", "350g")),
                "Gently melt butter and sugar together in a pan…"));

        //when - behaviour to be tested
        when(recipeService.getRecipes()).thenReturn(myRecipes);

        //then - verify result using assert statements
        this.mockMvc.perform(get(RECIPE_ENDPOINT))
                .andExpect(status().isOk()) //Test failed with "andExpect(status().isFound())"
                .andDo(print());
    }

//    @Test
//    @DisplayName("Adding a new recipe")
//    public void test_addNewRecipe() throws Exception {
//
//        recipe = new Recipe(3L,"Pea Soup",
//                Arrays.asList(new Ingredient("Split peas", "250"),
//                        new Ingredient("Corn", "4 ears")),
//                "Tip the split peas into a pan with 1.5 litres/2¾ pints water and...");
//
//        when(recipeService.addNewRecipe(recipe)).thenReturn();
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonBody = mapper.writeValueAsString(recipe);
//
//        this.mockMvc.perform(post("/api/v1/recipe")
//                .content(jsonBody)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated());
//    }
//    @Test
//    @DisplayName("Updating existing recipe")
//    public void test_updateRecipe() {
//
//        recipe = new Recipe(3L,"Split Pea Soup",
//                Arrays.asList(new Ingredient("Split peas", "250"),
//                        new Ingredient("Corn", "4 ears")),
//                "Tip the split peas into a pan with 1.5 litres/2¾ pints water and...");
//        Long recipe_ID = 3L;

//      //when
//    }


}

