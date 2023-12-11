package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class OpcaoPedidosAdministrador implements ActionListener {

    private final TelaAdministrador telaAdministrador;

    public OpcaoPedidosAdministrador(TelaAdministrador telaAdministrador) {
        this.telaAdministrador = telaAdministrador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaAdministrador.exibirPedidosAdministrador();
    }
}