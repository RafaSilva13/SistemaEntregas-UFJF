package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class RemoverUsuario implements ActionListener {

    private final TelaAdministrador tela;
    private String tipoUsuario;

    public RemoverUsuario(TelaAdministrador tela, String tipoUsuario) {
        this.tela = tela;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.removerUsuario(tipoUsuario);
    }
}

