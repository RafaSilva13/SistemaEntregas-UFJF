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
public class Cliente extends Usuario {
    
    private String nome;
    private int identificadorCliente;
    private Cpf cpf;
    private int quantidadeDePedidos;
    private Telefone numeroDeTelefone;
    private Email email;

    public Cliente(String nome, Cpf cpf, Telefone numeroDeTelefone, Email email, String usuario, String senha) {
        super(usuario, senha);
        this.nome = nome;
        this.identificadorCliente = criaIdentificador();
        this.cpf = cpf;
        this.quantidadeDePedidos = 0;
        this.numeroDeTelefone = numeroDeTelefone;
        this.email = email;
    }
     

    //Acredito que verifica se os dados esão no json e se sim, faz login, se não, não faz
    @Override
    public boolean fazLogin(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public int retornaCodigoIdentificador(){
        return this.identificadorCliente;
    }
   
    public void verPedidos(){
        System.out.println("Número de pedidos do cliente " + this.nome + " é : " + this.quantidadeDePedidos);
    }

    //Cria um numero aleatorio de identificador e falta salá-lo no json
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    

    
}
