/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.exeptions;

/**
 *
 * @author sihuanb
 */
public class DataExeption extends Exception{

    public DataExeption() {
        super("Data fora do padrão");
    }

    public DataExeption(String message) {
        super(message);
    }
    
}
