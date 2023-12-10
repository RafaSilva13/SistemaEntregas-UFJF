package com.mycompany.sistema.ufjf.exeptions;

public class VeiculoEntregaException extends Exception {

    public VeiculoEntregaException() {
        super("Veículo de entrega com capacidade inferior a 10Kg!");
    }

    public VeiculoEntregaException(String message) {
        super(message);
    }
    
}