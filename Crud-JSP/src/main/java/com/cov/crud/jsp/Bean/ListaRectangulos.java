package com.cov.crud.jsp.Bean;

import java.util.ArrayList;
import java.util.List;

public class ListaRectangulos
{
    private List<Rectangulo> lista;

    public ListaRectangulos()
    {
        lista = new ArrayList<>();
    }
    
    public void setRectangulo(Rectangulo rectangulo)
    {
        lista.add(rectangulo);
    }

    public List<Rectangulo> getLista()
    {
        return lista;
    }

    public void setLista(List<Rectangulo> lista)
    {
        this.lista = lista;
    }
}
