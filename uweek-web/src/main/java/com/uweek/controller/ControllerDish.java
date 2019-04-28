package com.uweek.controller;

import com.uweek.business.IServiceDish;
import com.uweek.business.IServicePlan;
import com.uweek.entity.Dish;
import com.uweek.entity.Plan;
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
public class ControllerDish implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServicePlan servicePlan;

    @Inject
    private IServiceDish serviceDish;

    private Dish dish;
    private Dish dishSelect;
    private List<Dish> dishes;

    private Plan plan;
    private List<Plan> plans;

    @PostConstruct
    public void init() {
        dish = new Dish();
        dishSelect = new Dish();
        this.loadDishes();
        this.loadPlans();
    }

    public void loadDishes() {
        try {
            this.dishes = serviceDish.list();
        } catch (Exception e) {
            Message.messageError("Error Plato: " + e.getMessage());
        }
    }

    private void loadPlans() {
        try {
            this.plans = servicePlan.list();
        } catch (Exception e) {

        }
    }

    public void saveDish() {
        try {
            if (dish.getId() != null) {
                dish.setPlan(plan);
                serviceDish.update(dish);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                dish.setPlan(plan);
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
            if (this.dishSelect.getId() > 0) {
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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Dish getDishSelect() {
        return dishSelect;
    }

    public void setDishSelect(Dish dishSelect) {
        this.dishSelect = dishSelect;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

}
