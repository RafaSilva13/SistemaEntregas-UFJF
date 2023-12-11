package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.*;
import java.util.Random;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class VeiculoEntrega implements MeioDeTransporte {
    private int identificador;
    private String placaModelo;
    private float capacidadeCarga;
    private DataFabricacao anoDeFabricacao;

    public VeiculoEntrega(String placaModelo, float capacidadeCarga, String DataDeFabricacao) throws DataException, VeiculoEntregaException {

        if (validaCapacidadeCarga(capacidadeCarga)) {
            throw new VeiculoEntregaException();
        }
        
        this.identificador = criaIdentificador();
        this.placaModelo = placaModelo;
        this.capacidadeCarga = capacidadeCarga;
        this.anoDeFabricacao = DataFabricacao.parser(DataDeFabricacao);
    }

    //retorna identifacor aleatorio (mas ainda não esta armazenando os que ja foram criados - usar a persistencia)
    public int criaIdentificador() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    public int retornaCodigoIdentificador() {
        return identificador;
    }
    
    // Valores de kg inventados, retorna true se os valores de capacidade de carga estiverem entre esses valores
    public boolean validaCapacidadeCarga(float capacidade) {
        return (capacidade <= Float.parseFloat("10"));
    }
    
    public String getPlacaModelo() {
        return placaModelo;
    }

    public String getCapacidadeCarga() {
        return Float.toString(capacidadeCarga);
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao.toString();
    }

    @Override
    public String entregar() {
       return "Entregando usando o veiculo " + this.toString();
    }
   
    @Override
    public String toString() {
        return placaModelo + "        " + capacidadeCarga + "     " + anoDeFabricacao;
    }
}