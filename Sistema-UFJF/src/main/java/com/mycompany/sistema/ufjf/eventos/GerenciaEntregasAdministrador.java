package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.model.Entrega;
import com.mycompany.sistema.ufjf.persistence.EntregaPersistence;
import com.mycompany.sistema.ufjf.view.TelaAdministrador;
import com.mycompany.sistema.ufjf.persistence.Persistence;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class GerenciaEntregasAdministrador implements WindowListener {

    private final TelaAdministrador tela;

    public GerenciaEntregasAdministrador(TelaAdministrador tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Entrega> entregadorPersistence = new EntregaPersistence();
        List<Entrega> all = entregadorPersistence.findAll();
        tela.carregaEntregas(all);
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
