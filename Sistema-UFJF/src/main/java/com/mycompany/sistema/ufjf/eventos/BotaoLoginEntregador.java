package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaEntregador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BotaoLoginEntregador implements ActionListener {
    
    private final JFrame telaLogin;
    private final TelaEntregador tela;
    
    public BotaoLoginEntregador(JFrame telaLogin, TelaEntregador tela) {
        this.telaLogin = telaLogin;
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaLogin.dispose();
        tela.exibirTelaEntregador();
    }
}