/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author paulo.bezerra
 */
public class Grupo {

    private int grupoid;
    private String nomeGrupo;
    private String idloja;
    
    public int getGrupoid() {
        return grupoid;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void getNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }
    
    public String getIdLoja() {
        return idloja;
    }
    
    public void setIdLoja(String idloja) {
        this.idloja = idloja;
    }

    private java.util.List<Grupo> listaGrupo = new ArrayList<Grupo>();

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(Grupo Grupos) {
        listaGrupo.add(Grupos);
    }

    public Grupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;

    }
    
     public Grupo(String nomeGrupo, String idloja) {
        this.nomeGrupo = nomeGrupo;
        this.idloja = idloja;
       
     }
   
    public Grupo obterGrupoLista(String id) {
        if (!listaGrupo.isEmpty()) {
            for (int i = 0; i < listaGrupo.size(); i++) {
                if (listaGrupo.get(i) != null) {
                    return listaGrupo.get(i);

                }
            }
        }
        return null;
    }


}
