package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.AdicionarCliente;
import com.mycompany.sistema.ufjf.eventos.AdicionarEntregador;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginAdministrador;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginCliente;
import com.mycompany.sistema.ufjf.eventos.BotaoLoginEntregador;
import com.mycompany.sistema.ufjf.eventos.GerenciaClientes;
import com.mycompany.sistema.ufjf.eventos.GerenciaEntregadores;
import com.mycompany.sistema.ufjf.exeptions.CpfException;
import com.mycompany.sistema.ufjf.exeptions.EmailException;
import com.mycompany.sistema.ufjf.exeptions.TelefoneException;
import com.mycompany.sistema.ufjf.model.Cliente;
import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.model.Email;
import com.mycompany.sistema.ufjf.model.Telefone;
import com.mycompany.sistema.ufjf.model.Cpf;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
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
    
    // JTextField Login Clientes
    private JTextField tfUsuarioClientes;
    private JTextField tfSenhaClientes;
    
    // JTextField Login Entregadores
    private JTextField tfUsuarioEntregador;
    private JTextField tfSenhaEntregador;
   
    // JTextField Login Administrador
    private JTextField tfUsuarioAdministrador;
    private JTextField tfSenhaAdministrador;
    
    // JTextField Cadastro
    private JTextField tfUsuarioCadastroCliente;
    private JTextField tfSenhaCadastroCliente;
   
    // JTextField Cadastro Entregador
    private JTextField tfUsuarioCadastroEntregador;
    private JTextField tfSenhaCadastroEntregador;
    
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

    // JLists
    private JList<Cliente> jlClientes;
    private JList<Entregador> jlEntregadores;
    
    public void exibirTelaLogin() {
        
        // Cria uma nova janela
        tela = new JFrame("Sistema de Entregas");
        tela.addWindowListener(new GerenciaClientes(this));
        tela.addWindowListener(new GerenciaEntregadores(this));
        
        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        
        // Inicial o painel geral de login com um BorderLayout
        principal = new JPanel();
        principal.setLayout(new BorderLayout());

        DefaultListModel<Cliente> modelCliente = new DefaultListModel<>();
        jlClientes = new JList<>(modelCliente);
        
        DefaultListModel<Entregador> modelEntregador = new DefaultListModel<>();
        jlEntregadores = new JList<>(modelEntregador);
        
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

        JPanel painelLogin = criaPainelAdministradorLogin();
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

    public String getUsuarioCliente() {
        return tfUsuarioClientes.getText();
    }
    
    public String getSenhaCliente() {
        return tfSenhaClientes.getText();
    }
    
    private JPanel criarPainelEntradaCliente() {
        
        // Cria um painel de Cliente
        JPanel painelCliente = new JPanel();
        
        JPanel painelComumLogin = criaPainelClientesLogin();
        painelComumLogin.setSize(250, HEIGHT);
        painelComumLogin.setLayout(new BoxLayout(painelComumLogin, BoxLayout.Y_AXIS));
        painelComumLogin.setBorder(BorderFactory.createRaisedBevelBorder());

        // Cria painel para botao login
        JPanel painelBotaoLogin = new JPanel();
        painelBotaoLogin.setBorder(new EmptyBorder(10, 0, 0, 0));
        
        // Cria botao de Login
        JButton botaoLogin = new JButton("Entrar");
        
        // Verifica login e abre tela cliente
        botaoLogin.addActionListener(new BotaoLoginCliente(tela, new TelaCliente(),this));

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
        JPanel painelComumLogin = criaPainelEntregadoresLogin();
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
        tfCpfCliente = new JTextField(12);
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
        tfUsuarioCadastroCliente = new JTextField(12);
        areaUsuarioCliente.add(tfUsuarioCadastroCliente);
        
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
        tfSenhaCadastroCliente = new JTextField(12);
        areaSenhaCliente.add(tfSenhaCadastroCliente);

        // Cria um painel para conter a área de email
        JPanel areaEmailCliente = new JPanel();
        areaEmailCliente.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailCliente = new JTextField(12);
        areaEmailCliente.add(tfEmailCliente);

        // Adicina senha e email ao painel
        panelDireito.add(areaEmailCliente);
        panelDireito.add(areaSenhaCliente);
        
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
        tfCpfEntregador = new JTextField(12);
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
        tfUsuarioCadastroEntregador = new JTextField(12);
        areaUsuarioEntregador.add(tfUsuarioCadastroEntregador);
        
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
        tfSenhaCadastroEntregador = new JTextField(12);
        areaSenhaEntregador.add(tfSenhaCadastroEntregador);

        // Cria um painel para conter a área de email
        JPanel areaEmailEntregador = new JPanel();
        areaEmailEntregador.setBorder(BorderFactory.createTitledBorder("Email"));
        tfEmailEntregador = new JTextField(12);
        areaEmailEntregador.add(tfEmailEntregador);

        // Adicina senha e email ao painel
        panelDireito.add(areaEmailEntregador);
        panelDireito.add(areaSenhaEntregador);
        
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
    
    private JPanel criaPainelClientesLogin() {
        
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
        tfUsuarioClientes = new JTextField(15);

        // Adiciona Input na Area
        areaUsuario.add(tfUsuarioClientes);
        
// -----------------------------------------------------------------------------               

        // Area de iserção de usuario
        JPanel areaSenha = new JPanel();
        
        // Titulo da Area
        areaSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
        
        // Input de usuario
        tfSenhaClientes = new JTextField(15);

        // Adiciona Input na Area
        areaSenha.add(tfSenhaClientes);
        
// -----------------------------------------------------------------------------               

        // Adiciona areas na area de login
        areaLogin.add(areaUsuario);
        areaLogin.add(areaSenha);
        
        return areaLogin;
    }
    private JPanel criaPainelEntregadoresLogin() {
        
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
        tfUsuarioEntregador = new JTextField(15);

        // Adiciona Input na Area
        areaUsuario.add(tfUsuarioEntregador);
        
// -----------------------------------------------------------------------------               

        // Area de iserção de usuario
        JPanel areaSenha = new JPanel();
        
        // Titulo da Area
        areaSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
        
        // Input de usuario
        tfSenhaEntregador = new JTextField(15);

        // Adiciona Input na Area
        areaSenha.add(tfSenhaEntregador);
        
// -----------------------------------------------------------------------------               

        // Adiciona areas na area de login
        areaLogin.add(areaUsuario);
        areaLogin.add(areaSenha);
        
        return areaLogin;
    }
    
    private JPanel criaPainelAdministradorLogin() {
        
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
        tfUsuarioAdministrador = new JTextField(15);

        // Adiciona Input na Area
        areaUsuario.add(tfUsuarioAdministrador);
        
// -----------------------------------------------------------------------------               

        // Area de iserção de usuario
        JPanel areaSenha = new JPanel();
        
        // Titulo da Area
        areaSenha.setBorder(BorderFactory.createTitledBorder("Senha"));
        
        // Input de usuario
        tfSenhaAdministrador = new JTextField(15);

        // Adiciona Input na Area
        areaSenha.add(tfSenhaAdministrador);
        
// -----------------------------------------------------------------------------               

        // Adiciona areas na area de login
        areaLogin.add(areaUsuario);
        areaLogin.add(areaSenha);
        
        return areaLogin;
    }
    
    public void addCliente() {

        DefaultListModel<Cliente> modelClientes = (DefaultListModel<Cliente>)jlClientes.getModel();
        
        try {
            if (tfNomeCliente.getText().length() != 0 && tfUsuarioCadastroCliente.getText().length() != 0 && tfEmailCliente.getText().length() != 0 && tfTelefoneCliente.getText().length() != 0 && tfCpfCliente.getText().length() != 0 && tfSenhaCadastroCliente.getText().length() != 0) {
                
                Cliente novoCliente = new Cliente(tfNomeCliente.getText(), Cpf.parser(tfCpfCliente.getText()), Telefone.parser(tfTelefoneCliente.getText()), new Email(tfEmailCliente.getText()), tfUsuarioCadastroCliente.getText(), tfSenhaCadastroCliente.getText());
                
                List<Cliente> clientes = new ArrayList<>();

                for (int i = 0; i < modelClientes.size(); i++) {
                    clientes.add(modelClientes.get(i));
                }
                
                // Verifica se o cliente já existe no model
                if (!clientes.contains(novoCliente)) {
                    modelClientes.addElement(novoCliente);
                } else {
                    JOptionPane.showMessageDialog(tela, "Cliente já existe!");
                }
            } else {
                JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
            }
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(tela, "O email " + tfEmailCliente.getText() +" é invalido!");
        } catch (TelefoneException e) {
            JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneCliente.getText() +" é invalido!");
        } catch (CpfException e) {
            JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfCliente.getText() +" é invalido!");
        }
    }
    
    public void carregaClientes(List<Cliente> clientes){

        DefaultListModel<Cliente> modelClientes = (DefaultListModel<Cliente>)jlClientes.getModel();

        for (Cliente c: clientes) {
            modelClientes.addElement(c);
        }
    }
    
    public List<Cliente> listaClientes(){
        DefaultListModel<Cliente> modelClientes = (DefaultListModel<Cliente>)jlClientes.getModel();
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < modelClientes.size(); i++) {
            clientes.add(modelClientes.get(i));
        }

        return clientes;
    }

    public void addEntregador(){

        DefaultListModel<Entregador> modelEntregador = (DefaultListModel<Entregador>)jlEntregadores.getModel();
        
        try {
            if (tfNomeEntregador.getText().length() != 0 && tfUsuarioCadastroEntregador.getText().length() != 0 && tfEmailEntregador.getText().length() != 0 && tfTelefoneEntregador.getText().length() != 0 && tfCpfEntregador.getText().length() != 0 && tfSenhaCadastroEntregador.getText().length() != 0) {
                
                Entregador novoEntregador = new Entregador(tfNomeEntregador.getText(), Cpf.parser(tfCpfEntregador.getText()), new Email(tfEmailEntregador.getText()), Telefone.parser(tfTelefoneEntregador.getText()), tfUsuarioCadastroEntregador.getText(), tfSenhaCadastroEntregador.getText());

                List<Entregador> entregador = new ArrayList<>();

                for (int i = 0; i < modelEntregador.size(); i++) {
                    entregador.add(modelEntregador.get(i));
                }
                
                // Verifica se o entregador já existe no model
                if (!entregador.contains(novoEntregador)) {
                    modelEntregador.addElement(novoEntregador);
                } else {
                    JOptionPane.showMessageDialog(tela, "Entregador já existe!");
                }
            } else {
                JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
            }
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(tela, "O email " + tfEmailEntregador.getText() +" é invalido!");
        } catch (TelefoneException e) {
            JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneEntregador.getText() +" é invalido!");
        } catch (CpfException e) {
            JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfEntregador.getText() +" é invalido!");
        }
    }
    
    public void carregaEntregadores(List<Entregador> entregador){

        DefaultListModel<Entregador> modelEntregador = (DefaultListModel<Entregador>)jlEntregadores.getModel();

        for (Entregador e: entregador) {
            modelEntregador.addElement(e);
        }
    }
    
    public List<Entregador> listaEntregadores(){
        DefaultListModel<Entregador> modelEntregador = (DefaultListModel<Entregador>)jlEntregadores.getModel();
        List<Entregador> entregadores = new ArrayList<>();

        for (int i = 0; i < modelEntregador.size(); i++) {
            entregadores.add(modelEntregador.get(i));
        }

        return entregadores;
    }
}
