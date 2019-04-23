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

import com.uweek.business.implementation.ServicePlan;
import com.uweek.entity.Plan;
import com.uweek.util.Message;

/**
 *
 * @author arman
 */
@Named
@ViewScoped
public class ControllerPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ServicePlan servicePlan;

    private Plan plan;
    private Plan planSelect;
    private List<Plan> plans;

    @PostConstruct
    public void init() {
        plan = new Plan();
        planSelect = new Plan();
        loadPlans();
    }

    public void loadPlans() {
        try {
            this.plans = servicePlan.list();
        } catch (Exception e) {
            Message.messageError("Error Plan: " + e.getMessage());
        }
    }

    public void savePlan() {
        try {
            if (plan.getId() != null) {

                Message.messageInfo("Registro actualizado exitosamente");
                servicePlan.update(plan);
            } else {
                servicePlan.insert(plan);
                Message.messageInfo("Registro guardado exitosamente");

            }
            loadPlans();
            clearForm();
        } catch (Exception e) {
            Message.messageError("Error Plan :" + e.getStackTrace());
        }
    }

    public void editPlan() {
        try {
            if (this.planSelect != null) {
                this.plan = planSelect;
            } else {
                Message.messageInfo("Debe seleccionar un plan");
            }
        } catch (Exception e) {
            Message.messageError("Error Plan :" + e.getMessage());
        }

    }

    public void deletePlan() {
        try {
            if (this.planSelect != null) {
                servicePlan.delete(planSelect);
                loadPlans();
                clearForm();

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void selectPlan(SelectEvent e) {
        this.planSelect = (Plan) e.getObject();
    }

    public void clearForm() {
        this.plan = new Plan();
        this.planSelect = null;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlanSelect() {
        return planSelect;
    }

    public void setPlanSelect(Plan planSelect) {
        this.planSelect = planSelect;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setCategorys(List<Plan> plans) {
        this.plans = plans;
    }

}
