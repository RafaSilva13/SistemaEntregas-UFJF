package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.AdicionarPacotesGrandes;
import com.mycompany.sistema.ufjf.eventos.AdicionarPacotesPequenos;
import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import com.mycompany.sistema.ufjf.eventos.GerenciaClientes;
import com.mycompany.sistema.ufjf.eventos.GerenciaClientesTelaClientes;
import com.mycompany.sistema.ufjf.eventos.GerenciaEntregasCliente;
import com.mycompany.sistema.ufjf.eventos.OpcaoMeusDadosCliente;
import com.mycompany.sistema.ufjf.eventos.OpcaoPedidosCliente;
import com.mycompany.sistema.ufjf.eventos.salvarAlteracoesCliente;
import com.mycompany.sistema.ufjf.exeptions.CpfException;
import com.mycompany.sistema.ufjf.exeptions.EmailException;
import com.mycompany.sistema.ufjf.exeptions.TelefoneException;
import com.mycompany.sistema.ufjf.model.Cliente;
import com.mycompany.sistema.ufjf.model.Cpf;
import com.mycompany.sistema.ufjf.model.Email;
import com.mycompany.sistema.ufjf.model.Entrega;
import com.mycompany.sistema.ufjf.model.PacoteGrande;
import com.mycompany.sistema.ufjf.model.PacotePequeno;
import com.mycompany.sistema.ufjf.model.Telefone;
import com.mycompany.sistema.ufjf.persistence.EntregaPersistence;
import com.mycompany.sistema.ufjf.persistence.Persistence;
import java.awt.BorderLayout;
import java.awt.Dimension;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
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
    
    private JTextField tfPesoPacotePequeno;
    private JTextField tfOrigemPacotePequeno;
    private JTextField tfDestinoPacotePequeno;
    private JTextField tfAlturaPacotePequeno;
    private JTextField tfLarguraPacotePequeno;
    private JCheckBox tfOpcaoFragilPacotePequeno;
    
    private JTextField tfPesoPacoteGrande;
    private JTextField tfOrigemPacoteGrande;
    private JTextField tfDestinoPacoteGrande;
    private JTextField tfAlturaPacoteGrande;
    private JTextField tfLarguraPacoteGrande;
    
    private JList<Entrega> jlEntregas;
    private JList<Entrega> jlEntregasCliente;
    private JList<Cliente> jlCliente;
    
    private Cliente usuarioLogado;

    public void exibirTelaClientes(Cliente cliente) {
        
        this.usuarioLogado = cliente;
                
        // Cria uma nova janela
        tela = new JFrame("Area Cliente");
        
        DefaultListModel<Entrega> model = new DefaultListModel<>();
        jlEntregas = new JList<>(model);
        
        DefaultListModel<Cliente> model2 = new DefaultListModel<>();
        jlCliente = new JList<>(model2);
        
        tela.addWindowListener(new GerenciaClientesTelaClientes(this));
        tela.addWindowListener(new GerenciaEntregasCliente(this));

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
        item2.addActionListener(new OpcaoPedidosCliente(this));

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

        // Preenche dados do cliente
        tfNomeCliente.setText(this.usuarioLogado.getNome());
        tfUsuarioCliente.setText(this.usuarioLogado.getUsuario());
        tfCpfCliente.setText(this.usuarioLogado.getCpf().toString());
        tfEmailCliente.setText(this.usuarioLogado.getEmail().toString());
        tfTelefoneCliente.setText(this.usuarioLogado.getNumeroDeTelefone().toString());
        tfSenhaCliente.setText(this.usuarioLogado.getSenha());

// -----------------------------------------------------------------------------               

        // Cria botão de salvar alteracoes e adiciona em um painel
        JPanel painelBotaoMeusDados = new JPanel();
        painelBotaoMeusDados.setBorder(new EmptyBorder(12, 0, 0, 0));
        
        JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");

        // Chama a função de editarsalvarAlteracoesCliente
        botaoSalvarAlteracoes.addActionListener(new salvarAlteracoesCliente(this));

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
    
    public void carregaClientes(List<Cliente> clientes){

        DefaultListModel<Cliente> modelClientes = (DefaultListModel<Cliente>)jlCliente.getModel();

        for (Cliente c: clientes) {
            modelClientes.addElement(c);
        }
    }
    
    public List<Cliente> listaClientes(){
        DefaultListModel<Cliente> modelClientes = (DefaultListModel<Cliente>)jlCliente.getModel();
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < modelClientes.size(); i++) {
            clientes.add(modelClientes.get(i));
        }

        return clientes;
    }
        
    public void salvarAlteracoes(){

        int selectedIndex = -1;
        
        DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)jlCliente.getModel();
        
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            clientes.add(model.get(i));
        }
        
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(usuarioLogado)) {
                selectedIndex = i;
            }
        }

        if(selectedIndex != -1){

            Cliente cliente = model.get(selectedIndex);

            model.remove(selectedIndex);

            try {
                cliente.setNome(tfNomeCliente.getText());
                cliente.setUsuario(tfEmailCliente.getText());
                cliente.setEmail(new Email(tfUsuarioCliente.getText()));
                cliente.setCpf(new Cpf().parser(tfCpfCliente.getText()));
                cliente.setNumeroDeTelefone(new Telefone().parser(tfTelefoneCliente.getText()));
                
                model.add(selectedIndex, cliente);
                
                JOptionPane.showMessageDialog(tela, "Usuario alterado!");
            } catch (EmailException e) {
                JOptionPane.showMessageDialog(tela, "O email " + tfEmailCliente.getText() +" é invalido!");
            } catch (TelefoneException e) {
                JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneCliente.getText() +" é invalido!");
            } catch (CpfException e) {
                JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfCliente.getText() +" é invalido!");
            }
        }
    }
    
    public void exibirPedidosCliente() {
        
        // Remoção o painelUsuarioDadosUsuario atual
        principal.removeAll();
        
        JPanel areaPedidos  = new JPanel();
        areaPedidos.setLayout(new BorderLayout());
        
        JPanel painelPedidos = new JPanel();
        
//------------------------------------------------------------------------------
        DefaultListModel<Entrega> model = new DefaultListModel<>();
        jlEntregasCliente = new JList<>(model);

        carregaEntregasCliente(this.usuarioLogado);

        painelPedidos.setBorder(BorderFactory.createTitledBorder("Pedidos"));
        painelPedidos.setPreferredSize(new Dimension(518, HEIGHT));
        painelPedidos.setLayout(new BorderLayout());
        
        painelPedidos.add(new JScrollPane(jlEntregasCliente), BorderLayout.CENTER);
        
//------------------------------------------------------------------------------
        
        JTabbedPane barraOpcaoPacote = new JTabbedPane();
        barraOpcaoPacote.setPreferredSize(new Dimension(WIDTH/3, HEIGHT));
        barraOpcaoPacote.setBorder (BorderFactory.createEmptyBorder());
        barraOpcaoPacote.addTab("Pacote Pequeno", criaFormularioPacotePequeno());
        barraOpcaoPacote.addTab("Pacote Grande", criaFormularioPacoteGrando());
        
//------------------------------------------------------------------------------

        areaPedidos.add(painelPedidos, BorderLayout.WEST);
        areaPedidos.add(barraOpcaoPacote, BorderLayout.EAST);

        // Adiciona os pedidos a janela
        principal.add(areaPedidos);
        
        // Atualiza tela
        principal.revalidate();
        principal.repaint();
        
    }
    
    public JPanel criaFormularioPacotePequeno() {
        
        JPanel formularioPacotePequeno = new JPanel();
        formularioPacotePequeno.setBorder (BorderFactory.createEmptyBorder());
        
        JPanel painelPacotePequenoLabel = new JPanel();
        painelPacotePequenoLabel.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        
        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblPeso);
        
        JLabel lblOrigem = new JLabel("Origem:");
        lblOrigem.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblOrigem);
        
        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblDestino);
        
        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblAltura);
        
        JLabel lblLargura = new JLabel("Largura:");
        lblLargura.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblLargura);
        
        JLabel lblFragil = new JLabel("Fragil:");
        lblFragil.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacotePequenoLabel.add(lblFragil);
        
        JPanel painelPacotePequenoField = new JPanel();
        painelPacotePequenoField.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        
        tfPesoPacotePequeno = new JTextField(15);
        tfOrigemPacotePequeno = new JTextField(15);
        tfDestinoPacotePequeno = new JTextField(15);
        tfAlturaPacotePequeno = new JTextField(15);
        tfLarguraPacotePequeno = new JTextField(15);
        tfOpcaoFragilPacotePequeno = new JCheckBox();

//------------------------------------------------------------------------------
        
        painelPacotePequenoField.add(tfPesoPacotePequeno);
        painelPacotePequenoField.add(tfOrigemPacotePequeno);
        painelPacotePequenoField.add(tfDestinoPacotePequeno);
        painelPacotePequenoField.add(tfAlturaPacotePequeno);
        painelPacotePequenoField.add(tfLarguraPacotePequeno);
        painelPacotePequenoField.add(tfOpcaoFragilPacotePequeno);
        
        formularioPacotePequeno.add(painelPacotePequenoLabel);
        formularioPacotePequeno.add(painelPacotePequenoField);
        
        JButton btnAdicionarPacotePequeno = new JButton("Criar Pedido");
        
        btnAdicionarPacotePequeno.addActionListener(new AdicionarPacotesPequenos(this));

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionarPacotePequeno);

        formularioPacotePequeno.add(botoes, BorderLayout.SOUTH);

        return formularioPacotePequeno;
    }
    
    public JPanel criaFormularioPacoteGrando() {
        
        JPanel formularioPacoteGrande = new JPanel();
        formularioPacoteGrande.setBorder (BorderFactory.createEmptyBorder());
        
        JPanel painelPacoteGrandeLabel = new JPanel();
        painelPacoteGrandeLabel.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        
        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacoteGrandeLabel.add(lblPeso);
        
        JLabel lblOrigem = new JLabel("Origem:");
        lblOrigem.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacoteGrandeLabel.add(lblOrigem);
        
        JLabel lblDestino = new JLabel("Destino:");
        lblDestino.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacoteGrandeLabel.add(lblDestino);
        
        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacoteGrandeLabel.add(lblAltura);
        
        JLabel lblLargura = new JLabel("Largura:");
        lblLargura.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelPacoteGrandeLabel.add(lblLargura);
        
        JPanel painelPacoteGrandeField = new JPanel();
        painelPacoteGrandeField.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        
        tfPesoPacoteGrande = new JTextField(15);
        tfOrigemPacoteGrande = new JTextField(15);
        tfDestinoPacoteGrande = new JTextField(15);
        tfAlturaPacoteGrande = new JTextField(15);
        tfLarguraPacoteGrande = new JTextField(15);

//------------------------------------------------------------------------------
        
        painelPacoteGrandeField.add(tfPesoPacoteGrande);
        painelPacoteGrandeField.add(tfOrigemPacoteGrande);
        painelPacoteGrandeField.add(tfDestinoPacoteGrande);
        painelPacoteGrandeField.add(tfAlturaPacoteGrande);
        painelPacoteGrandeField.add(tfLarguraPacoteGrande);
        
        formularioPacoteGrande.add(painelPacoteGrandeLabel);
        formularioPacoteGrande.add(painelPacoteGrandeField);
         
        JButton btnAdicionarPacoteGrande = new JButton("Criar Pedido");
        
        btnAdicionarPacoteGrande.addActionListener(new AdicionarPacotesGrandes(this));

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionarPacoteGrande);

        formularioPacoteGrande.add(botoes, BorderLayout.SOUTH);
        
        return formularioPacoteGrande;
    }
    
    public List<Entrega> listaEntregas(){
        
        DefaultListModel<Entrega> model = (DefaultListModel<Entrega>)jlEntregas.getModel();
        List<Entrega> minhaEntregas = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            minhaEntregas.add(model.get(i));
        }

        return minhaEntregas;
    }
    
    public void carregaEntregas(List<Entrega> entregas) {

        DefaultListModel<Entrega> modelEntregas = (DefaultListModel<Entrega>)jlEntregas.getModel();

        for (Entrega e: entregas) {
            modelEntregas.addElement(e);
        }
    }
    
    public void carregaEntregasCliente(Cliente clienteAtual){
                
        DefaultListModel<Entrega> minhaEntregas = (DefaultListModel<Entrega>)jlEntregasCliente.getModel();
        
        List<Entrega> entregas = listaEntregas();
       
        for (Entrega e : entregas) {
            Cliente cliente = e.getCliente();
                        
            if (cliente.equals(clienteAtual)) {
                minhaEntregas.addElement(e);
            }
        }
    }
    
    public void addPacotePequeno() {

        DefaultListModel<Entrega> modelEntregas = (DefaultListModel<Entrega>)jlEntregas.getModel();
        
        if (tfPesoPacotePequeno.getText().length() != 0 && tfOrigemPacotePequeno.getText().length() != 0 && tfDestinoPacotePequeno.getText().length() != 0 && tfAlturaPacotePequeno.getText().length() != 0 && tfLarguraPacotePequeno.getText().length() != 0) {

            PacotePequeno novoPedido = new PacotePequeno(Float.parseFloat(tfPesoPacotePequeno.getText()), tfOrigemPacotePequeno.getText(), tfDestinoPacotePequeno.getText(), Float.parseFloat(tfAlturaPacotePequeno.getText()), Float.parseFloat(tfLarguraPacotePequeno.getText()), "Pacote Pequeno", tfOpcaoFragilPacotePequeno.isSelected());

            Entrega novaEntrega = new Entrega(usuarioLogado, "Aguardando Entregador", novoPedido);

            List<Entrega> entregas = new ArrayList<>();

            for (int i = 0; i < modelEntregas.size(); i++) {
                entregas.add(modelEntregas.get(i));
            }

            // Verifica se a entrega já existe no model
            if (!entregas.contains(novaEntrega)) {

                modelEntregas.addElement(novaEntrega);

                JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso!");

                tfPesoPacotePequeno.setText("");
                tfOrigemPacotePequeno.setText("");
                tfDestinoPacotePequeno.setText("");
                tfAlturaPacotePequeno.setText("");
                tfLarguraPacotePequeno.setText("");
                tfOpcaoFragilPacotePequeno.setSelected(false);                    
            } else {
                JOptionPane.showMessageDialog(tela, "Pedido já existe!");
            }
        } else {
            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
        }
    }
    
    public void addPacoteGrande() {

        DefaultListModel<Entrega> modelEntregas = (DefaultListModel<Entrega>)jlEntregas.getModel();
        
        if (tfPesoPacoteGrande.getText().length() != 0 && tfOrigemPacoteGrande.getText().length() != 0 && tfDestinoPacoteGrande.getText().length() != 0 && tfAlturaPacoteGrande.getText().length() != 0 && tfLarguraPacoteGrande.getText().length() != 0) {

            PacoteGrande novoPedido = new PacoteGrande(Float.parseFloat(tfPesoPacoteGrande.getText()), tfOrigemPacoteGrande.getText(), tfDestinoPacoteGrande.getText(), Float.parseFloat(tfAlturaPacoteGrande.getText()), Float.parseFloat(tfLarguraPacoteGrande.getText()), "Pacote Grande");

            Entrega novaEntrega = new Entrega(usuarioLogado, "Aguardando Entregador", novoPedido);

            List<Entrega> entregas = new ArrayList<>();

            for (int i = 0; i < modelEntregas.size(); i++) {
                entregas.add(modelEntregas.get(i));
            }

            // Verifica se a entrega já existe no model
            if (!entregas.contains(novaEntrega)) {

                modelEntregas.addElement(novaEntrega);

                JOptionPane.showMessageDialog(tela, "Cadastro realizado com sucesso!");

                tfPesoPacoteGrande.setText("");
                tfOrigemPacoteGrande.setText("");
                tfDestinoPacoteGrande.setText("");
                tfAlturaPacoteGrande.setText("");
                tfLarguraPacoteGrande.setText("");
            } else {
                JOptionPane.showMessageDialog(tela, "Pedido já existe!");
            }
        } else {
            JOptionPane.showMessageDialog(tela, "Preencha todos os campos!");
        }
    }
    
}
