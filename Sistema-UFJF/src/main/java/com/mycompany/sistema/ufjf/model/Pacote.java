package com.mycompany.sistema.ufjf.model;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public abstract class Pacote {
    public abstract double calcularCustoPacote();
    public abstract float buscaDistanciaEndereco();
    public abstract int retonaCodigoIdentificador();
    public abstract double retornaValorEntrega();
    public abstract String getDestino();
}
