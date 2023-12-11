package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class SelecionarContatoEntregador implements ListSelectionListener {

    private final TelaAdministrador tela;

    public SelecionarContatoEntregador(TelaAdministrador tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarFormularioEntregador();
    }
}
