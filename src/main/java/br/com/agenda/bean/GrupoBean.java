/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.bean;

import br.com.agenda.dao.GrupoDao;
import br.com.agenda.entidade.Grupo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean que gerencia as requisições para manipulação 
 * dos dados de grupo de usuário
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@ManagedBean(name="grupoBean")
@RequestScoped
public class GrupoBean extends BeanAbstrato implements Serializable{

    /**
     * Armazena através de injeção de dependência o DAO 
     * de manipulação dos dados do grupo de usuário
     */
    @EJB
    private GrupoDao grupoDao;
   
    /**
     * Armazena entidade Grupo para criação ou edição
     */
    private Grupo grupo;
    
    /**
     * Armazena uma lista de grupos existente já cadastrado
     */
    private List<Grupo> listaGrupos;
   
    /**
     * Cria uma nova instancia de grupo e popula a lista de grupos já cadastrados
     */
    @PostConstruct
    public void init() {
        grupo = new Grupo();
        listaGrupos = grupoDao.buscarTodos();
    }

    /**
     * Retorna um grupo
     * 
     * @return Grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Seta um grupo
     * 
     * @param grupo Objeto grupo
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    /**
     * Retorna uma lista de grupos de usuários já cadastrados
     * 
     * @return List Lista de grupos
     */
    public List<Grupo> getListaGrupos(){
        return listaGrupos;
    }

    /**
     * Seta uma lista de grupos
     * 
     * @param listaGrupos Lista de grupos
     */
    public void setListaGrupos(List<Grupo> listaGrupos){
        this.listaGrupos = listaGrupos;
    }

    /**
     * Analisa e salva os dados do grupo
     */
    public void salvarGrupo() {
        try {
            if(grupo.getId() == null){
                grupoDao.criar(grupo);    
                setMensagemSucesso("Grupo criado com sucesso!");
                grupo = new Grupo();
            }else{
                grupoDao.editar(grupo);
                setMensagemSucesso("Grupo alterado com sucesso!");
            }
            
            listaGrupos = grupoDao.buscarTodos();             
            
        } catch (Exception e) {
            setMensagemErro("Não foi possível criar o grupo", e.getMessage());
        }

    }
    
    /**
     * Excliu um grupo já cadastrado
     * 
     * @param grupo Objeto grupo
     */
    public void excluirGrupo(Grupo grupo){

        try{
            grupoDao.remover(grupo);
            listaGrupos = grupoDao.buscarTodos();
            setMensagemSucesso("Grupo excluído com sucesso");
        }catch(Exception e){
            setMensagemErro("Não foi possível excluir o grupo", e.getMessage());
        }
    }
    
}