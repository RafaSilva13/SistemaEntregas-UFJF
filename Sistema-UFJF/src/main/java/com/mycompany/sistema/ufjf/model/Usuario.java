/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

/**
 *
 * @author sihuanb
 */
abstract class Usuario {
    protected String usuario;
    protected String senha;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }
    
    public abstract boolean fazLogin(String usuario, String senha);
}
