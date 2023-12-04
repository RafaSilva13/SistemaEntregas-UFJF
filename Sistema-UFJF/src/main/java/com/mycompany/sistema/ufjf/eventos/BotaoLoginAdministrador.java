package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BotaoLoginAdministrador implements ActionListener {
    
    private final JFrame telaLogin;
    private final TelaAdministrador tela;
    
    public BotaoLoginAdministrador(JFrame telaLogin, TelaAdministrador tela) {
        this.telaLogin = telaLogin;
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaLogin.dispose();
        tela.exibirTelaAdministrador();
    }
}