package com.uweek.controller;

import com.uweek.business.IServiceUserRole;
import com.uweek.business.IServiceUser;
import com.uweek.business.IServiceRole;
import com.uweek.entity.UserRole;
import com.uweek.entity.User;
import com.uweek.entity.Role;
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
public class ControllerUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IServiceUser serviceUser;
    
    @Inject
    private IServiceRole serviceRole;

    @Inject
    private IServiceUserRole serviceUserRole;

    private UserRole userRole;
    private UserRole userRoleSelect;
    private List<UserRole> usersRoles;

    private User user;
    private List<User> users;
    
    private Role role;
    private List<Role> roles;

    @PostConstruct
    public void init() {
        userRole = new UserRole();
        userRoleSelect = new UserRole();
        this.loadUsersRoles();
        this.loadUsers();
        this.loadRoles();
    }

    public void loadUsersRoles() {
        try {
            this.usersRoles = serviceUserRole.list();
        } catch (Exception e) {
            Message.messageError("Error UserRole: " + e.getMessage());
        }
    }

    private void loadUsers() {
        try {
            this.users = serviceUser.list();
        } catch (Exception e) {

        }
    }
    
    private void loadRoles() {
        try {
            this.roles = serviceRole.list();
        } catch (Exception e) {

        }
    }

    public void saveUserRole() {
        try {
            if (userRole.getId() != null) {
                userRole.setUser(user);
                userRole.setRole(role);
                serviceUserRole.update(userRole);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                userRole.setUser(user);
                userRole.setRole(role);
                serviceUserRole.insert(userRole);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadUsersRoles();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error UsuarioRole :" + e.getStackTrace());
        }
    }

    public void editUserRole() {
        try {
            if (this.userRoleSelect.getId() > 0) {
                this.userRole = userRoleSelect;
            } else {
                Message.messageInfo("Debe seleccionar un usuarioRole");
            }
        } catch (Exception e) {
            Message.messageError("Error UsuarioRole :" + e.getMessage());
        }

    }

    public void deleteUserRole() {
        try {
            if (this.userRoleSelect != null) {
                serviceUserRole.delete(userRoleSelect);
                loadUsersRoles();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectUserRole(SelectEvent e) {
        this.userRoleSelect = (UserRole) e.getObject();
    }

    public void clearForm() {
        this.userRole = new UserRole();
        this.userRoleSelect = null;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setDish(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRoleSelect() {
        return userRoleSelect;
    }

    public void setUserRoleSelect(UserRole userRoleSelect) {
        this.userRoleSelect = userRoleSelect;
    }

    public List<UserRole> getUsersRoles() {
        return usersRoles;
    }

    public void setUsersRoles(List<UserRole> usersRoles) {
        this.usersRoles = usersRoles;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
