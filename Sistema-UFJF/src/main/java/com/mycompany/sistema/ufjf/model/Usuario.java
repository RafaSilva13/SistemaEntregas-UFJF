package com.mycompany.sistema.ufjf.model;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

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
