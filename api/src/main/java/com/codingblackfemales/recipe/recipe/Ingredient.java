package com.codingblackfemales.recipe.recipe;


import javax.persistence.*;

@Embeddable

public class Ingredient {

    private String name;
    private String quantity;

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Ingredient() {

    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(String quantity) {
//        this.quantity = quantity;
//    }
}
