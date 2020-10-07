package com.cov.crud.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.cov.crud.model.Auto;
import com.cov.crud.util.CommonUtils;

@ManagedBean
@SessionScoped
public class CrudBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Auto> list;
    private Auto item = new Auto();
    private Auto beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value="#{commonUtils}")
	private CommonUtils util;
	public void setUtil(CommonUtils util) {
		this.util = util;
	}

    @PostConstruct
    public void init() {
        list = new ArrayList<Auto>();
    }

    public void add() {
    	// DAO save the add
        item.setId(list.isEmpty() ? 1 : list.get(list.size() - 1).getId() + 1);
        list.add(item);
        item = new Auto();

        util.redirectWithGet();
    }

    public void resetAdd() {
    	item = new Auto();

    	util.redirectWithGet();
    }

    public void edit(Auto item) {
    	beforeEditItem = item.copy();
        this.item = item;
        edit = true;

        util.redirectWithGet();
    }

    public void cancelEdit() {
    	this.item.restore(beforeEditItem);
        this.item = new Auto();
        edit = false;

        util.redirectWithGet();
    }

    public void saveEdit() {
    	// DAO save the edit
        this.item = new Auto();
        edit = false;

        util.redirectWithGet();
    }

    public void delete(Auto item) throws IOException {
    	// DAO save the delete
        list.remove(item);

        util.redirectWithGet();
    }

    public List<Auto> getList() {
        return list;
    }

    public Auto getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }


}
