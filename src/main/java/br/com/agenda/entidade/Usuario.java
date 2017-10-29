/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.entidade;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Descrição da Entidade Contato para persistir dados de usuario
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@Entity
@Table(name="usuarios")
public class Usuario extends EntidadeAbstrata {

    /**
     * Atributo pelo qual o container usa para serializar e desserializar objetos
     */
    protected static final long serialVersionUID = 1L;
   
    /**
     * 
     */
    @ManyToMany(mappedBy = "usuarios")
    private List<Grupo> grupos;
    
    /**
     * Definição do atributo nome do usuario
     */
    @Column(name="nome")
    private String nome;

    /**
     * Definição do atributo senha do usuario
     */
    @Column(name="senha")
    private String senha;
    
    /**
     * Retorna o nome do usuario
     * 
     * @return nome Nome do usuario
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome do usuario
     * 
     * @param nome Nome do usuario 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna senha do usuário
     * 
     * @return senha Senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Seta senha do usuário
     * 
     * @param senha senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }  

    /**
     * Retorna lista de grupos
     * 
     * @return grupos Lista de grupos
     */
    public List<Grupo> getGrupos() {
        return grupos;
    }

    /**
     * Seta um grupo numa lista de grupos
     * 
     * @param grupos Grupo de usuário 
     */
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }    
    
    
    /**
     * Retorna string com todas as informações do usuario
     * 
     * @return String Informações do usuario 
     */
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + '}';
    }
}