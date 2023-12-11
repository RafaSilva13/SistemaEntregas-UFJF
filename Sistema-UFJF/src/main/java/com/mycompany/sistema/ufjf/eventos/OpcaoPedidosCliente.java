package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class OpcaoPedidosCliente implements ActionListener {

    private final TelaCliente telaCliente;

    public OpcaoPedidosCliente(TelaCliente telaCliente) {
        this.telaCliente = telaCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaCliente.exibirPedidosCliente();
    }
}