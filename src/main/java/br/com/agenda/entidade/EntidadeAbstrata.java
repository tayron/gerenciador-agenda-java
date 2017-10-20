/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author tayron
 */
@MappedSuperclass
public abstract class EntidadeAbstrata implements Serializable {
    
    /**
     * Definição da coluna Id do contato
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    /**
     * Retorna id do contato
     *
     * @return Long Id do contato
     */
    public Long getId() {
        return id;
    }

    /**
     * Seta id do contato
     *
     * @param id Id do contato
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}