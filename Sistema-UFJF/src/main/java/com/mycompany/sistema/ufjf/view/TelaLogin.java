package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.AdicionarCliente;
import com.mycompany.sistema.ufjf.eventos.AdicionarEntregador;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginAdministrador;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginCliente;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginEntregador;
//import com.mycompany.sistema.model.Cliente;
import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.model.Email;
import com.mycompany.sistema.ufjf.model.Telefone;
import com.mycompany.sistema.ufjf.model.Cpf;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin {
    
    private JFrame tela;
    private JTabbedPane barraLogin;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;
    
    // JTextField Login
    private JTextField tfUsuario;
    private JTextField tfSenha;
   
    // JTextField Cadastro
    private JTextField tfUsuarioCadastro;
    private JTextField tfSenhaCadastro;
    
    // JTextField Clientes
    private JTextField tfNomeCliente;
    private JTextField tfEmailCliente;
    private JTextField tfTelefoneCliente;
    private JTextField tfCpfCliente;

    // JTextField Entregadores
    private JTextField tfNomeEntregador;
    private JTextField tfEmailEntregador;
    private JTextField tfTelefoneEntregador;
    private JTextField tfCpfEntregador;

    // JTextField Veiculo Entrega
    private JTextField tfPlaca;
    private JTextField tfModelo;
    private JTextField tfCapacidadeCarga;
    private JTextField tfAnoFabricacao;
    
    // JLists
//    private JList<Cliente> jlClientes;
    private JList<Entregador> jlEntregadores;
    
    public void exibirTelaLogin() {
        
        // Cria uma nova janela
        tela = new JFrame("Sistema de Entregas");
        
        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
        // Inicial o painel geral de login com um BorderLayout
        principal = new JPanel();
        principal.setLayout(new BorderLayout());

        // Inicia a barra superior de seleção de tipo de login com as opções
        barraLogin = new JTabbedPane();
        barraLogin.addTab("Administrador", criarPainelEntradaAdministrador());
        barraLogin.addTab("Cliente", criarPainelEntradaCliente());
        barraLogin.addTab("Entregador", criarPainelEntradaEntregador());
        barraLogin.setBorder(BorderFactory.createRaisedBevelBorder());

        // Adiciona a barra superior ao painel geral
        principal.add(barraLogin);
       
        // Adiciona o painel geral a janela
        tela.add(principal);

        // Define o tamanho do painel geral e sua posição como central
        tela.setSize(WIDTH, 300);
        tela.setLocationRelativeTo(null);
        
        // Bloqueia o redimensionamento da janela
        tela.setResizable(false);
        
        // Deixa o painel visível
        tela.setVisible(true);
        
        tela.pack();
    }
 
    private JPanel criarPainelEntradaAdministrador() {
        
        // Cria um painel de Adiministrador
        JPanel painelAdministrador = new JPanel();
        painelAdministrador.setSize(350, 300);

        JPanel painelLogin = criaPainelComumLogin();
        painelLogin.setLayout(new BoxLayout(painelLogin, BoxLayout.Y_AXIS));
        painelLogin.setBorder(BorderFactory.createRaisedBevelBorder());
        
        // Cria painel para botao login
        JPanel painelBotaoLogin = new JPanel();
        painelBotaoLogin.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Cria botao de Login
        JButton botaoLogin = new JButton("Entrar");
        
        // Abre tela administrador
        botaoLogin.addActionListener(new BotaoLoginAdministrador(tela, new TelaAdministrador()));
        
        // Adiciona botao ao painel do botao
        painelBotaoLogin.add(botaoLogin);
        
        // Adiciona botao ao painel do login
        painelLogin.add(painelBotaoLogin);
        
// -----------------------------------------------------------------------------

        // Adiciona paineis ao painel atual
        painelAdministrador.add(painelLogin);
        
        return painelAdministrador;
    }

    
    private JPanel criarPainelEntradaCliente() {
        
        // Cria um painel de Cliente
        JPanel painelCliente = new JPanel();
        
        JPanel painelComumLogin = criaPainelComumLogin();
        painelComumLogin.setSize(250, HEIGHT);
        painelComumLogin.setLayout(new BoxLayout(painelComumLogin, BoxLayout.Y_AXIS));
        painelComumLogin.setBorder(BorderFactory.createRaisedBevelBorder());

        // Cria painel para botao login
        JPanel painelBotaoLogin = new JPanel();
        painelBotaoLogin.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Cria botao de Login
        JButton botaoLogin = new JButton("Entrar");
        
        // Abre tela cliente
        botaoLogin.addActionListener(new BotaoLoginCliente(tela, new TelaCliente()));

        // Adiciona botao ao painel do botao
        painelBotaoLogin.add(botaoLogin);
        
        // Adiciona botao ao painel do login
        painelComumLogin.add(painelBotaoLogin);
        
// -----------------------------------------------------------------------------

        // Adiciona painel de cadastro no painel do entregador
        JPanel painelComumCadastro = criaPainelComumCadastroCliente();
        painelComumCadastro.setSize(550, HEIGHT);
        painelComumCadastro.setBorder(BorderFactory.createRaisedBevelBorder());

        // Adiciona paineis ao painel atual    
        painelCliente.add(painelComumLogin, BorderLayout.WEST);
        painelCliente.add(painelComumCadastro,BorderLayout.EAST);
        
        return painelCliente;
    }

    private JPanel criarPainelEntradaEntregador() {
        
        // Cria um painel de Entregador
        JPanel painelEntregador = new JPanel();
        
        // Adiciona painel de login no painel do entragador
        JPanel painelComumLogin = criaPainelComumLogin();
        painelComumLogin.setSize(250, HEIGHT);
        painelComumLogin.setLayout(new BoxLayout(painelComumLogin, BoxLayout.Y_AXIS));
        painelComumLogin.setBorder(BorderFactory.createRaisedBevelBorder());
        
        // Cria painel para botao login
        JPanel painelBotaoLogin = new JPanel();
        painelBotaoLogin.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Cria botao de Login
        JButton botaoLogin = new JButton("Entrar");
        
        // Abre tela entregador
        botaoLogin.addActionListener(new BotaoLoginEntregador(tela, new TelaEntregador()));
        
        // Adiciona botao ao painel do botao
        painelBotaoLogin.add(botaoLogin);
        
        // Adiciona botao ao painel do login
        painelComumLogin.add(painelBotaoLogin);
        
// -----------------------------------------------------------------------------

        // Adiciona painel de cadastro no painel do entregador
        JPanel painelComumCadastro = criaPainelComumCadastroEntregador();
        painelComumCadastro.setSize(550, HEIGHT);
        painelComumCadastro.setBorder(BorderFactory.createRaisedBevelBorder());
        
        // Adiciona paineis ao painel atual    
        painelEntregador.add(painelComumLogin, BorderLayout.WEST);
        painelEntregador.add(painelComumCadastro,BorderLayout.EAST);
        
        return painelEntregador;
    }
    
    private JPanel criaPainelComumCadastroCliente() {
        
        // Cria painel de cadastro
        JPanel areaCadastro = new JPanel();
        areaCadastro.setLayout(new BorderLayout());
        
// -----------------------------------------------------------------------------               

        // Cria a area de texto 
        JPanel areaTextoCadastro = new JPanel();
        JLabel textoCadastro = new JLabel("Cadastro");
        
        // Define a fonte do texto com um tamanho específico
        Font fonte = new Font("Arial", Font.PLAIN, 18);
        textoCadastro.setFont(fonte);
        
        // Define borda superior e inferior do texto
        textoCadastro.setBorder(new EmptyBorder(10, 0, 8, 0));
        textoCadastro.setHorizontalTextPosition(JLabel.CENTER);
        
        // Adiciona texto a areaDeTexto
        areaTextoCadastro.add(textoCadastro);
        
// -----------------------------------------------------------------------------
        
        // Cria um painel para conter as áreas de nome
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new BoxLayout(panelEsquerdo, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de nome
        JPanel areaNomeCliente = new JPanel();
        areaNomeCliente.setBorder(BorderFactory.createTitledBorder("Nome"));
        tfNomeCliente = new JTextField(12);
        areaNomeCliente.add(tfNomeCliente);
        
        // Cria um painel para conter a área de email
        JPanel areaEmailCliente = new JPanel();
        areaEmailCliente.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailCliente = new JTextField(12);
        areaEmailCliente.add(tfEmailCliente);
        
        // Adicina nome e email ao painel
        panelEsquerdo.add(areaNomeCliente);
        panelEsquerdo.add(areaEmailCliente);
        
// -----------------------------------------------------------------------------              

        // Cria um painel para conter as áreas de nome
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de usuario
        JPanel areaUsuarioCliente = new JPanel();
        areaUsuarioCliente.setBorder(BorderFactory.createTitledBorder("Usuario"));
        tfUsuarioCadastro = new JTextField(12);
        areaUsuarioCliente.add(tfUsuarioCadastro);
        
        // Cria um painel para conter a área de senha
        JPanel areaSenhaCliente = new JPanel();
        areaSenhaCliente.setBorder(BorderFactory.createTitledBorder("Senha"));
        tfSenhaCadastro = new JTextField(12);
        areaSenhaCliente.add(tfSenhaCadastro);
        
        // Adicina usuario e senha ao painel
        panelCentral.add(areaUsuarioCliente);
        panelCentral.add(areaSenhaCliente);

// -----------------------------------------------------------------------------                           

        // Cria um painel para conter as áreas de telefone e cpf
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BoxLayout(panelDireito, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de telefone
        JPanel areaTelefoneCliente = new JPanel();
        areaTelefoneCliente.setBorder(BorderFactory.createTitledBorder("Telefone"));
        tfTelefoneCliente = new JTextField(12);
        areaTelefoneCliente.add(tfTelefoneCliente);

        // Cria um painel para conter a área de cpf
        JPanel areaCpfCliente = new JPanel();
        areaCpfCliente.setBorder(BorderFactory.createTitledBorder("Cpf"));
        tfCpfCliente = new JTextField(12);
        areaCpfCliente.add(tfCpfCliente);

        // Adicina telefone e cpf ao painel
        panelDireito.add(areaCpfCliente);
        panelDireito.add(areaTelefoneCliente);
        
// -----------------------------------------------------------------------------               

        // Cria botão de cadastro e adiciona em uma painel
        JPanel painelBotaoCadastro = new JPanel();
        painelBotaoCadastro.setBorder(new EmptyBorder(10, 0, 0, 0));
        JButton botaoCadastro = new JButton("Cadastrar");
        
        // Chama a função de cadastrar
        botaoCadastro.addActionListener(new AdicionarCliente(this));
        
        painelBotaoCadastro.add(botaoCadastro);

// -----------------------------------------------------------------------------               

        // Adiciona paineis de componentes ao painel da area de cadastro
        areaCadastro.add(areaTextoCadastro, BorderLayout.NORTH);
        areaCadastro.add(panelEsquerdo, BorderLayout.WEST);
        areaCadastro.add(panelCentral, BorderLayout.CENTER);
        areaCadastro.add(panelDireito, BorderLayout.EAST);
        areaCadastro.add(painelBotaoCadastro, BorderLayout.SOUTH);
        
        return areaCadastro;
    }
    
    private JPanel criaPainelComumCadastroEntregador() {
        
        // Cria painel de cadastro
        JPanel areaCadastro = new JPanel();
        areaCadastro.setLayout(new BorderLayout());
        
// -----------------------------------------------------------------------------               

        // Cria a area de texto 
        JPanel areaTextoCadastro = new JPanel();
        JLabel textoCadastro = new JLabel("Cadastro");
        
        // Define a fonte do texto com um tamanho específico
        Font fonte = new Font("Arial", Font.PLAIN, 18);
        textoCadastro.setFont(fonte);
        
        // Define borda superior e inferior do texto
        textoCadastro.setBorder(new EmptyBorder(10, 0, 8, 0));
        textoCadastro.setHorizontalTextPosition(JLabel.CENTER);
        
        // Adiciona texto a areaDeTexto
        areaTextoCadastro.add(textoCadastro);
        
// -----------------------------------------------------------------------------
        
        // Cria um painel para conter as áreas de nome
        JPanel panelEsquerdo = new JPanel();
        panelEsquerdo.setLayout(new BoxLayout(panelEsquerdo, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de nome
        JPanel areaNomeEntregador = new JPanel();
        areaNomeEntregador.setBorder(BorderFactory.createTitledBorder("Nome"));
        tfNomeEntregador = new JTextField(12);
        areaNomeEntregador.add(tfNomeEntregador);
        
        // Cria um painel para conter a área de email
        JPanel areaEmailEntregador = new JPanel();
        areaEmailEntregador.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailEntregador = new JTextField(12);
        areaEmailEntregador.add(tfEmailEntregador);
        
        // Adicina nome e email ao painel
        panelEsquerdo.add(areaNomeEntregador);
        panelEsquerdo.add(areaEmailEntregador);
        
// -----------------------------------------------------------------------------              

        // Cria um painel para conter as áreas de nome
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de usuario
        JPanel areaUsuarioEntregador = new JPanel();
        areaUsuarioEntregador.setBorder(BorderFactory.createTitledBorder("Usuario"));
        tfUsuarioCadastro = new JTextField(12);
        areaUsuarioEntregador.add(tfUsuarioCadastro);
        
        // Cria um painel para conter a área de senha
        JPanel areaSenhaEntregador = new JPanel();
        areaSenhaEntregador.setBorder(BorderFactory.createTitledBorder("Senha"));
        tfSenhaCadastro = new JTextField(12);
        areaSenhaEntregador.add(tfSenhaCadastro);
        
        // Adicina usuario e senha ao painel
        panelCentral.add(areaUsuarioEntregador);
        panelCentral.add(areaSenhaEntregador);

// -----------------------------------------------------------------------------               

        // Cria um painel para conter as áreas de telefone e cpf
        JPanel panelDireito = new JPanel();
        panelDireito.setLayout(new BoxLayout(panelDireito, BoxLayout.Y_AXIS));

        // Cria um painel para conter a área de telefone
        JPanel areaTelefoneEntregador = new JPanel();
        areaTelefoneEntregador.setBorder(BorderFactory.createTitledBorder("Telefone"));
        tfTelefoneEntregador = new JTextField(12);
        areaTelefoneEntregador.add(tfTelefoneEntregador);

        // Cria um painel para conter a área de cpf
        JPanel areaCpfEntregador = new JPanel();
        areaCpfEntregador.setBorder(BorderFactory.createTitledBorder("Cpf"));
        tfCpfEntregador = new JTextField(12);
        areaCpfEntregador.add(tfCpfEntregador);

        // Adicina telefone e cpf ao painel
        panelDireito.add(areaCpfEntregador);
        panelDireito.add(areaTelefoneEntregador);
        
// -----------------------------------------------------------------------------               

        // Cria botão de cadastro e adiciona em uma painel
        JPanel painelBotaoCadastro = new JPanel();
        painelBotaoCadastro.setBorder(new EmptyBorder(10, 0, 0, 0));
        JButton botaoCadastro = new JButton("Cadastrar");

        // Chama a função de cadastrar
        botaoCadastro.addActionListener(new AdicionarEntregador(this));

        
        painelBotaoCadastro.add(botaoCadastro);

// -----------------------------------------------------------------------------               

        // Adiciona paineis de componentes ao painel da area de cadastro
        areaCadastro.add(areaTextoCadastro, BorderLayout.NORTH);
        areaCadastro.add(panelEsquerdo, BorderLayout.WEST);
        areaCadastro.add(panelCentral, BorderLayout.CENTER);
        areaCadastro.add(panelDireito, BorderLayout.EAST);
        areaCadastro.add(painelBotaoCadastro, BorderLayout.SOUTH);
        
        return areaCadastro;
    }
    
    private JPanel criaPainelComumLogin() {
        
        // Painel de login
        JPanel areaLogin = new JPanel();
        areaLogin.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        
// -----------------------------------------------------------------------------               

        JPanel areaTextoLogin = new JPanel();
        
        JLabel textoLogin = new JLabel("Login");
        
        // Define a fonte do texto com um tamanho específico
        Font fonte = new Font("Arial", Font.PLAIN, 20);
        textoLogin.setFont(fonte);
        
        // Define borda superior e inferior do texto
        textoLogin.setBorder(new EmptyBorder(8, 0, 8, 0));
        textoLogin.setHorizontalTextPosition (JLabel.CENTER);

        // Adiciona texto a areaDeTexto
        areaTextoLogin.add(textoLogin);
        
        // Adiciona area de texto a area de login
        areaLogin.add(areaTextoLogin);
               
// -----------------------------------------------------------------------------               
        
        // Area de iserção de usuario
        JPanel areaUsuario = new JPanel();
        
        // Titulo da Area
        areaUsuario.setBorder(BorderFactory.createTitledBorder("Usuário"));
        
        // Input de usuario
        tfUsuario = new JTextField(15);

        // Adiciona Input na Area
        areaUsuario.add(tfUsuario);
        
// -----------------------------------------------------------------------------               

        // Area de iserção de usuario
        JPanel areaSenha = new JPanel();
        
        // Titulo da Area
        areaSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
        
        // Input de usuario
        tfSenha = new JTextField(15);

        // Adiciona Input na Area
        areaSenha.add(tfSenha);
        
// -----------------------------------------------------------------------------               

        // Adiciona areas na area de login
        areaLogin.add(areaUsuario);
        areaLogin.add(areaSenha);
        
        return areaLogin;
    }
    
//    public void addCliente(){
//
//        DefaultListModel<Cliente> model = (DefaultListModel<Cliente>).jlClientes.getModel();;
//        
//        try {
//            model.addElement(new Cliente(tfNomeCliente.getText(), new Telefone(tfTelefoneCliente.getText()), new Email(tfEmailCliente.getText()), new Cpf(tfCpfCliente.getText())));
//        } catch (EmailException e) {
//            JOptionPane.showMessageDialog(tela, "O email " + tfEmailCliente.getText() +" é invalido!");
//        } catch (TelefoneException e) {
//            JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneCliente.getText() +" é invalido!");
//        } catch (CpfException e) {
//            JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfCliente.getText() +" é invalido!");
//        }
//    }
//    
//    public void addEntregador(){
//
//        DefaultListModel<Entregador> model = (DefaultListModel<Entregador>).jlEntregadores.getModel();
//        
//        try {
//            model.addElement(new Entregador(tfNomeEntregador.getText(), new Cpf(tfCpfEntregador.getText()), new Email(tfEmailEntregador.getText()),  new Telefone(tfTelefoneEntregador.getText()), 0, ));
//        } catch (EmailException e) {
//            JOptionPane.showMessageDialog(tela, "O email " + tfEmailEntregador.getText() +" é invalido!");
//        } catch (TelefoneException e) {
//            JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneEntregador.getText() +" é invalido!");
//        } catch (CpfException e) {
//            JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfEntregador.getText() +" é invalido!");
//        }
//    }
}
