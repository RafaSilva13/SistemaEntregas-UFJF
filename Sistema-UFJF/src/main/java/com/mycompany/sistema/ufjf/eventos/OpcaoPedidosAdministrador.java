package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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