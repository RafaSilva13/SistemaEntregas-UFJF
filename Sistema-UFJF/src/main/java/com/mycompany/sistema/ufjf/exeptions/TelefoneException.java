/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.exeptions;

/**
 *
 * @author sihuanb
 */
public class TelefoneException extends Exception {
    public TelefoneException() {
        super("Formato de telefone incorreto.");
    }

    public TelefoneException(String message) {
        super(message);
    }
}
