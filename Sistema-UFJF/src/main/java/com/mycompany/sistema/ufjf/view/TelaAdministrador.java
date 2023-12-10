package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.GerenciaClientesAdministrador;
import com.mycompany.sistema.ufjf.eventos.GerenciaEntregadoresAdministrador;
import com.mycompany.sistema.ufjf.eventos.GerenciaEntregasAdministrador;
import com.mycompany.sistema.ufjf.eventos.OpcaoDadosGeraisAdministrador;
import com.mycompany.sistema.ufjf.eventos.OpcaoPedidosAdministrador;
import com.mycompany.sistema.ufjf.eventos.RemoverUsuario;
import com.mycompany.sistema.ufjf.eventos.SelecionarContatoCliente;
import com.mycompany.sistema.ufjf.eventos.SelecionarContatoEntregador;
import com.mycompany.sistema.ufjf.model.Cliente;
import com.mycompany.sistema.ufjf.model.Entrega;
import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.persistence.ClientePersistence;
import com.mycompany.sistema.ufjf.persistence.EntregadorPersistence;
import com.mycompany.sistema.ufjf.persistence.Persistence;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaAdministrador {

    private JFrame tela;
    private JPanel principal;
    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    private final int V_GAP = 10;
    private final int H_GAP = 5;

    private JTextField tfNome;
    private JTextField tfUsuario;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JTextField tfCpf;
    public String selectedItem = "";

    private JList<Cliente> jlCliente;
    private JList<Entregador> jlEntregador;
    private JList<Entrega> jlEntregas;
    
    public void exibirTelaAdministrador() {
        
        // Cria uma nova janela
        tela = new JFrame("Area Administrador");
        
        DefaultListModel<Entrega> model = new DefaultListModel<>();
        jlEntregas = new JList<>(model);
        
        DefaultListModel<Entregador> model2 = new DefaultListModel<>();
        jlEntregador = new JList<>(model2);
        
        DefaultListModel<Cliente> model3 = new DefaultListModel<>();
        jlCliente = new JList<>(model3);
        
        tela.addWindowListener(new GerenciaEntregasAdministrador(this));
        tela.addWindowListener(new GerenciaClientesAdministrador(this));
        tela.addWindowListener(new GerenciaEntregadoresAdministrador(this));

        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adiciona o menu de Opções
        tela.setJMenuBar(criaBarraDeOpcoes());

        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        
        this.exibirDadosGerais();

        // Adiciona o painelUsuarioDadosUsuario geral a janela
        tela.add(principal);

        // Define o tamanho do painelUsuarioDadosUsuario geral e sua posição como central
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        
        // Bloqueia o redimensionamento da janela
        tela.setResizable(false);
        
        // Deixa o painelUsuarioDadosUsuario visível
        tela.setVisible(true);
    }
    
    private JMenuBar criaBarraDeOpcoes() {
        
        // Cria barra de menu de opções 
        JMenuBar menuBar = new JMenuBar();
        
        // Cria um novo menu
        JMenu menu = new JMenu("Opções");
        
        JMenuItem item1 = new JMenuItem("Dados Gerais");
        item1.addActionListener(new OpcaoDadosGeraisAdministrador(this));
        
        JMenuItem item2 = new JMenuItem("Pedidos");
        item2.addActionListener(new OpcaoPedidosAdministrador(this));

        // Adicione opções no menu
        menu.add(item1);
        menu.addSeparator();
        menu.add(item2);

        // Adiciona menu na barra de menus
        menuBar.add(menu);
        
        return menuBar;
    }
    
    public void exibirDadosGerais() {
        
        // Remoção o painelUsuarioDadosUsuario atual
        principal.removeAll();
        
        JPanel areaDadosGerais = new JPanel();
        areaDadosGerais.setLayout(new BorderLayout());
        areaDadosGerais.setPreferredSize(new Dimension(500, 200));
       
//------------------------------------------------------------------------------

        String[] menuItems = {"Clientes", "Entregadores"};

        JPanel painelTipoUsuario = new JPanel();
        painelTipoUsuario.setBorder(BorderFactory.createTitledBorder("Tipo Usuário"));
        painelTipoUsuario.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        painelTipoUsuario.setLayout(new BorderLayout());
        
        // Criando um DefaultListModel e adicionando os itens
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String item : menuItems) {
            listModel.addElement(item);
        }

        // Criando a JList com o DefaultListModel
        JList<String> menuList = new JList<>(listModel);

        painelTipoUsuario.add(new JScrollPane(menuList), BorderLayout.CENTER);
        
//------------------------------------------------------------------------------

        JPanel painelUsuario = new JPanel();
        painelUsuario.setBorder(BorderFactory.createTitledBorder("Usuários"));
        painelUsuario.setPreferredSize(new Dimension(WIDTH/4, HEIGHT));
        painelUsuario.setLayout(new BorderLayout());
        
//------------------------------------------------------------------------------
       
        menuList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    selectedItem = menuList.getSelectedValue();
                    exibirDadosGerais();
                }
            }
        });
        
//------------------------------------------------------------------------------

        JPanel painelUsuarioDadosUsuario = new JPanel();
        painelUsuarioDadosUsuario.setPreferredSize(new Dimension(WIDTH/3, HEIGHT));
        painelUsuarioDadosUsuario.setBorder(BorderFactory.createTitledBorder("Dados Usuário"));

        JPanel formulario = new JPanel();
        JPanel painelUsuarioDadosUsuarioLabel = new JPanel();
        painelUsuarioDadosUsuarioLabel.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelUsuarioDadosUsuarioLabel.add(lblNome);
        
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelUsuarioDadosUsuarioLabel.add(lblUsuario);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelUsuarioDadosUsuarioLabel.add(lblEmail);
        
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelUsuarioDadosUsuarioLabel.add(lblCpf);
        
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBorder(new EmptyBorder(2, 0, 2, 0));
        painelUsuarioDadosUsuarioLabel.add(lblTelefone);

//------------------------------------------------------------------------------
        
        JPanel painelUsuarioDadosUsuarioField = new JPanel();
        painelUsuarioDadosUsuarioField.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        
        tfNome = new JTextField(15);
        tfUsuario = new JTextField(15);
        tfEmail = new JTextField(15);
        tfCpf = new JTextField(15);
        tfTelefone = new JTextField(15);
        
        tfNome.setEditable(false);
        tfUsuario.setEditable(false);
        tfEmail.setEditable(false);
        tfCpf.setEditable(false);
        tfTelefone.setEditable(false);

//------------------------------------------------------------------------------
        
        painelUsuarioDadosUsuarioField.add(tfNome);
        painelUsuarioDadosUsuarioField.add(tfUsuario);
        painelUsuarioDadosUsuarioField.add(tfEmail);
        painelUsuarioDadosUsuarioField.add(tfCpf);
        painelUsuarioDadosUsuarioField.add(tfTelefone);
        
//------------------------------------------------------------------------------
        formulario.add(painelUsuarioDadosUsuarioLabel);
        formulario.add(painelUsuarioDadosUsuarioField);

        painelUsuarioDadosUsuario.setLayout(new BorderLayout());
        painelUsuarioDadosUsuario.add(formulario, BorderLayout.CENTER);

//------------------------------------------------------------------------------
        
        JButton btnRemover = new JButton("Remover");
        
//------------------------------------------------------------------------------
        
        if (selectedItem != null && selectedItem != "") {
            if (selectedItem.equals("Clientes")) {
                DefaultListModel<Cliente> model = new DefaultListModel<>();
                jlCliente.addListSelectionListener(new SelecionarContatoCliente(this));

                painelUsuario.add(new JScrollPane(jlCliente), BorderLayout.CENTER);
                btnRemover.addActionListener(new RemoverUsuario(this, selectedItem));

            } else if (selectedItem.equals("Entregadores")) {
                DefaultListModel<Entregador> model = new DefaultListModel<>();
                jlEntregador.addListSelectionListener(new SelecionarContatoEntregador(this));

                painelUsuario.add(new JScrollPane(jlEntregador), BorderLayout.CENTER);
                btnRemover.addActionListener(new RemoverUsuario(this, selectedItem));
            }
        }

//------------------------------------------------------------------------------

        JPanel botoes = new JPanel();
        botoes.add(btnRemover);

        painelUsuarioDadosUsuario.add(botoes, BorderLayout.SOUTH);
        
//------------------------------------------------------------------------------
        
        areaDadosGerais.add(painelTipoUsuario, BorderLayout.WEST);
        areaDadosGerais.add(painelUsuario, BorderLayout.CENTER);
        areaDadosGerais.add(painelUsuarioDadosUsuario, BorderLayout.EAST);
        
        // Adiciona os dados gerais a janela
        principal.add(areaDadosGerais);
        
        // Atualiza tela
        principal.revalidate();
        principal.repaint();
        
    }
    
    public void atualizarFormularioCliente(){
        int selectedIndex = jlCliente.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)jlCliente.getModel();
            Cliente cliente = model.get(selectedIndex);
            
            tfNome.setText(cliente.getNome());
            tfUsuario.setText(cliente.getUsuario());
            tfEmail.setText(cliente.getEmail().toString());
            tfTelefone.setText(cliente.getNumeroDeTelefone().toString());
            tfCpf.setText(cliente.getCpf().toString());
        }
    }
    
    public void atualizarFormularioEntregador(){
        int selectedIndex = jlEntregador.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Entregador> model = (DefaultListModel<Entregador>)jlEntregador.getModel();
            Entregador entregador = model.get(selectedIndex);
            
            tfNome.setText(entregador.getNome());
            tfUsuario.setText(entregador.getUsuario());
            tfEmail.setText(entregador.getEmail().toString());
            tfTelefone.setText(entregador.getNumeroDeTelefone().toString());
            tfCpf.setText(entregador.getCpf().toString());
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
    
    public void carregaClientes(List<Cliente> clientes){

        DefaultListModel<Cliente> modelCliente = (DefaultListModel<Cliente>)jlCliente.getModel();

        for (Cliente c: clientes) {
            modelCliente.addElement(c);
        }
    }
    
    public List<Entregador> listaEntregadores(){
        DefaultListModel<Entregador> modelEntregador = (DefaultListModel<Entregador>)jlEntregador.getModel();
        List<Entregador> entregadores = new ArrayList<>();

        for (int i = 0; i < modelEntregador.size(); i++) {
            entregadores.add(modelEntregador.get(i));
        }

        return entregadores;
    }
    
    public void carregaEntregadores(List<Entregador> entregadores){

        DefaultListModel<Entregador> modelEntregador = (DefaultListModel<Entregador>)jlEntregador.getModel();

        for (Entregador e: entregadores) {
            modelEntregador.addElement(e);
        }
    }
    
    public List<Entrega> listaEntregas(){
        
        DefaultListModel<Entrega> model = (DefaultListModel<Entrega>)jlEntregas.getModel();
        List<Entrega> minhaEntregas = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            minhaEntregas.add(model.get(i));
        }

        return minhaEntregas;
    }
    
    public void carregaEntregas(List<Entrega> entregas){

        DefaultListModel<Entrega> modelEntregas = (DefaultListModel<Entrega>)jlEntregas.getModel();

        for (Entrega e: entregas) {
            modelEntregas.addElement(e);
        }
    }
    
    public void removerUsuario(String tipoUsuario) {
        if (tipoUsuario.equals("Clientes")) {            
            int selectedIndex = jlCliente.getSelectedIndex();

            if(selectedIndex != -1){
                DefaultListModel<Cliente> model = (DefaultListModel<Cliente>)jlCliente.getModel();
                model.remove(selectedIndex);
            }
        } else if (tipoUsuario.equals("Entregadores")) {
            
            int selectedIndex = jlEntregador.getSelectedIndex();

            if(selectedIndex != -1){
                DefaultListModel<Entregador> model = (DefaultListModel<Entregador>)jlEntregador.getModel();
                model.remove(selectedIndex);
            }
        }
    }
    
    public void exibirPedidosAdministrador () {
        
        // Remoção o painelUsuarioDadosUsuario atual
        principal.removeAll();
        
        JPanel areaPedidos  = new JPanel();
        areaPedidos.setLayout(new BorderLayout());
        
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Entregas"));
        painel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painel.setLayout(new BorderLayout());
        
        painel.add(new JScrollPane(jlEntregas), BorderLayout.CENTER);
        
        areaPedidos.add(painel, BorderLayout.CENTER);

        // Adiciona os pedidos a janela
        principal.add(areaPedidos);
        
        // Atualiza tela
        principal.revalidate();
        principal.repaint();
    }
}

