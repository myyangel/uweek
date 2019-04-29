package com.uweek.controller;

import com.uweek.business.IServicePermission;
import com.uweek.business.IServiceRole;
import com.uweek.entity.Permission;
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
public class ControllerPermission implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private IServiceRole serviceRole;

    @Inject
    private IServicePermission servicePermission;

    private Permission permission;
    private Permission permissionSelect;
    private List<Permission> permissions;

    private Role role;
    private List<Role> roles;
    
    @PostConstruct
    public void init() {
        permission = new Permission();
        permissionSelect = new Permission();
        this.loadPermissions();
        this.loadRoles();
    }

    public void loadPermissions() {
        try {
            this.permissions = servicePermission.list();
        } catch (Exception e) {
            Message.messageError("Error Permiso: " + e.getMessage());
        }
    }

    private void loadRoles() {
        try {
            this.roles = serviceRole.list();
        } catch (Exception e) {

        }
    }
    
    public void savePermission() {
        try {
            if (permission.getId()!= null) {
                permission.setRole(role);
                servicePermission.update(permission);
                Message.messageInfo("Registro actualizado exitosamente");
            } else {
                permission.setRole(role);
                servicePermission.insert(permission);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadPermissions();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Permiso :" + e.getStackTrace());
        }
    }

    public void editPermission() {
        try {
            if (this.permissionSelect.getId() > 0) {
                this.permission = permissionSelect;
            } else {
                Message.messageInfo("Debe seleccionar un permiso");
            }
        } catch (Exception e) {
            Message.messageError("Error Permiso: " + e.getMessage());
        }

    }
    
    public void deletePermission() {
        try {
            if (this.permissionSelect != null) {
                servicePermission.delete(permissionSelect);
                loadPermissions();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectPermission(SelectEvent e) {
        this.permissionSelect = (Permission) e.getObject();
    }

    public void clearForm() {
        this.permission = new Permission();
        this.permissionSelect = null;
    }

    public IServiceRole getServiceRole() {
        return serviceRole;
    }

    public void setServiceRole(IServiceRole serviceRole) {
        this.serviceRole = serviceRole;
    }

    public IServicePermission getServicePermission() {
        return servicePermission;
    }

    public void setServicePermission(IServicePermission servicePermission) {
        this.servicePermission = servicePermission;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Permission getPermissionSelect() {
        return permissionSelect;
    }

    public void setPermissionSelect(Permission permissionSelect) {
        this.permissionSelect = permissionSelect;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role rol) {
        this.role = rol;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }


    
}