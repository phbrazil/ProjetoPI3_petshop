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
public class Cliente {

    private int clienteid;
    private String nomeCliente;
    private String logradouro;
    private String RG;
    private String cpfCliente;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;
    private String UF;
    private String pais;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String sexo;
    private String estadoCivil;
    private String nascimento;
    private boolean statusCliente;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(boolean statusCliente) {
        this.statusCliente = statusCliente;
    }
    

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    private java.util.List<Cliente> listaCliente = new ArrayList<Cliente>();

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(Cliente clientes) {
        listaCliente.add(clientes);
    }

    public Cliente(String cpfCliente, String nascimento, String nomeCliente, String logradouro, 
            String bairro, String cidade, String cep, String estado, String UF, String email,
            String sexo, String telefone,String celular, String RG, String pais, String estadoCivil) {
        this.cpfCliente = cpfCliente;
        this.nascimento = nascimento;
        this.nomeCliente = nomeCliente;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.UF = UF;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
        this.RG = RG;
        this.pais = pais;
        this.celular = celular;
        this.estadoCivil = estadoCivil;

    }

    public String getCPFCliente() {
        return cpfCliente;
    }

    public void getCPFCliente(String cpfcliente) {
        this.cpfCliente = cpfcliente;
    }

   

    public Cliente obterClienteLista(String cpf) {
        if (!listaCliente.isEmpty()) {
            for (int i = 0; i < listaCliente.size(); i++) {
                if (listaCliente.get(i) != null && listaCliente.get(i).getCPFCliente().toUpperCase().equals(cpf.toUpperCase())) {
                    return listaCliente.get(i);

                }
            }
        }
        return null;
    }

    public String getCpfcliente() {
        return cpfCliente;
    }

    public void setCPFcliente(String cpfcliente) {
        this.cpfCliente = cpfcliente;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }


    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

}
