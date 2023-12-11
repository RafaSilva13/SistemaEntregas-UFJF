package com.mycompany.sistema.ufjf.model;

import java.util.Random;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class PacotePequeno extends Pacote{
    
    private int identificadorDoPacote;
    private float peso;
    private String destino;
    private Float altura;
    private Float largura;
    private String origem;
    private double valor;
    private String tipo;
    private boolean fragil;

    public PacotePequeno(float peso, String origem, String destino, Float altura, Float largura, String tipo, boolean opcaoFragil) {
        this.identificadorDoPacote = criaIdentificador();
        this.peso = peso;
        this.origem = origem;
        this.destino = destino;
        this.altura = altura;
        this.largura = largura;
        this.tipo = tipo;
        this.adicionarRestricaoVeiculo(opcaoFragil);
        this.valor = calcularCustoPacote();
    }
    
    //Cria um numero aleatorio de identificador e falta salá-lo no json
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    @Override
    public double retornaValorEntrega() {
        return valor;
    }
    
    @Override
    public double calcularCustoPacote() {
        float distanciaKm = buscaDistanciaEndereco();
        double valorFinal = distanciaKm * 0.25;
        
        return valorFinal;
    }

    @Override
    public float buscaDistanciaEndereco() {
        Random random = new Random();
	int kmAleatorio = random.nextInt(401) + 100;
	return kmAleatorio;
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
        return "Tipo: " + tipo + "; Peso: " + peso + ";  Origem: " + origem + ";  Destino: " + destino + ";  Altura: " + altura + ";  Largura: " + largura + "; Valor: " + valor + "; Fragil: " + fragil + ";";
    }
    
    public void adicionarRestricaoVeiculo (boolean opcao) { 
        this.fragil = opcao;
    } 
}
