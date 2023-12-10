package com.mycompany.sistema.ufjf.exeptions;

public class DataException extends Exception{

    public DataException() {
        super("Data fora do padrão dd/mm/aaaa ou superior a data atual!");
    }

    public DataException(String message) {
        super(message);
    }
    
}
