package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaAdministrador {

    private JFrame tela;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;

    public void exibirTelaAdministrador() {

        // Cria uma nova janela
        tela = new JFrame("Area Administrador");

        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adiciona o menu de Opções
        tela.setJMenuBar(criaBarraDeOpcoes());

        principal = new JPanel();
        principal.setLayout(new BorderLayout());

        // Adiciona o painel geral a janela
        tela.add(principal);

        // Define o tamanho do painel geral e sua posição como central
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        
        // Bloqueia o redimensionamento da janela
        tela.setResizable(false);
        
        // Deixa o painel visível
        tela.setVisible(true);
    }
    
    private JMenuBar criaBarraDeOpcoes() {
        
        // Cria barra de menu de opções 
        JMenuBar menuBar = new JMenuBar();
        
        // Cria um novo menu
        JMenu menu = new JMenu("Opções");
        
        JMenuItem item1 = new JMenuItem("Dados Gerais");
        JMenuItem item2 = new JMenuItem("Pedidos");
        JMenuItem item3 = new JMenuItem("Sair");
        item3.addActionListener(new BotaoSairParaLogin(tela, new TelaLogin()));

        // Adicione opções no menu
        menu.add(item1);
        menu.add(item2);
        menu.addSeparator();
        menu.add(item3);

        // Adiciona menu na barra de menus
        menuBar.add(menu);
        
        return menuBar;
    }
}

