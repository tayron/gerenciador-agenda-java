/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.bean;

import br.com.agenda.dao.UsuarioDao;
import br.com.agenda.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean que gerencia as requisições para manipulação 
 * dos dados de usuario
 * 
 * @author Tayron Miranda <dev@tayron.com.br>
 */
@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean extends BeanAbstrato implements Serializable{

    /**
     * Armazena através de injeção de dependência o DAO 
     * de manipulação dos dados do usuario
     */
    @EJB
    private UsuarioDao usuarioDao;
   
    /**
     * Armazena entidade Usuario para criação ou edição
     */
    private Usuario usuario;
    
    /**
     * Armazena uma lista de usuários existente já cadastrado
     */
    private List<Usuario> listaUsuarios;
   
    /**
     * Cria uma nova instancia de contato e popula a lista de usuários
     * já cadastrados
     */
    @PostConstruct
    public void init() {
        usuario = new Usuario();
        listaUsuarios = usuarioDao.buscarTodos();
    }

    /**
     * Retorna um usuario
     * 
     * @return Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Seta um usuario
     * 
     * @param usuario Objeto usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Retorna uma lista de usuários já cadastrados
     * 
     * @return List Lista de usuários 
     */
    public List<Usuario> getListaUsuarios(){
        return listaUsuarios;
    }

    /**
     * Seta uma lista de usuários
     * 
     * @param listaUsuario Lista de usuários
     */
    public void setListaUsuarios(List<Usuario> listaUsuario){
        this.listaUsuarios = listaUsuario;
    }

    /**
     * Analisa e salva os dados do usuario
     */
    public void salvarUsuario() {
        try {
            if(usuario.getId() == null){
                usuarioDao.criar(usuario);    
                setMensagemSucesso("Usuário criado com sucesso!");
                usuario = new Usuario();
            }else{
                usuarioDao.editar(usuario);
                setMensagemSucesso("Usuário alterado com sucesso!");
            }
            
            listaUsuarios = usuarioDao.buscarTodos();             
            
        } catch (Exception e) {
            setMensagemErro("Não foi possível criar o usuário", e.getMessage());
        }

    }
    
    /**
     * Excliu um usuários já cadastrado
     * 
     * @param usuario Objeto usuario
     */
    public void excluirUsuario(Usuario usuario){

        try{
            usuarioDao.remover(usuario);
            listaUsuarios = usuarioDao.buscarTodos();
            setMensagemSucesso("Usuário excluído com sucesso");
        }catch(Exception e){
            setMensagemErro("Não foi possível excluir o usuário", e.getMessage());
        }
    }
    
}