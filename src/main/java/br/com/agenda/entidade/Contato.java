/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Descrição da Entidade Contato para persistir dados de contato
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@Entity
@Table(name="contatos")
public class Contato extends EntidadeAbstrata {

    /**
     * Atributo pelo qual o container usa para serializar e desserializar objetos
     */
    protected static final long serialVersionUID = 1L;
    
    /**
     * Definição do atributo nome do contato
     */
    @Column(name="nome")
    private String nome;

    /**
     * Retorna o nome do contato
     * 
     * @return nome Nome do contato
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome do contato
     * 
     * @param nome Nome do contato 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Retorna string com todas as informações do contato
     * 
     * @return String Informações do contato 
     */
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + '}';
    }
}