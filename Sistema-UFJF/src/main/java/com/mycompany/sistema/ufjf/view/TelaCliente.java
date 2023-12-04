package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaCliente {
    
    private JFrame tela;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;

    public void exibirTelaClientes() {
        
        // Cria uma nova janela
        tela = new JFrame("Area Cliente");
        
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

        JMenuItem item1 = new JMenuItem("Meus dados");
//        item1.addActionListener(e -> exibePainelMeusDados());

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
    
    private void exibePainelMeusDados() {
        // Remova o painel atual
        principal.removeAll();
            
        // Cria um painel de Entregador
        JPanel painelMeusDados = new JPanel();
        
        // Adiciona os componentes no painel do Entregador
        painelMeusDados.add(new JLabel("Meus Dados"));
        painelMeusDados.setBorder(BorderFactory.createRaisedBevelBorder());

        principal.add(painelMeusDados, BorderLayout.CENTER);
        
        // Atualiza a exibição
        principal.revalidate();
        principal.repaint();
    }
}
