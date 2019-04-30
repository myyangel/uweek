
package com.uweek.controller;

import com.uweek.business.IServiceIngredient;
import com.uweek.business.IServiceUser;
import com.uweek.business.IServiceAllergy;
import com.uweek.entity.Ingredient;
import com.uweek.entity.User;
import com.uweek.entity.Allergy;
import com.uweek.entity.UserRole;
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
public class ControllerAllergy implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Inject
    private IServiceIngredient serviceIngredient;
    
    @Inject
    private IServiceUser serviceUser;

    @Inject
    private IServiceAllergy serviceAllergy;

    private Allergy allergy;
    private Allergy allergySelect;
    private List<Allergy> allergies;

    private User user;
    private List<User> users;
    
    private Ingredient ingredient;
    private List<Ingredient> ingredients;
    
    @PostConstruct
    public void init() {
        allergy = new Allergy();
        allergySelect = new Allergy();
        this.loadAllergies();
        this.loadUsers();
        this.loadIngredients();
    }

    public void loadAllergies() {
        try {
            this.allergies = serviceAllergy.list();
        } catch (Exception e) {
            Message.messageError("Error Allergy: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try {
            this.users = serviceUser.list();
        } catch (Exception e) {

        }
    }
    
    private void loadIngredients() {
        try {
            this.ingredients = serviceIngredient.list();
        } catch (Exception e) {

        }
    }
    
    public void saveAllergy() {
        try {
            if (allergy.getId() != null) {
                allergy.setUser(user);
                allergy.setIngredient(ingredient);
                serviceAllergy.update(allergy);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                allergy.setUser(user);
                allergy.setIngredient(ingredient);
                serviceAllergy.insert(allergy);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadAllergies();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Allergy :" + e.getStackTrace());
        }
    }
    
    public void editAllergy() {
        try {
            if (this.allergySelect.getId() > 0) {
                this.allergy = allergySelect;
            } else {
                Message.messageInfo("Debe seleccionar una alergia");
            }
        } catch (Exception e) {
            Message.messageError("Error Allergy :" + e.getMessage());
        }

    }

    public void deleteAllergy() {
        try {
            if (this.allergySelect != null) {
                serviceAllergy.delete(allergySelect);
                loadAllergies();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }
    
    public void selectAllergy(SelectEvent e) {
        this.allergySelect = (Allergy) e.getObject();
    }

    public void clearForm() {
        this.allergy = new Allergy();
        this.allergySelect = null;
    }

    public IServiceIngredient getServiceIngredient() {
        return serviceIngredient;
    }

    public void setServiceIngredient(IServiceIngredient serviceIngredient) {
        this.serviceIngredient = serviceIngredient;
    }

    public IServiceUser getServiceUser() {
        return serviceUser;
    }

    public void setServiceUser(IServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    public IServiceAllergy getServiceAllergy() {
        return serviceAllergy;
    }

    public void setServiceAllergy(IServiceAllergy serviceAllergy) {
        this.serviceAllergy = serviceAllergy;
    }

    public Allergy getAllergy() {
        return allergy;
    }

    public void setAllergy(Allergy allergy) {
        this.allergy = allergy;
    }

    public Allergy getAllergySelect() {
        return allergySelect;
    }

    public void setAllergySelect(Allergy allergySelect) {
        this.allergySelect = allergySelect;
    }

    public List<Allergy> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<Allergy> allergies) {
        this.allergies = allergies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    
}
