package com.mycompany.sistema.ufjf.persistence;

import java.util.List;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public interface Persistence<T> {

    String DIRECTORY = "data";
    public void save(List<T> itens);
    public List<T> findAll();

}

