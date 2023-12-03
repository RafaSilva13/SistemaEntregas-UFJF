package com.mycompany.sistema.ufjf;

/**
 *
 * @author rafael.pereira
 */
import com.mycompany.sistema.ufjf.exeptions.*;
import com.mycompany.sistema.ufjf.model.*;

public class SistemaUFJF {

    public static void main(String[] args) throws DataExeption, CpfExeption, EmailException {
        System.out.println("Hello World!");
        Data data = Data.parser("21/01/1111");
        System.out.println(data.toString());
        
        Cpf cpf = Cpf.parser("112.333112-11");
        System.out.println(cpf.toString());
        
        Email email = new Email("caiogmail.com");
        System.out.println(email.toString());
        
    }
}
