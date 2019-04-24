
package com.uweek.controller;

import com.uweek.business.implementation.ServiceDish;
import com.uweek.entity.Dish;
import com.uweek.entity.Ingredient;
import com.uweek.util.Message;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;


@Named
@ViewScoped
public class ControllerDish implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private ServiceDish serviceDish;
    
    private Dish dish;
    private Dish dishSelect;
    private List<Dish> dishes;
    
    @PostConstruct
    public void init() {
        dish = new Dish();
        dishSelect = new Dish();
        loadDishes();
    }
    
    public void loadDishes() {
        try {
            this.dishes = serviceDish.list();
        } catch (Exception e) {
            Message.messageError("Error Plato: " + e.getMessage());
        }
    }
    
    public void saveDish() {
        try {
            if (dish.getId() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                serviceDish.update(dish);
            } else {
                serviceDish.insert(dish);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadDishes();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Plato :" + e.getStackTrace());
        }
    }
        
    public void editDish() {
        try {
            if (this.dishSelect != null) {
                this.dish = dishSelect;
            } else {
                Message.messageInfo("Debe seleccionar un plato");
            }
        } catch (Exception e) {
            Message.messageError("Error Plato :" + e.getMessage());
        }

    }

    public void deleteDish() {
        try {
            if (this.dishSelect != null) {
                serviceDish.delete(dishSelect);
                loadDishes();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }
    
    public void selectDish(SelectEvent e) {
        this.dishSelect = (Dish) e.getObject();
    }

    public void clearForm() {
        this.dish = new Dish();
        this.dishSelect = null;
    }

    public Dish getDish(){  //ta bn
        return dish;
    }


    
    public Dish getDishSelect() {   //ta bn
        return dishSelect;
    }

    public void setDishSelect(Dish dishSelect) { //ta bn
        this.dishSelect = dishSelect;
    }

    public List<Dish> getDishes() { // ta bn
        return dishes;
    }

    public void setDishes(List<Dish> dishes) { //ta bn
        this.dishes = dishes;
    }
    

    
}
