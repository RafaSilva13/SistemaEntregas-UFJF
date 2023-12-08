package com.mycompany.sistema.ufjf;

import com.mycompany.sistema.ufjf.exeptions.*;
import com.mycompany.sistema.ufjf.model.*;
import com.mycompany.sistema.ufjf.view.TelaLogin;

public class SistemaUFJF {

    public static void main(String[] args) throws DataExeption, CpfException, EmailException, TelefoneException {
        System.out.println("Hello World!");
       
        
//        Data data = Data.parser("21/01/1111");
//        System.out.println(data.toString());
//        
//        Cpf cpf = Cpf.parser("112.333112-11");
//        System.out.println(cpf.toString());
        
//        Telefone telefone = Telefone.parser("(32 2222-2222");
//        System.out.println(telefone.toString());
        
//        Email email = new Email("caiogmail.com");
//        System.out.println(email.toString());

//        
        //System.out.println(carro.exibirInfos());
        
        TelaLogin tela = new TelaLogin();
        tela.exibirTelaLogin();
    }
}
