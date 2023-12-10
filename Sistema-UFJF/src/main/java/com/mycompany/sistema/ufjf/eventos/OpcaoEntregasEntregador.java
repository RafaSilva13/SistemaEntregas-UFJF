package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaEntregador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcaoEntregasEntregador implements ActionListener {

    private final TelaEntregador telaEntregador;

    public OpcaoEntregasEntregador(TelaEntregador telaEntregador) {
        this.telaEntregador = telaEntregador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaEntregador.exibirPedidosEntregador();
    }
}