package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarContatoCliente implements ListSelectionListener {

    private final TelaAdministrador tela;

    public SelecionarContatoCliente(TelaAdministrador tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarFormularioCliente();
    }
}
