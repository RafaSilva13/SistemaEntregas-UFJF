package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaEntregador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class OpcaoMeusDadosEntregador implements ActionListener {

    private final JFrame tela;
    private final TelaEntregador telaEntregador;

    public OpcaoMeusDadosEntregador(JFrame tela, TelaEntregador telaEntregador) {
        this.tela = tela;
        this.telaEntregador = telaEntregador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        telaEntregador.exibePainelMeusDados();
    }
}