package com.mycompany.sistema.ufjf;

import com.mycompany.sistema.ufjf.exeptions.*;
import com.mycompany.sistema.ufjf.view.TelaLogin;
public class SistemaUFJF {

    public static void main(String[] args) throws DataException, CpfException, EmailException, TelefoneException {       
        TelaLogin tela = new TelaLogin();
        tela.exibirTelaLogin();
    }
}
