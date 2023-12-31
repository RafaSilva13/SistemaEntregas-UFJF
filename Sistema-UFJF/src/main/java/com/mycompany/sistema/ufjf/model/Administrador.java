package com.mycompany.sistema.ufjf.model;

import java.util.Random;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
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
    
    @Override
    public boolean fazLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }
}
