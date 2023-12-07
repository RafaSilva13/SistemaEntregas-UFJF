package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.AdicionarCliente;
import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import com.mycompany.sistema.ufjf.eventos.OpcaoMeusDadosCliente;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCliente {
    
    private JFrame tela;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private JTextField tfNomeCliente;
    private JTextField tfEmailCliente;
    private JTextField tfTelefoneCliente;
    private JTextField tfUsuarioCliente;
    private JTextField tfSenhaCliente;
    private JLabel tfCpfCliente;

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
        
        principal.revalidate();
        principal.repaint();
    }
    
    private JMenuBar criaBarraDeOpcoes() {
        
        // Cria barra de menu de opções 
        JMenuBar menuBar = new JMenuBar();

        // Cria um novo menu
        JMenu menu = new JMenu("Opções");

        JMenuItem item1 = new JMenuItem("Meus dados");
        item1.addActionListener(new OpcaoMeusDadosCliente(this));

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
    
    public void exibePainelMeusDados() {
        
        // Remoção o painel atual
        principal.removeAll();

        // Cria painel de dados pessoais
        JPanel areaDadosPessoais = new JPanel();
        areaDadosPessoais.setLayout(new BorderLayout());
        
// -----------------------------------------------------------------------------               

        // Cria a area de texto 
        JPanel areaTextoMeusDados = new JPanel();
        JLabel textoMeusDados = new JLabel("Meus dados");
        
        // Define a fonte do texto com um tamanho específico
        Font fonte = new Font("Arial", Font.PLAIN, 18);
        textoMeusDados.setFont(fonte);
        
        // Define borda superior e inferior do texto
        textoMeusDados.setBorder(new EmptyBorder(10, 0, 10, 0));
        textoMeusDados.setHorizontalTextPosition(JLabel.CENTER);
        
        // Adiciona texto a areaDeTexto
        areaTextoMeusDados.add(textoMeusDados);
        
// -----------------------------------------------------------------------------
        
        // Cria um painel para conter as áreas de nome e cpf
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new BoxLayout(panelEsquerdo, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de nome
        JPanel areaNomeCliente = new JPanel();
        areaNomeCliente.setBorder(BorderFactory.createTitledBorder("Nome"));
        tfNomeCliente = new JTextField(12);
        areaNomeCliente.add(tfNomeCliente);
        
        // Cria um painel para conter a área de cpf
        JPanel areaCpfCliente = new JPanel();
        areaCpfCliente.setBorder(BorderFactory.createTitledBorder("CPF"));
        tfCpfCliente = new JLabel();
        areaCpfCliente.add(tfCpfCliente);
        
        // Adicina nome e cpf ao painel
        panelEsquerdo.add(areaNomeCliente);
        panelEsquerdo.add(areaCpfCliente);
        
// -----------------------------------------------------------------------------              

        // Cria um painel para conter as áreas de usuario e telefone
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de usuario
        JPanel areaUsuarioCliente = new JPanel();
        areaUsuarioCliente.setBorder(BorderFactory.createTitledBorder("Usuario"));
        tfUsuarioCliente = new JTextField(12);
        areaUsuarioCliente.add(tfUsuarioCliente);
        
        // Cria um painel para conter a área de telefone
        JPanel areaTelefoneCliente = new JPanel();
        areaTelefoneCliente.setBorder(BorderFactory.createTitledBorder("Telefone"));
        tfTelefoneCliente = new JTextField(12);
        areaTelefoneCliente.add(tfTelefoneCliente);
       
        // Adicina usuario e telefone ao painel
        panelCentral.add(areaUsuarioCliente);
        panelCentral.add(areaTelefoneCliente);

// -----------------------------------------------------------------------------               

        // Cria um painel para conter as áreas de senha e email
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BoxLayout(panelDireito, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de senha
        JPanel areaSenhaCliente = new JPanel();
        areaSenhaCliente.setBorder(BorderFactory.createTitledBorder("Senha"));
        tfSenhaCliente = new JTextField(12);
        areaSenhaCliente.add(tfSenhaCliente);

        // Cria um painel para conter a área de email
        JPanel areaEmailCliente = new JPanel();
        areaEmailCliente.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailCliente = new JTextField(12);
        areaEmailCliente.add(tfEmailCliente);

        // Adicina senha e email ao painel
        panelDireito.add(areaEmailCliente);
        panelDireito.add(areaSenhaCliente);
        
// -----------------------------------------------------------------------------               

        // Cria botão de salvar alteracoes e adiciona em um painel
        JPanel painelBotaoMeusDados = new JPanel();
        painelBotaoMeusDados.setBorder(new EmptyBorder(12, 0, 0, 0));
        
        JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");

        // Chama a função de editar
//        botaoSalvarAlteracoes.addActionListener(new salvarAlteracoesCliente(this));

        
        painelBotaoMeusDados.add(botaoSalvarAlteracoes);

// -----------------------------------------------------------------------------               

        // Adiciona paineis de componentes ao painel de dados pessoais
        areaDadosPessoais.add(areaTextoMeusDados, BorderLayout.NORTH);
        areaDadosPessoais.add(panelEsquerdo, BorderLayout.WEST);
        areaDadosPessoais.add(panelCentral, BorderLayout.CENTER);
        areaDadosPessoais.add(panelDireito, BorderLayout.EAST);
        areaDadosPessoais.add(painelBotaoMeusDados, BorderLayout.SOUTH);
        
        JPanel areaPainelMeusDados = new JPanel();
        
        areaPainelMeusDados.add(areaDadosPessoais);
        areaPainelMeusDados.setSize(550, HEIGHT);
        areaPainelMeusDados.setBorder(BorderFactory.createRaisedBevelBorder());
        
        // Adiciona o painelMeusDados ao painel principal
        principal.add(areaPainelMeusDados);

        // Atualiza a exibição
        principal.revalidate();
        principal.repaint();
    }
        
    private void salvarAlteracoes() {
        // Lógica para salvar as alterações aqui
        // Você pode acessar os valores dos campos usando, por exemplo, tfNomeCliente.getText()
    }
}
