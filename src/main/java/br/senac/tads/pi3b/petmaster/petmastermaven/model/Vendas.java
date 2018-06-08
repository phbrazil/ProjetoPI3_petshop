/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3b.petmaster.petmastermaven.model;

/**
 *
 * @author killuminatti08
 */
public class Vendas {

    private int vendaid;
    private String CPFCliente;
    private double totalvalor;
    private String datavenda;
    private int quantidadeitensvenda;
    private int quantidadeitensproduto;
    private int idloja = 0;

    public int getIdloja() {
        return idloja;
    }

    public void setIdloja(int idloja) {
        this.idloja = idloja;
    }

    private String vendedor;

    public int getVendaID() {
        return vendaid;

    }

    public void setVendaID(int vendaid) {
        this.vendaid = vendaid;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public double getTotalValor() {
        return totalvalor;
    }

    public void setTotalValor(double totalvalor) {
        this.totalvalor = this.totalvalor + totalvalor;

    }

    public String getDataVenda() {
        return datavenda;
    }

    public void setDataVenda(String datavenda) {
        this.datavenda = datavenda;
    }

    public int getQuantidadeItensVenda() {
        return quantidadeitensvenda;

    }

    public void setQuantidadeItensVenda(int quantidadeitensvenda) {
        this.quantidadeitensvenda = this.quantidadeitensvenda + quantidadeitensvenda;
    }
    
    public int getQuantidadeItensProduto() {
        return quantidadeitensproduto;

    }

    public void setQuantidadeProduto(int quantidadeitensproduto) {
        this.quantidadeitensproduto = this.quantidadeitensproduto + quantidadeitensproduto;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getVendedor() {
        return vendedor;
    }

}
