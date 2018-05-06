/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.servlets.model;

import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import javax.servlet.http.HttpSession;

/**
 *
 * @author killuminatti08
 */
public class Sessao {

    public boolean Sessao(HttpSession sessao) {

        System.out.println((sessao.getLastAccessedTime()/60000) + " tempo acessado aqui");

        boolean sessaovalida = false;
        if ((sessao.getLastAccessedTime() / 60000) < 1800) {
            sessaovalida = true;
        } else {
            sessaovalida = false;

            //sessao.invalidate();
        }
        return sessaovalida;

    }

}
