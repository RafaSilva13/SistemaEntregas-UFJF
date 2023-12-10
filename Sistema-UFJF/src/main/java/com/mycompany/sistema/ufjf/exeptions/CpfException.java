/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.exeptions;

/**
 *
 * @author sihuanb
 */
public class CpfException extends Exception {

    public CpfException() {
        super("CPF não válido!");
    }

    public CpfException(String message) {
        super(message);
    }
    
}
