/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import java.util.Random;

/**
 *
 * @author josemiguel
 */
public class Administrador extends Usuario{
    private int identificadorAdministrador;

    public Administrador(String usuario, String senha) {
        super(usuario, senha);
        this.identificadorAdministrador = criaIdentificador();
    }
    
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    public void retornaInformacoesCliente(Cliente cliente){
        //NÃO DEVERIA RETORNAR VOID, DEVERIA?
    }
    
    public void retornaInformacoesEntregador(Entregador entregador){
        //IDEM
    }
    
    public void verTodosPedidos(){
        
    }

    @Override
    public boolean fazLogin(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void verSaldoTotalDoAplicativo(){
        
    }
    
    //public void trocarArquivoDeSalvamento(FILE arquivo){
    //
    //}

    
    
    
}
