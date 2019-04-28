package com.uweek.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;


import com.uweek.entity.User;
import com.uweek.util.Message;
import com.uweek.business.IServiceUser;

@Named
@ViewScoped
public class ControllerUser implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Inject
	private IServiceUser userBusiness;

	private User user;
	private User userSele;

	private List<User> users;

	

	@PostConstruct
	public void init() {
		user = new User();
		userSele = new User();
		users = new ArrayList<>();

		this.listUsers();
	}

	public void listUsers() {
		try {
			users = userBusiness.list();
		} catch (Exception e) {
			Message.messageError("Error User :" + e.getMessage());
		}
	}

	public void findUser() {
		try {
			this.users = userBusiness.findByName(this.user.getName());
			if (users.isEmpty()) {
				Message.messageInfo("No existe usuario");
			}
		} catch (Exception e) {
			Message.messageError("Error User :" + e.getMessage());
		}
	}

	public void saveUser() {
		try {

			if (user.getId() != 0) {
				userBusiness.update(user);
				Message.messageInfo("Registro actualizado exitosamente");
			} else {

				userBusiness.insert(user);
				Message.messageInfo("Registro guardado exitosamente");

			}
			listUsers();
			resetForm();
		} catch (Exception e) {
			Message.messageError("Error User :" + e.getMessage());
		}
	}

	public void editUser() {
		try {
			System.out.println("User Selec:" + userSele.getName());
			if (this.userSele.getId() > 0) {
				this.user = userSele;
			} else {
				Message.messageInfo("Debe seleccionar un usuario");
				
			}

		} catch (Exception e) {
			Message.messageError("Error Usuario :" + e.getMessage());
		}

	}

	public void resetForm() {
		this.user = new User();
		this.userSele = null;
	}

	public void selecUser(SelectEvent e) {
		this.userSele = (User) e.getObject();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserSele() {
		return userSele;
	}

	public void setUserSele(User userSele) {
		this.userSele = userSele;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}