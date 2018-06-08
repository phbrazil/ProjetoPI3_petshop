/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author paulo.bezerra
 */
public class Usuario {

    private int usuarioid;
    private String nomeUsuario;
    private String username;
    private String password;
    private String idgrupo;
    
    public int getUsuarioId() {
        return usuarioid;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
     public String getIdGrupo() {
        return idgrupo;
    }

    public void setIdGrupo(String idgrupo) {
        this.idgrupo = idgrupo;
    }
    
    private java.util.List<Usuario> listaUsuario = new ArrayList<Usuario>();

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(Usuario Usuarios) {
        listaUsuario.add(Usuarios);
    }


    public Usuario(String nomeUsuario, String userName, String password, String idgrupo) {
        this.nomeUsuario = nomeUsuario;
        this.username = userName;
        this.password = password;
        this.idgrupo = idgrupo;
       
     }
   
    public Usuario obterUsuarioLista(String id) {
        if (!listaUsuario.isEmpty()) {
            for (int i = 0; i < listaUsuario.size(); i++) {
                if (listaUsuario.get(i) != null) {
                    return listaUsuario.get(i);

                }
            }
        }
        return null;
    }


}
