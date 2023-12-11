package com.mycompany.sistema.ufjf.eventos;

import com.mycompany.sistema.ufjf.view.TelaEntregador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class salvarAlteracoesEntregador implements ActionListener {
    
    private final TelaEntregador tela;

    public salvarAlteracoesEntregador(TelaEntregador tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.salvarAlteracoes();
    }
}
