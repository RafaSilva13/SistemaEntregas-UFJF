package com.mycompany.sistema.ufjf.model;

abstract class Usuario {
    protected String usuario;
    protected String senha;

    public Usuario() {
    }
    
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public abstract boolean fazLogin(String usuario, String senha);
}
