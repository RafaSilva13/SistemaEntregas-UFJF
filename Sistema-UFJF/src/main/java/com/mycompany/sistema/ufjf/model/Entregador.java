package com.mycompany.sistema.ufjf.model;

import java.util.Random;

public class Entregador extends Usuario {
    
    private int identificadorEntregador;
    private String nome;
    private Cpf cpf;
    private Email email;
    private Telefone numeroDeTelefone;
    private int quantidadeDeEntregas;
    
    public void Entregador() {
    }
    
    public Entregador(String nome,Cpf cpf, Email email, Telefone numeroDeTelefone, String usuario, String senha) {
        super(usuario, senha);
        this.nome = nome;
        this.identificadorEntregador = 2;
        this.cpf = cpf;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.quantidadeDeEntregas = 0;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public Email getEmail() {
        return email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Telefone getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setNumeroDeTelefone(Telefone numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
