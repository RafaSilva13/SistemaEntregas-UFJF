package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Entregador;
import com.mycompany.sistema.ufjf.view.TelaLogin;
import com.mycompany.sistema.ufjf.persistence.EntregadorPersistence;
import com.mycompany.sistema.ufjf.persistence.Persistence;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class GerenciaEntregadores implements WindowListener {

    private final TelaLogin tela;

    public GerenciaEntregadores(TelaLogin tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Entregador> entregadorPersistence = new EntregadorPersistence();
        List<Entregador> all = entregadorPersistence.findAll();
        tela.carregaEntregadores(all);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Entregador> entregadorPersistence = new EntregadorPersistence();
        entregadorPersistence.save(tela.listaEntregadores());
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
