package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcaoDadosGeraisAdministrador implements ActionListener {

    private final TelaAdministrador telaAdministrador;

    public OpcaoDadosGeraisAdministrador(TelaAdministrador telaAdministrador) {
        this.telaAdministrador = telaAdministrador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaAdministrador.exibirDadosGerais();
    }
}