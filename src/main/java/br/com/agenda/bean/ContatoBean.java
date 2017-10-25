/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.bean;

import br.com.agenda.entidade.Contato;
import br.com.agenda.dao.ContatoDao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean que gerencia as requisições para manipulação 
 * dos dados de contato
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@ManagedBean(name="contatoBean")
@RequestScoped
public class ContatoBean extends BeanAbstrato implements Serializable{

    /**
     * Armazena através de injeção de dependência o DAO 
     * de manipulação dos dados do contato
     */
    @EJB
    private ContatoDao contatoDao;
   
    /**
     * Armazena entidade Contato para criação ou edição
     */
    private Contato contato;
    
    /**
     * Armazena uma lista de contatos existente já cadastrado
     */
    private List<Contato> listaContatos;
   
    /**
     * Cria uma nova instancia de contato e popula a lista de contatos
     * já cadastrados
     */
    @PostConstruct
    public void init() {
        contato = new Contato();
        listaContatos = contatoDao.buscarTodos();
    }

    /**
     * Retorna um contato
     * 
     * @return Contato
     */
    public Contato getContato() {
        return contato;
    }

    /**
     * Seta um contato
     * 
     * @param contato Objeto contato
     */
    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    /**
     * Retorna uma lista de contatos já cadastrados
     * 
     * @return List Lista de contatos 
     */
    public List<Contato> getListaContatos(){
        return listaContatos;
    }

    /**
     * Seta uma lista e contatos
     * 
     * @param listaContato Lista de contatos
     */
    public void setListaContatos(List<Contato> listaContato){
        this.listaContatos = listaContato;
    }

    /**
     * Analisa e salva os dados do contato
     */
    public void salvarContato() {
        try {
            if(contato.getId() == null){
                contatoDao.criar(contato);    
                setMensagemSucesso("Contato criado com sucesso!");
                contato = new Contato();
            }else{
                contatoDao.editar(contato);
                setMensagemSucesso("Contato alterado com sucesso!");
            }
            
            listaContatos = contatoDao.buscarTodos();             
            
        } catch (Exception e) {
            setMensagemErro("Não foi possível criar o contato", e.getMessage());
        }

    }
    
    /**
     * Excliu um contato já cadastrado
     * 
     * @param contato Objeto contato
     */
    public void excluirContato(Contato contato){

        try{
            contatoDao.remover(contato);
            listaContatos = contatoDao.buscarTodos();
            setMensagemSucesso("Contato excluído com sucesso");
        }catch(Exception e){
            setMensagemErro("Não foi possível excluir o contato", e.getMessage());
        }
    }
    
}