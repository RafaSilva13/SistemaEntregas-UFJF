package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class BotaoLoginCliente implements ActionListener {
    
    private final JFrame telaLogin;
    private final TelaCliente tela;
    
    public BotaoLoginCliente(JFrame telaLogin, TelaCliente tela) {
        this.telaLogin = telaLogin;
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        telaLogin.dispose();
        tela.exibirTelaClientes();
    }
}