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

import com.uweek.business.implementation.ServiceRole;
import com.uweek.entity.Role;
import com.uweek.util.Message;

/**
 *
 * @author arman
 */
@Named
@ViewScoped
public class ControllerRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ServiceRole serviceRole;

    private Role role;
    private Role roleSelect;
    private List<Role> roles;

    @PostConstruct
    public void init() {
        role = new Role();
        roleSelect = new Role();
        loadRoles();
    }

    public void loadRoles() {
        try {
            this.roles = serviceRole.list();
        } catch (Exception e) {
            Message.messageError("Error Rol: " + e.getMessage());
        }
    }

    public void saveRole() {
        try {
            if (role.getId() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                serviceRole.update(role);
            } else {
                serviceRole.insert(role);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadRoles();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Rol :" + e.getStackTrace());
        }
    }

    public void editRole() {
        try {
            if (this.roleSelect != null) {
                this.role = roleSelect;
            } else {
                Message.messageInfo("Debe seleccionar un rol");
            }
        } catch (Exception e) {
            Message.messageError("Error Rol :" + e.getMessage());
        }

    }

    public void deleteRole() {
        try {
            if (this.roleSelect != null) {
                serviceRole.delete(roleSelect);
                loadRoles();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectRole(SelectEvent e) {
        this.roleSelect = (Role) e.getObject();
    }

    public void clearForm() {
        this.role = new Role();
        this.roleSelect = null;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRoleSelect() {
        return roleSelect;
    }

    public void setRoleSelect(Role roleSelect) {
        this.roleSelect = roleSelect;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
