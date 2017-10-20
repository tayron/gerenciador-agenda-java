/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Managed bem abstrato 
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
public class BeanAbstrato {
    
    /**
     * Seta uma mensagem de sucesso
     *
     * @param mensagem String Mensagem de sucesso
     */
    public void setMensagemSucesso(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    /**
     * Seta uma mensagem de erro
     *
     * @param mensagem String Mensagem de erro
     * @param detalheErro stirng Detalhe do erro
     */
    public void setMensagemErro(String mensagem, String detalheErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, detalheErro));
    }
    
}
