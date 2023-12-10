package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarPacotesGrandes implements ActionListener {
      
    private final TelaCliente tela;

    public AdicionarPacotesGrandes(TelaCliente tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.addPacoteGrande();
    }
}
