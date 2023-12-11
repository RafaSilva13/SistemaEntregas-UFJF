package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class AdicionarPacotesPequenos implements ActionListener {
      
    private final TelaCliente tela;

    public AdicionarPacotesPequenos(TelaCliente tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.addPacotePequeno();
    }
}
