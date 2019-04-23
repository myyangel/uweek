/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uweek.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.uweek.business.implementation.ServiceIngredient;
import com.uweek.entity.Ingredient;
import com.uweek.util.Message;

/**
 *
 * @author arman
 */
@Named
@ViewScoped
public class ControllerIngredient implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ServiceIngredient serviceIngredient;
    
    private Ingredient ingredient;
    private Ingredient ingredientSelect;
    private List<Ingredient> ingredients;
    
    @PostConstruct
    public void init() {
        ingredient = new Ingredient();
        ingredientSelect = new Ingredient();
        loadIngredients();
    }
    
    public void loadIngredients() {
        try {
            this.ingredients = serviceIngredient.list();
        } catch (Exception e) {
            Message.messageError("Error Ingrediente: " + e.getMessage());
        }
    }
    
    public void saveIngredient() {
        try {
            if (ingredient.getId() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                serviceIngredient.update(ingredient);
            } else {
                serviceIngredient.insert(ingredient);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadIngredients();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Ingrediente :" + e.getStackTrace());
        }
    }
    
    public void editIngredient() {
        try {
            if (this.ingredientSelect != null) {
                this.ingredient = ingredientSelect;
            } else {
                Message.messageInfo("Debe seleccionar un Ingrediente");
            }
        } catch (Exception e) {
            Message.messageError("Error Ingrediente :" + e.getMessage());
        }

    }

    public void deleteIngredient() {
        try {
            if (this.ingredientSelect != null) {
                serviceIngredient.delete(ingredientSelect);
                loadIngredients();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectIngredient(SelectEvent e) {
        this.ingredientSelect = (Ingredient) e.getObject();
    }

    public void clearForm() {
        this.ingredient = new Ingredient();
        this.ingredientSelect = null;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setPlan(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredientSelect() {
        return ingredientSelect;
    }

    public void setIngredientSelect(Ingredient ingredientSelect) {
        this.ingredientSelect = ingredientSelect;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
