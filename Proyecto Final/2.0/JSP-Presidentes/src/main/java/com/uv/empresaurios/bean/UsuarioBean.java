package com.uv.empresaurios.bean;

import com.uv.empresaurios.dao.UsuarioDao;
import com.uv.empresaurios.model.Usuario;
import com.uv.empresaurios.util.CommonUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    private UsuarioDao usuarioDao;
    private Usuario usuario;
    
    public UsuarioBean() {
        usuarioDao = new UsuarioDao();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String verificarDatos() {
        Usuario usuario;
        String resultado = "";
        try {
            usuario = usuarioDao.verificarDatos(this.usuario);
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                resultado = "presidentes";
            } else {
                resultado = "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.usuario = new Usuario();
        return resultado;
    }

    public boolean verificarSesion() {
        boolean estado;

        if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }

    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public void add() {
        System.out.println(this.usuario.toString());
        usuarioDao.registry(this.usuario);
        this.usuario = new Usuario();
        util.redirectWithGet();
    }
    
    @ManagedProperty(value = "#{commonUtils}")
    private CommonUtils util;

    public void setUtil(CommonUtils util) {
        this.util = util;
    }
    
    public String navegaRegistro() {
        return "registro.xhtml";
    }
    
    public String navegaInicio() {
        return "index.xhtml";
    }
    
    public String navegaPartido() {
        return "partidos.xhtml";
    }
    
     public String navegaPresidente() {
        return "presidentes.xhtml";
    }
}