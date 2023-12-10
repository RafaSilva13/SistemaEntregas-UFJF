package com.mycompany.sistema.ufjf.view;

import com.mycompany.sistema.ufjf.eventos.AdicionarEntregadorNoPacote;
import com.mycompany.sistema.ufjf.eventos.BotaoSairParaLogin;
import com.mycompany.sistema.ufjf.eventos.FinalizarEntregaPacote;
import com.mycompany.sistema.ufjf.eventos.GerenciaEntregasEntregador;
import com.mycompany.sistema.ufjf.eventos.OpcaoEntregasEntregador;
import com.mycompany.sistema.ufjf.eventos.OpcaoMeusDadosEntregador;
import com.mycompany.sistema.ufjf.eventos.salvarAlteracoesEntregador;
import com.mycompany.sistema.ufjf.exeptions.CpfException;
import com.mycompany.sistema.ufjf.exeptions.EmailException;
import com.mycompany.sistema.ufjf.exeptions.TelefoneException;
import com.mycompany.sistema.ufjf.model.Cpf;
import com.mycompany.sistema.ufjf.model.Email;
import com.mycompany.sistema.ufjf.model.Entrega;
import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.model.Telefone;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JTextField;
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
    
    private JTextField tfPlacaModeloVeiculo;
    private JTextField tfCapacidadeCargaVeiculo;
    private JTextField tfAnoFabricacaoVeiculo;

    private JList<Entrega> jlEntregas;
    private JList<Entregador> jlEntregador;

    private Entregador usuarioLogado;
    
    private JButton btnAdicionarEntregadorAPacote;
    private JButton btnFinalizarEntregaPacote;

    public void exibirTelaEntregador(Entregador entregador) {
        
        this.usuarioLogado = entregador;
        
        // Cria uma nova janela
        tela = new JFrame("Area Entregador");
        tela.addWindowListener(new GerenciaEntregasEntregador(this));
        
        // Define o excerramento do programa ao fechar a janela
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adiciona o menu de Opções
        tela.setJMenuBar(criaBarraDeOpcoes());

        // Cria o painel principal
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        
        this.exibirPedidosEntregador();
        
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
        item1.addActionListener(new OpcaoMeusDadosEntregador(this));

        JMenuItem item2 = new JMenuItem("Entregas");
        item1.addActionListener(new OpcaoEntregasEntregador(this));

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
        
        // Cria um painel para conter a área de placa
        JPanel areaPlacaEntregador = new JPanel();
        areaPlacaEntregador.setBorder(BorderFactory.createTitledBorder("Placa/Modelo Veiculo"));
        tfPlacaModeloVeiculo = new JTextField(12);
        areaPlacaEntregador.add(tfPlacaModeloVeiculo);
        
        // Adicina nome e cpf ao painel
        panelEsquerdo.add(areaNomeEntregador);
        panelEsquerdo.add(areaCpfEntregador);
        panelEsquerdo.add(areaPlacaEntregador);
        
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
        
        // Cria um painel para conter a área de capacidade de carga
        JPanel areaCapacidadeCargaEntregador = new JPanel();
        areaCapacidadeCargaEntregador.setBorder(BorderFactory.createTitledBorder("CapacidadeDeCarga"));
        tfCapacidadeCargaVeiculo = new JTextField(12);
        areaCapacidadeCargaEntregador.add(tfCapacidadeCargaVeiculo);
       
        // Adicina usuario e telefone ao painel
        panelCentral.add(areaUsuarioEntregador);
        panelCentral.add(areaTelefoneEntregador);
        panelCentral.add(areaCapacidadeCargaEntregador);

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
        
        // Cria um painel para conter a área de placa
        JPanel areaAnoFabricacaoEntregador = new JPanel();
        areaAnoFabricacaoEntregador.setBorder(BorderFactory.createTitledBorder("Ano Fabricaão"));
        tfAnoFabricacaoVeiculo = new JTextField(12);
        areaAnoFabricacaoEntregador.add(tfAnoFabricacaoVeiculo);

        // Adicina email e senha ao painel
        panelDireito.add(areaEmailEntregador);
        panelDireito.add(areaSenhaEntregador);
        panelDireito.add(areaAnoFabricacaoEntregador);
        
// -----------------------------------------------------------------------------     

        // Preenche dados do entregador
        tfNomeEntregador.setText(this.usuarioLogado.getNome());
        tfUsuarioEntregador.setText(this.usuarioLogado.getUsuario());
        tfCpfEntregador.setText(this.usuarioLogado.getCpf().toString());
        tfEmailEntregador.setText(this.usuarioLogado.getEmail().toString());
        tfTelefoneEntregador.setText(this.usuarioLogado.getNumeroDeTelefone().toString());
        tfSenhaEntregador.setText(this.usuarioLogado.getSenha());
        tfPlacaModeloVeiculo.setText(this.usuarioLogado.retornaVeiculo().getPlacaModelo().toString());
        tfCapacidadeCargaVeiculo.setText(this.usuarioLogado.retornaVeiculo().getCapacidadeCarga());
        tfAnoFabricacaoVeiculo.setText(this.usuarioLogado.retornaVeiculo().getAnoDeFabricacao());
        
        tfPlacaModeloVeiculo.setEditable(false);
        tfCapacidadeCargaVeiculo.setEditable(false);
        tfAnoFabricacaoVeiculo.setEditable(false);
        
// -----------------------------------------------------------------------------               

        // Cria botão de salver alteracoes e adiciona em um painel
        JPanel painelBotaoMeusDados = new JPanel();
        painelBotaoMeusDados.setBorder(new EmptyBorder(15, 0, 10, 0));
        
        JButton botaoSalvarAlteracoes = new JButton("Salvar Alterações");

        // Chama a função de editar
        botaoSalvarAlteracoes.addActionListener(new salvarAlteracoesEntregador(this));

        painelBotaoMeusDados.add(botaoSalvarAlteracoes);

// -----------------------------------------------------------------------------               

        // Adiciona paineis de componentes ao painel de dados pessoais
        areaDadosPessoais.add(areaTextoMeusDados, BorderLayout.NORTH);
        areaDadosPessoais.add(panelEsquerdo, BorderLayout.WEST);
        areaDadosPessoais.add(panelCentral, BorderLayout.CENTER);
        areaDadosPessoais.add(panelDireito, BorderLayout.EAST);
        areaDadosPessoais.add(painelBotaoMeusDados, BorderLayout.SOUTH);
        
// -----------------------------------------------------------------------------          

        JPanel areaPainelMeusDados = new JPanel();
        
        areaDadosPessoais.setSize(500, HEIGHT);
        
        // Adiciona paineis ao painel atual    
        areaPainelMeusDados.add(areaDadosPessoais, BorderLayout.CENTER);
        
        // Adiciona o painelMeusDados ao painel principal
        principal.add(areaPainelMeusDados);

        // Atualiza a exibição
        principal.revalidate();
        principal.repaint();
    }
    
     public void exibirPedidosEntregador() {
        
        // Remoção o painelUsuarioDadosUsuario atual
        principal.removeAll();
        
        JPanel areaPedidos  = new JPanel();
        areaPedidos.setLayout(new BorderLayout());
        
        JPanel painelPedidos = new JPanel();
        
//------------------------------------------------------------------------------
        
        painelPedidos.setBorder(BorderFactory.createTitledBorder("Pedidos"));
        painelPedidos.setPreferredSize(new Dimension(518, HEIGHT));
        painelPedidos.setLayout(new BorderLayout());
        
        DefaultListModel<Entrega> model = new DefaultListModel<>();
        jlEntregas = new JList<>(model);

        painelPedidos.add(new JScrollPane(jlEntregas), BorderLayout.CENTER);
        
//------------------------------------------------------------------------------
        
        btnAdicionarEntregadorAPacote = new JButton("Selecionar Pedido");
        btnAdicionarEntregadorAPacote.addActionListener(new AdicionarEntregadorNoPacote(this));

        btnFinalizarEntregaPacote = new JButton("Finalizar Entrega");
        btnFinalizarEntregaPacote.addActionListener(new FinalizarEntregaPacote(this));
                
        JPanel botoes = new JPanel();
        botoes.add(btnAdicionarEntregadorAPacote);
        botoes.add(btnFinalizarEntregaPacote);
        
//------------------------------------------------------------------------------

        areaPedidos.add(painelPedidos, BorderLayout.WEST);
        areaPedidos.add(botoes, BorderLayout.SOUTH);

        // Adiciona os pedidos a janela
        principal.add(areaPedidos);
        
        // Atualiza tela
        principal.revalidate();
        principal.repaint();
        
    }
     
    public void carregaEntregas(List<Entrega> entregas){

        DefaultListModel<Entrega> modelEntregas = (DefaultListModel<Entrega>)jlEntregas.getModel();

        for (Entrega e: entregas) {
            modelEntregas.addElement(e);
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
    
    public void addEntregadorAPacote () {

        int selectedIndex = jlEntregas.getSelectedIndex();

        if(selectedIndex != -1){
            
            DefaultListModel<Entrega> model = (DefaultListModel<Entrega>)jlEntregas.getModel();

            Entrega entrega = model.get(selectedIndex);

            model.remove(selectedIndex);

            entrega.cadastraEntregador(usuarioLogado);
            entrega.setStatusEntrega("A Caminho");
            
            model.add(selectedIndex, entrega);
            
            btnAdicionarEntregadorAPacote.setEnabled(false);

            JOptionPane.showMessageDialog(tela, "Entregador associado!");
        }
    }
    
    public void finalizaEntregaDoPacote () {
        int selectedIndex = jlEntregas.getSelectedIndex();

        if(selectedIndex != -1){
            
            DefaultListModel<Entrega> model = (DefaultListModel<Entrega>)jlEntregas.getModel();

            Entrega entrega = model.get(selectedIndex);

            if (entrega.getStatusEntrega() == "A Caminho") {
                model.remove(selectedIndex);

                entrega.cadastraEntregador(usuarioLogado);
                entrega.setStatusEntrega("Entregue");

                model.add(selectedIndex, entrega);

                btnAdicionarEntregadorAPacote.setEnabled(false);

                JOptionPane.showMessageDialog(tela, "Entrega finalizada!"); 
            }
            else {
                JOptionPane.showMessageDialog(tela, "O pedido ainda não está a caminho!"); 
            }
        }
    }
    
    public void salvarAlteracoes() {

        int selectedIndex = -1;
        
        DefaultListModel<Entregador> model = (DefaultListModel<Entregador>)jlEntregador.getModel();
        
        List<Entregador> entregadores = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            entregadores.add(model.get(i));
        }
        
        for (int i = 0; i < entregadores.size(); i++) {
            if (entregadores.get(i).equals(usuarioLogado)) {
                selectedIndex = i;
            }
        }

        if(selectedIndex != -1){

            Entregador entregador = model.get(selectedIndex);

            model.remove(selectedIndex);

            try {
                entregador.setNome(tfNomeEntregador.getText());
                entregador.setUsuario(tfEmailEntregador.getText());
                entregador.setEmail(new Email(tfUsuarioEntregador.getText()));
                entregador.setCpf(new Cpf().parser(tfCpfEntregador.getText()));
                entregador.setNumeroDeTelefone(new Telefone().parser(tfTelefoneEntregador.getText()));
                
                model.add(selectedIndex, entregador);
                
                JOptionPane.showMessageDialog(tela, "Usuario alterado!");
            } catch (EmailException e) {
                JOptionPane.showMessageDialog(tela, "O email " + tfEmailEntregador.getText() +" é invalido!");
            } catch (TelefoneException e) {
                JOptionPane.showMessageDialog(tela, "O telefone " + tfTelefoneEntregador.getText() +" é invalido!");
            } catch (CpfException e) {
                JOptionPane.showMessageDialog(tela, "O CPF " + tfCpfEntregador.getText() +" é invalido!");
            }
        }
    }
}

