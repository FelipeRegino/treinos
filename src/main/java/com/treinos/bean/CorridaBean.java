package com.treinos.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean
public class CorridaBean {

    //region [ Variáveis globais ]

    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

    //endregion

    public void CorridaRedirect(){
        try {
            externalContext.redirect("corrida.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void IndexRedirect(){
        try {
            externalContext.redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
