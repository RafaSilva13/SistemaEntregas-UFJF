package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaEntregador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarEntregadorNoPacote implements ActionListener {
      
    private final TelaEntregador tela;

    public AdicionarEntregadorNoPacote(TelaEntregador tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.addEntregadorAPacote();
    }
}
