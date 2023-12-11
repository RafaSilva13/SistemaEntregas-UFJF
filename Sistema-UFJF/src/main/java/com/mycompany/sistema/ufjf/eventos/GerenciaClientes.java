package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Cliente;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import com.mycompany.sistema.ufjf.persistence.ClientePersistence;
import com.mycompany.sistema.ufjf.persistence.Persistence;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class GerenciaClientes implements WindowListener {

    private final TelaLogin tela;

    public GerenciaClientes(TelaLogin tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Cliente> clientePersistence = new ClientePersistence();
        List<Cliente> all = clientePersistence.findAll();
        tela.carregaClientes(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Cliente> clientePersistence = new ClientePersistence();
        clientePersistence.save(tela.listaClientes());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
