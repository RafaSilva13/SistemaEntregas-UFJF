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
public class Entregador extends Usuario {
    
    private String nome;
    private int identificadorEntregador;
    private Cpf cpf;
    private Email email;
    private Telefone numeroDeTelefone;
    private int quantidadeDeEntregas;
    
    public Entregador(String nome,Cpf cpf, Email email, Telefone numeroDeTelefone, String usuario, String senha) {
        super(usuario, senha);
        this.nome = nome;
        this.identificadorEntregador = criaIdentificador();
        this.cpf = cpf;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.quantidadeDeEntregas = 0;
    }
    
     //retorna identifacor aleatorio (mas ainda não esta armazenando os que ja foram criados - usar a persistencia)
    public int criaIdentificador() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    public int retornaCodigoIdentificador() {
        return identificadorEntregador;
    }
    
    public void listarPedidosEntregues(){
        //PUXA AS ENTREGAS DA CLASSE ENTREGA
    }
     
    public void verificarQuantidadeDeEntregas(){
        System.out.println("Quantidade de entregas feitas por " + this.nome + " é : " + this.quantidadeDeEntregas);
    }


    @Override
    public boolean fazLogin(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Entregador{" + "nome=" + nome + ", identificadorEntregador=" + identificadorEntregador + ", numeroDeTelefone=" + numeroDeTelefone + '}';
    }
    
    
    
}
