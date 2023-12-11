package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Administrador;
import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class BotaoLoginAdministrador implements ActionListener {
    
    private final JFrame telaAtual;
    private final TelaAdministrador tela;
    private final TelaLogin telaLogin;
    private final String USUARIO_PADRAO = "admin";
    private final String SENHA_PADRAO = "123";
    
    public BotaoLoginAdministrador(JFrame telaAtual, TelaAdministrador tela, TelaLogin telaLogin) {
        this.telaAtual = telaAtual;
        this.tela = tela;
        this.telaLogin = telaLogin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usuario = telaLogin.getUsuarioAdministrador();
        String senha = telaLogin.getSenhaAdministrador();
        
        Administrador administrador = new Administrador(USUARIO_PADRAO,SENHA_PADRAO);
        
        if (usuario.length() != 0 && senha.length() != 0) {
            if (administrador.fazLogin(usuario, senha)) {
                telaAtual.dispose();
                tela.exibirTelaAdministrador();
            } else {
                JOptionPane.showMessageDialog(telaAtual, "Senha ou usuário incorreto!");
            }
        } else {
            JOptionPane.showMessageDialog(telaAtual, "Preencha todos os campos!");
        }
    }
}