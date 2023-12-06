package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class OpcaoMeusDadosCliente implements ActionListener {

    private final JFrame tela;
    private final TelaCliente telaCliente;

    public OpcaoMeusDadosCliente(JFrame tela, TelaCliente telaCliente) {
        this.tela = tela;
        this.telaCliente = telaCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaCliente.exibePainelMeusDados();
    }
}