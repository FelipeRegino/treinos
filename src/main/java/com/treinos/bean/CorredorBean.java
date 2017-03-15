package com.treinos.bean;

import com.treinos.entity.Corredor;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CorredorBean {

    //region [ Variáveis globais ]

    private Corredor corredor = new Corredor();
    private List<Corredor> listaCorredor = new ArrayList<Corredor>();
    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    //endregion

    public void adicionarCorredor(){
        corredor.inserir(corredor);
        corredor = new Corredor();
        indexRedirect();
    }

    public void listarCorredor(){
        listaCorredor = corredor.obterTodos();
    }

    public void corredorRedirect(){
        try {
            externalContext.redirect("corredor.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void indexRedirect(){
        try {
            externalContext.redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //region [ Getters & setters ]

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public List<Corredor> getListaCorredor() {
        return listaCorredor;
    }

    public void setListaCorredor(List<Corredor> listaCorredor) {
        this.listaCorredor = listaCorredor;
    }

    //endregion
}
