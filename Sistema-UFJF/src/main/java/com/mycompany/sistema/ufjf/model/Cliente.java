package com.mycompany.sistema.ufjf.model;

import java.util.Random;

public class Cliente extends Usuario {
    
    private int identificadorCliente;
    private String nome;
    private Cpf cpf;
    private int quantidadeDePedidos;
    private Telefone numeroDeTelefone;
    private Email email;

    public void Cliente() {
    }
    
    public Cliente(String nome, Cpf cpf, Telefone numeroDeTelefone, Email email, String usuario, String senha){
        super(usuario, senha);
        this.identificadorCliente = 1;
        this.nome = nome;
        this.quantidadeDePedidos = 0;
        this.cpf = cpf;
        this.numeroDeTelefone = numeroDeTelefone;
        this.email = email;
        
    }

    //Acredito que verifica se os dados esão no json e se sim, faz login, se não, não faz
    @Override
    public boolean fazLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }
    
    public int retornaCodigoIdentificador(){
        return this.identificadorCliente;
    }
   
    public void verPedidos(){
        System.out.println("Número de pedidos do cliente " + this.nome + " é : " + this.quantidadeDePedidos);
    }

    //GETTERS
    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public Cpf getCpf() {
        return cpf;
    }

    public int getQuantidadeDePedidos() {
        return quantidadeDePedidos;
    }

    public Telefone getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public Email getEmail() {
        return email;
    }

    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setIdentificadorCliente(int identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public void setQuantidadeDePedidos(int quantidadeDePedidos) {
        this.quantidadeDePedidos = quantidadeDePedidos;
    }

    public void setNumeroDeTelefone(Telefone numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf.toString() + ", numeroDeTelefone=" + numeroDeTelefone.toString() + ", email=" + email + ", usuario=" + usuario + '}';
    }
}
