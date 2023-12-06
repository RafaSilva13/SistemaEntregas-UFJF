package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import com.mycompany.sistema.ufjf.eventos.OpcaoMeusDadosEntregador;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class TelaEntregador {

    private JFrame tela;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    private JTextField tfNomeEntregador;
    private JTextField tfEmailEntregador;
    private JTextField tfTelefoneEntregador;
    private JTextField tfUsuarioEntregador;
    private JTextField tfSenhaEntregador;
    private JLabel tfCpfEntregador;
    private JLabel tfPlacaVeiculo;
    private JLabel tfModeloVeiculo;
    private JLabel tfCapacidadeCargaVeiculo;
    private JLabel lblAnoFabricacaoVeiculo;

    public void exibirTelaEntregador() {
        
        // Cria uma nova janela
        tela = new JFrame("Area Entregador");
        
        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adiciona o menu de Opções
        tela.setJMenuBar(criaBarraDeOpcoes());

        // Cria o painel principal
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        
        // Lista teste
        String[] pessoas = { "Eu", "Você", "Ele", "Ela"};

        // Cria um componente de lista
        JList lista = new JList(pessoas);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Cria um painel de rolagem e adiciona ao painel principal
        JScrollPane scroll= new JScrollPane(lista);
        principal.add(scroll);
        
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
        item1.addActionListener(new OpcaoMeusDadosEntregador(tela, this));

        JMenuItem item2 = new JMenuItem("Entregas");

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
        textoMeusDados.setBorder(new EmptyBorder(10, 0, 12, 0));
        textoMeusDados.setHorizontalTextPosition(JLabel.CENTER);
        
        // Adiciona texto a areaDeTexto
        areaTextoMeusDados.add(textoMeusDados);
        
// -----------------------------------------------------------------------------
        
        // Cria um painel para conter as áreas de nome e cpf
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new BoxLayout(panelEsquerdo, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de nome
        JPanel areaNomeEntregador = new JPanel();
        areaNomeEntregador.setBorder(BorderFactory.createTitledBorder("Nome"));
        tfNomeEntregador = new JTextField(12);
        areaNomeEntregador.add(tfNomeEntregador);
        
        // Cria um painel para conter a área de cpf
        JPanel areaCpfEntregador = new JPanel();
        areaCpfEntregador.setBorder(BorderFactory.createTitledBorder("CPF"));
        tfCpfEntregador = new JLabel();
        areaCpfEntregador.add(tfCpfEntregador);
        
        // Adicina nome e cpf ao painel
        panelEsquerdo.add(areaNomeEntregador);
        panelEsquerdo.add(areaCpfEntregador);
        
// -----------------------------------------------------------------------------              

        // Cria um painel para conter as áreas de usuario e telefone
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de usuario
        JPanel areaUsuarioEntregador = new JPanel();
        areaUsuarioEntregador.setBorder(BorderFactory.createTitledBorder("Usuario"));
        tfUsuarioEntregador = new JTextField(12);
        areaUsuarioEntregador.add(tfUsuarioEntregador);
        
        // Cria um painel para conter a área de telefone
        JPanel areaTelefoneEntregador = new JPanel();
        areaTelefoneEntregador.setBorder(BorderFactory.createTitledBorder("Telefone"));
        tfTelefoneEntregador = new JTextField(12);
        areaTelefoneEntregador.add(tfTelefoneEntregador);
       
        // Adicina usuario e telefone ao painel
        panelCentral.add(areaUsuarioEntregador);
        panelCentral.add(areaTelefoneEntregador);

// -----------------------------------------------------------------------------               

        // Cria um painel para conter as áreas de senha e email
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BoxLayout(panelDireito, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de senha
        JPanel areaSenhaEntregador = new JPanel();
        areaSenhaEntregador.setBorder(BorderFactory.createTitledBorder("Senha"));
        tfSenhaEntregador = new JTextField(12);
        areaSenhaEntregador.add(tfSenhaEntregador);

        // Cria um painel para conter a área de email
        JPanel areaEmailEntregador = new JPanel();
        areaEmailEntregador.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailEntregador = new JTextField(12);
        areaEmailEntregador.add(tfEmailEntregador);

        // Adicina email e senha ao painel
        panelDireito.add(areaEmailEntregador);
        panelDireito.add(areaSenhaEntregador);
        
// -----------------------------------------------------------------------------               

        // Cria botão de salver alteracoes e adiciona em um painel
        JPanel painelBotaoMeusDados = new JPanel();
        painelBotaoMeusDados.setBorder(new EmptyBorder(15, 0, 10, 0));
        
        JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");

        // Chama a função de editar
//        botaoSalvarAlteracoes.addActionListener(new salvarAlteracoesEntregador(this));

        painelBotaoMeusDados.add(botaoSalvarAlteracoes);

// -----------------------------------------------------------------------------               

        // Adiciona paineis de componentes ao painel de dados pessoais
        areaDadosPessoais.add(areaTextoMeusDados, BorderLayout.NORTH);
        areaDadosPessoais.add(panelEsquerdo, BorderLayout.WEST);
        areaDadosPessoais.add(panelCentral, BorderLayout.CENTER);
        areaDadosPessoais.add(panelDireito, BorderLayout.EAST);
        areaDadosPessoais.add(painelBotaoMeusDados, BorderLayout.SOUTH);
        
// -----------------------------------------------------------------------------          

        // Cria uma subpasta para Dados do Veículo
        JPanel painelDadosVeiculo = new JPanel();
        painelDadosVeiculo.setLayout(new BoxLayout(painelDadosVeiculo, BoxLayout.Y_AXIS));
    
// -----------------------------------------------------------------------------               
        
        // Cria JPanel do texto e o texto
        JPanel areaTextoDadosVeiculo = new JPanel();
        JLabel textoDadosVeiculo = new JLabel("Dados Veículo");
        
        // Define a fonte do texto com um tamanho específico
        textoDadosVeiculo.setFont(fonte);
        
        // Define borda superior e inferior do texto
        textoDadosVeiculo.setBorder(new EmptyBorder(10, 0, 12, 0));
        textoDadosVeiculo.setHorizontalTextPosition (JLabel.CENTER);

        // Adiciona texto a areaDeTexto
        areaTextoDadosVeiculo.add(textoDadosVeiculo);
        
        // Adiciona area de texto a area de login
        painelDadosVeiculo.add(areaTextoDadosVeiculo);

// -----------------------------------------------------------------------------               
            
        // Area de visualização de placa
        JPanel areaPlacaMeusDados = new JPanel();
        
        // Titulo da Area
        areaPlacaMeusDados.setBorder(BorderFactory.createTitledBorder("Placa"));
        
        // Label de placa
        tfPlacaVeiculo = new JLabel();

        // Adiciona Label na Area
        areaPlacaMeusDados.add(tfPlacaVeiculo);

        painelDadosVeiculo.add(areaPlacaMeusDados);

// -----------------------------------------------------------------------------               

        // Area de visualização de modelo
        JPanel areaModeloVeiculoMeusDados = new JPanel();
        
        // Titulo da Area
        areaModeloVeiculoMeusDados.setBorder(BorderFactory.createTitledBorder("Modelo"));
        
        // Label de modelo
        tfModeloVeiculo = new JLabel();

        // Adiciona Label na Area
        areaModeloVeiculoMeusDados.add(tfModeloVeiculo);

        painelDadosVeiculo.add(areaModeloVeiculoMeusDados);

// -----------------------------------------------------------------------------               

        // Area de visualização de capacidade de carga
        JPanel areaCapacidadeCargaMeusDados = new JPanel();
        
        // Titulo da Area
        areaCapacidadeCargaMeusDados.setBorder(BorderFactory.createTitledBorder("Capacidade de Carga"));
        
        // Label de capacidade de carga
        tfCapacidadeCargaVeiculo = new JLabel();

        // Adiciona Label na Area
        areaCapacidadeCargaMeusDados.add(tfCapacidadeCargaVeiculo);

        painelDadosVeiculo.add(areaCapacidadeCargaMeusDados);

// -----------------------------------------------------------------------------               

        // Area de visualização do ano de fabricação
        JPanel arealAnoFabricacaoMeusDados = new JPanel();
        
        // Titulo da Area
        arealAnoFabricacaoMeusDados.setBorder(BorderFactory.createTitledBorder("Ano de Fabricação"));
        
        // Label do ano de fabricação
        lblAnoFabricacaoVeiculo = new JLabel();

        // Adiciona Label na Area
        arealAnoFabricacaoMeusDados.add(lblAnoFabricacaoVeiculo);

        painelDadosVeiculo.add(arealAnoFabricacaoMeusDados);

// -----------------------------------------------------------------------------               

        JPanel areaPainelMeusDados = new JPanel();
        
        areaDadosPessoais.setSize(500, HEIGHT);

        painelDadosVeiculo.setSize(350, HEIGHT);
        
        // Adiciona paineis ao painel atual    
        areaPainelMeusDados.add(areaDadosPessoais, BorderLayout.WEST);
        areaPainelMeusDados.add(painelDadosVeiculo,BorderLayout.EAST);
        
        // Adiciona o painelMeusDados ao painel principal
        principal.add(areaPainelMeusDados);

        // Atualiza a exibição
        principal.revalidate();
        principal.repaint();
    }

    private void salvarAlteracoes() {
        // Lógica para salvar as alterações aqui
        // Você pode acessar os valores dos campos usando, por exemplo, tfNomeEntregador.getText()
    }
}

