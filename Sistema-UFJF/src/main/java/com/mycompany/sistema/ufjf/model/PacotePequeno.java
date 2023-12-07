/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

/**
 *
 * @author sihuanb
 */
public class PacotePequeno implements Pacote{
    
    private int identificadorDoPacote;
    private float peso;
    private String destino;
    private String altura;
    private String largura;
    private String endereco;
    private float valor;
    private String tipo;
    private boolean fragil;

    public PacotePequeno(int identificadorDoPacote, float peso, String destino, String altura, String largura, String endereco, String tipo) {
        this.identificadorDoPacote = identificadorDoPacote;
        this.peso = peso;
        this.destino = destino;
        this.altura = altura;
        this.largura = largura;
        this.endereco = endereco;
        this.tipo = tipo;
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
    
    public void adicionarRestricaoVeiculo (boolean opcao) { 
       
        this.fragil = opcao;
        
    } 
}
