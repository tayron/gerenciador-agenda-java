/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.entidade;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Descrição da Entidade Contato para persistir dados de grupo
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@Entity
@Table(name="grupos")
public class Grupo extends EntidadeAbstrata {

    /**
     * Atributo pelo qual o container usa para serializar e desserializar objetos
     */
    protected static final long serialVersionUID = 1L;
    
    /**
     * Mapeamento para tabela usuarios_grupos
     */
    @ManyToMany
    @JoinTable(
            name="usuarios_grupos",
            joinColumns = @JoinColumn(
                    name="grupo_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="usuario_id",
                    referencedColumnName = "id"
            )
    )
    private List<Usuario> usuarios;
    
    /**
     * Definição do atributo nome do grupo
     */
    @Column(name="nome")
    private String nome;

    /**
     * Retorna o nome do grupo
     * 
     * @return nome Nome do grupo
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta o nome do grupo
     * 
     * @param nome Nome do grupo 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna uma lista de usuários
     * 
     * @return usuarios Lista de usuários 
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Seta um usuário numa lista de usuários
     * 
     * @param usuarios Usuário 
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    /**
     * Retorna string com todas as informações do grupo
     * 
     * @return String Informações do grupo 
     */
    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + '}';
    }
}