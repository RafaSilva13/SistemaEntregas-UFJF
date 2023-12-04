package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarEntregador implements ActionListener {
      
    private final TelaLogin tela;

    public AdicionarEntregador(TelaLogin tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        tela.addEntregador();
    }
}
