package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Administrador;
import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BotaoLoginAdministrador implements ActionListener {
    
    private final JFrame telaAtual;
    private final TelaAdministrador tela;
    private final TelaLogin telaLogin;
    
    public BotaoLoginAdministrador(JFrame telaAtual, TelaAdministrador tela, TelaLogin telaLogin) {
        this.telaAtual = telaAtual;
        this.tela = tela;
        this.telaLogin = telaLogin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usuario = telaLogin.getUsuarioAdministrador();
        String senha = telaLogin.getSenhaAdministrador();
        
        Administrador administrador = new Administrador("admin","123");
        
        if (usuario.length() != 0 && senha.length() != 0) {
            if (administrador.fazLogin(usuario, senha)) {
                telaAtual.dispose();
                tela.exibirTelaAdministrador(telaLogin.getJListClientes(), telaLogin.getJListEntregadores());
            } else {
                JOptionPane.showMessageDialog(telaAtual, "Senha ou usuário incorreto!");
            }
        } else {
            JOptionPane.showMessageDialog(telaAtual, "Preencha todos os campos!");
        }
    }
}