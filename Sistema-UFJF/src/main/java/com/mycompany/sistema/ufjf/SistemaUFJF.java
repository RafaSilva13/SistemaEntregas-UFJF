package com.mycompany.sistema.ufjf;

/**
 *
 * @author rafael.pereira
 */
import com.mycompany.sistema.ufjf.exeptions.DataExeption;
import com.mycompany.sistema.ufjf.model.Data;

public class SistemaUFJF {

    public static void main(String[] args) throws DataExeption {
        System.out.println("Hello World!");
        Data data = Data.parser("21/01/1111");
        System.out.println(data.toString());
    }
}
