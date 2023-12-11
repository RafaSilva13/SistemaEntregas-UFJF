package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.view.TelaEntregador;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class BotaoLoginEntregador implements ActionListener {
    
    private final JFrame telaAtual;
    private final TelaLogin telaLogin;
    private final TelaEntregador tela;
    private boolean verificado = false;
    private Entregador entregadorLogado;
    
    public BotaoLoginEntregador(JFrame telaAtual, TelaEntregador tela, TelaLogin telaLogin) {
        this.tela = tela;
        this.telaAtual = telaAtual;
        this.telaLogin = telaLogin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usuario = telaLogin.getUsuarioEntregador();
        String senha = telaLogin.getSenhaEntregador();
        List<Entregador> entregadores = telaLogin.listaEntregadores();

        if (entregadores.size() > 0) {
            if (usuario.length() != 0 && senha.length() != 0) {
                for (Entregador entregador : entregadores) {
                    if (entregador.fazLogin(usuario, senha)) {
                        this.verificado = true;
                        this.entregadorLogado = entregador;
                    }
                }
                
                if (this.verificado) {
                    telaAtual.dispose();
                    tela.exibirTelaEntregador(this.entregadorLogado);
                } else {
                    JOptionPane.showMessageDialog(telaAtual, "Senha ou usuário incorreto!");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(telaAtual, "Preencha todos os campos!");
            }
        }
        else {
            JOptionPane.showMessageDialog(telaAtual, "Nenhum usuário cadastrado!");
        }
    }
}