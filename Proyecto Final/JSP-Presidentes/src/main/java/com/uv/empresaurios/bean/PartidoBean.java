package com.uv.empresaurios.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.uv.empresaurios.model.Partido;
import com.uv.empresaurios.dao.PartidoDao;
import com.uv.empresaurios.util.CommonUtils;

@ManagedBean
@SessionScoped
public class PartidoBean implements Serializable {
    private List<Partido> partidos;
    private Partido item = new Partido();
    private Partido beforeEditItem = null;
    private boolean edit;

    @ManagedProperty(value = "#{commonUtils}")
    private CommonUtils util;
    private PartidoDao partidoDao;

    public void setUtil(CommonUtils util) {
        this.util = util;
    }

    @PostConstruct
    public void init() {
        partidoDao = new PartidoDao();
        updateList();
    }

    private void updateList() {
        partidos = new ArrayList<>();
        partidos.addAll(partidoDao.findAll());
    }

    public void add() {
        partidoDao.insert(item);
        item = new Partido();
        util.redirectWithGet();
        updateList();
    }

    public void resetAdd() {
        item = new Partido();
        util.redirectWithGet();
    }

    public void edit(Partido item) {
        beforeEditItem = item.copy();
        this.item = item;
        edit = true;

        util.redirectWithGet();
    }

    public void cancelEdit() {
        this.item.restore(beforeEditItem);
        this.item = new Partido();
        edit = false;

        util.redirectWithGet();
    }

    public void saveEdit() {
        partidoDao.update(item);
        this.item = new Partido();
        edit = false;

        util.redirectWithGet();
        updateList();
    }

    public void delete(Partido item) throws IOException {
        partidoDao.delete(item.getId());

        util.redirectWithGet();
        updateList();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public Partido getItem() {
        return this.item;
    }

    public boolean isEdit() {
        return this.edit;
    }
}
