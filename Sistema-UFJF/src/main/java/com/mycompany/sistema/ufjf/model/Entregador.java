/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import java.util.Random;

/**
 *
 * @author sihuanb
 */
public class Entregador extends Usuario {
    
    private String nome;
    private int identificadorEntregador;
    private Cpf cpf;
    private Email email;
    private Telefone numeroDeTelefone;
    private int quantidadeDeEntregas;
    private int identificadorVeiculo;
    

    public Entregador(String nome,Cpf cpf, Email email, Telefone numeroDeTelefone, int quantidadeDeEntregas, String usuario, String senha) {
        super(usuario, senha);
        this.nome = nome;
        this.identificadorEntregador = criaIdentificador();
        this.cpf = cpf;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.quantidadeDeEntregas = quantidadeDeEntregas;
        this.identificadorVeiculo = criaIdentificador();
    }

    @Override
    public boolean validaInformacoes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int fazLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     //retorna identifacor aleatorio (mas ainda não esta armazenando os que ja foram criados - usar a persistencia)
    public int criaIdentificador() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    public int retornaCodigoIdentificador() {
        return identificadorEntregador;
    }
    
    
    
}
