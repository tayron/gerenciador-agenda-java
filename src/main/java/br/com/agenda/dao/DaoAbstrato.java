/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
public abstract class DaoAbstrato<T> {

    private Class<T> entityClass;

    /**
     * Injeção da de um Entity Manager
     */    
    @PersistenceContext(unitName = "mysql_banco_agenda")
    private EntityManager em;

    /**
     * Método que retorna um Entity Manager
     * 
     * @return Entity Manager
     */    
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * Constutor da classe
     * 
     * @param entityClass 
     */
    public DaoAbstrato(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Persiste um objeto no banco
     * 
     * @param entity Entidade a ser persistida 
     */
    public void criar(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * Altera um objeto no banco
     * 
     * @param entity Entidade a ser alterada
     */    
    public void editar(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * Remove um objeto no banco
     * 
     * @param entity Entidade a ser removida
     */    
    public void remover(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * Busca uma entidade no banco através do seu id
     * 
     * @param id Id da entidade no banco
     * @return entity Entidade encontrada no banco
     */    
    public T buscarPorId(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * Busca e retorna uma lista de objetos do banco
     * 
     * @return List Lista de objetos encontrados
     */    
    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * Busca e retorna uma lista de objetos no banco por range
     * 
     * @param range Lista de inteiro contento o range por exemplo [0, 5]
     * @return List Lista de objetos encontrados
     */
    public List<T> buscarPorRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * Conta e retorna o número de registros existente no banco 
     * 
     * @return Long número de registro encontrados  
     */
    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
