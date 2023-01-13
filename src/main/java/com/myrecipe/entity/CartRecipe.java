package com.myrecipe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="cart_recipe")
public class CartRecipe extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "cart_recipe_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public static CartRecipe createCartRecipe(Cart cart, Recipe recipe) {
        CartRecipe cartRecipe = new CartRecipe();
        cartRecipe.setCart(cart);
        cartRecipe.setRecipe(recipe);
        return cartRecipe;
    }

}
