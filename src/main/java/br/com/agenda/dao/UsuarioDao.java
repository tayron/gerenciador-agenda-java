/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import br.com.agenda.entidade.Usuario;
import javax.ejb.Stateless;

/**
 * Dao Contato que disponibiliza recursos para gerencia os dados de usuário
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@Stateless
public class UsuarioDao extends DaoAbstrato<Usuario> {

    /**
     * Construtor da classe
     */
    public UsuarioDao() {
        super(Usuario.class);
    }
    
}
