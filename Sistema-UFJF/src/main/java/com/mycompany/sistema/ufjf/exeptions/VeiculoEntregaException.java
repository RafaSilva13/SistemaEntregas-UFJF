/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.exeptions;

/**
 *
 * @author sihuanb
 */
public class VeiculoEntregaException extends Exception{

    public VeiculoEntregaException() {
        super("Veículo de entrega fora dos padões de capacidade");
    }

    public VeiculoEntregaException(String message) {
        super(message);
    }
    
}
