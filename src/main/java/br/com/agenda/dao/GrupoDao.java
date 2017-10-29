/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import br.com.agenda.entidade.Grupo;
import javax.ejb.Stateless;

/**
 * Dao Contato que disponibiliza recursos para gerencia os dados de grupo de usuário
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@Stateless
public class GrupoDao extends DaoAbstrato<Grupo> {

    /**
     * Construtor da classe
     */
    public GrupoDao() {
        super(Grupo.class);
    }
    
}
