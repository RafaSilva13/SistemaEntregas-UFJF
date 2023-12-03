/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.exeptions;

/**
 *
 * @author sihuanb
 */
public class CpfExeption extends Exception {

    public CpfExeption() {
        super("CPF não válido!");
    }

    public CpfExeption(String message) {
        super(message);
    }
    
}
