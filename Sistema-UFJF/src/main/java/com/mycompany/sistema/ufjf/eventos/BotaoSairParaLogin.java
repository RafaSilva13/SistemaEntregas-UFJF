package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BotaoSairParaLogin implements ActionListener {
    
    private final JFrame telaAtual;
    private final TelaLogin tela;
    
    public BotaoSairParaLogin(JFrame telaAtual, TelaLogin tela) {
        this.telaAtual = telaAtual;
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaAtual.dispose();
        tela.exibirTelaLogin();
    }
}
