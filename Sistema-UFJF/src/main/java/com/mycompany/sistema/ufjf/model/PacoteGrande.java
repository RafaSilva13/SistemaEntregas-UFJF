package com.mycompany.sistema.ufjf.model;

import java.util.Random;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class PacoteGrande extends Pacote {
    private int identificadorDoPacote;
    private float peso;
    private String destino;
    private Float altura;
    private Float largura;
    private String origem;
    private float valor;
    private String tipo;

    public PacoteGrande(float peso, String origem, String destino, Float altura, Float largura, String tipo) {
        this.identificadorDoPacote = criaIdentificador();
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.altura = altura;
        this.largura = largura;
        this.tipo = tipo;
    }
    
    //Cria um numero aleatorio de identificador e falta salá-lo no json
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    @Override
    public void calcularCustoPacote() {
        //coloquei o custo como (distancia + peso) * 0.25
        this.valor = (float)(this.buscaDistanciaEndereco() + this.peso) / 4;
    }

    @Override
    public float buscaDistanciaEndereco() {
        //gerando numero aleatório
        float numeroDecimal = (float) (1.0 + (Math.random() * 99.0));
        return numeroDecimal;
    }

    @Override
    public int retonaCodigoIdentificador() {
        return this.identificadorDoPacote;
    }
    
    @Override
    public String getDestino() {
        return destino;
    }
    
    @Override
    public String toString() {
        return "Peso: " + peso + "; \n Destino: " + destino + "; \n Altura: " + altura + "; \n Largura: " + largura + "; \n Origem: " + origem + "; \n Valor: " + valor + "; \n Tipo: " + tipo + ";";
    }
}
