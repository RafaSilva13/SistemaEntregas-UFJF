package com.mycompany.sistema.ufjf.model;

import java.util.Random;

public class PacotePequeno extends Pacote{
    
    private int identificadorDoPacote;
    private float peso;
    private String destino;
    private Float altura;
    private Float largura;
    private String origem;
    private float valor;
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
    }
    
    //Cria um numero aleatorio de identificador e falta salá-lo no json
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    @Override
    public void calcularCustoPacote() {
            //coloquei o custo como (distancia + peso) * 0.2
        this.valor = (float)(this.buscaDistanciaEndereco() + this.peso) / 5;
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
        return "Tipo: " + tipo + "; Peso: " + peso + ";  Origem: " + origem + ";  Destino: " + destino + ";  Altura: " + altura + ";  Largura: " + largura + "; Valor: " + valor + "; Fragil: " + fragil + ";";
    }
    
    public void adicionarRestricaoVeiculo (boolean opcao) { 
        this.fragil = opcao;
    } 
}
