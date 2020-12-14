package com.uv.empresaurios.bean;

import com.uv.empresaurios.dao.PartidoDao;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.uv.empresaurios.model.Presidente;
import com.uv.empresaurios.dao.PresidenteDao;
import com.uv.empresaurios.model.Partido;
import com.uv.empresaurios.util.CommonUtils;

@ManagedBean
@SessionScoped
public class PresidenteBean implements Serializable{
    private List<Presidente> presidentes;
    private Presidente item = new Presidente();
    private Presidente beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value = "#{commonUtils}")
    private CommonUtils util;
    private PresidenteDao presidenteDao;

    public void setUtil(CommonUtils util) {
        this.util = util;
    }

    @PostConstruct
    public void init() {
        presidenteDao = new PresidenteDao();
        updateList();
    }

    private void updateList() {
        presidentes = new ArrayList<>();
        presidentes.addAll(presidenteDao.findAll());
    }

    public void add() {
        presidenteDao.insert(item);
        item = new Presidente();
        util.redirectWithGet();
        updateList();
    }

    public void resetAdd() {
        item = new Presidente();
        util.redirectWithGet();
    }

    public void edit(Presidente item) {
        beforeEditItem = item.copy();
        this.item = item;
        edit = true;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new Presidente();
        edit = false;

        util.redirectWithGet();
    }

    public void saveEdit() {
        presidenteDao.update(item);
        this.item = new Presidente();
        edit = false;

        util.redirectWithGet();
        updateList();
    }

    public void delete(Presidente item) throws IOException {
        presidenteDao.delete(item.getId());

        util.redirectWithGet();
        updateList();
    }

    public List<Presidente> getPresidentes() {
        return presidentes;
    }

    public Presidente getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}
