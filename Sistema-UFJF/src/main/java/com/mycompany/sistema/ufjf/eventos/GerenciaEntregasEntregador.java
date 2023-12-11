package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Entrega;
import com.mycompany.sistema.ufjf.view.TelaEntregador;
import com.mycompany.sistema.ufjf.persistence.EntregaPersistence;
import com.mycompany.sistema.ufjf.persistence.Persistence;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class GerenciaEntregasEntregador implements WindowListener {

    private final TelaEntregador tela;

    public GerenciaEntregasEntregador(TelaEntregador tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Entrega> entregadorPersistence = new EntregaPersistence();
        List<Entrega> all = entregadorPersistence.findAll();
        tela.carregaEntregas(all);
        tela.exibirPedidosEntregador();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Entrega> entregadorPersistence = new EntregaPersistence();
        entregadorPersistence.save(tela.listaEntregas());
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
