package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Cliente;
import com.mycompany.sistema.ufjf.view.TelaCliente;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class BotaoLoginCliente implements ActionListener {
    
    private final JFrame telaAtual;
    private final TelaLogin telaLogin;
    private final TelaCliente tela;
    private boolean verificado = false;
    private Cliente clienteLogado;
    
    public BotaoLoginCliente(JFrame telaAtual, TelaCliente tela, TelaLogin telaLogin) {
        this.telaAtual = telaAtual;
        this.tela = tela;
        this.telaLogin = telaLogin;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String usuario = telaLogin.getUsuarioCliente();
        String senha = telaLogin.getSenhaCliente();
        List<Cliente> clientes = telaLogin.listaClientes();
                        
        if (clientes.size() > 0) {
            if (usuario.length() != 0 && senha.length() != 0) {
                for (Cliente cliente : clientes) {
                    if (cliente.fazLogin(usuario, senha)) {
                        this.verificado = true;
                        this.clienteLogado = cliente;
                    }
                } 
                
                if (this.verificado) {
                    telaAtual.dispose();
                    tela.exibirTelaClientes(this.clienteLogado);
                } else {
                    JOptionPane.showMessageDialog(telaAtual, "Senha ou usuário incorreto!");
                }
            }
            else {
                JOptionPane.showMessageDialog(telaAtual, "Preencha todos os campos!");
            }
        }
        else {
            JOptionPane.showMessageDialog(telaAtual, "Nenhum usuário cadastrado!");
        }
        
    }
}