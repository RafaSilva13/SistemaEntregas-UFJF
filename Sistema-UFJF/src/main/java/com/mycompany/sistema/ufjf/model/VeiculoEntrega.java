/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.*;

/**
 *
 * @author sihuanb
 */
public class VeiculoEntrega {
    private int identificador;
    private String placa;
    private String modelo;
    private float capacidadeCarga;
    private Data anoDeFabricacao;

    public VeiculoEntrega(String placa, String modelo, float capacidadeCarga, String DataDeFabricacao) throws DataExeption, VeiculoEntregaException {
        
        if (!validaInformacaoes(capacidadeCarga)) {
            throw new VeiculoEntregaException();
        }
        
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeCarga = capacidadeCarga;
        this.anoDeFabricacao = Data.parser(DataDeFabricacao);
    }

    public int retornaCodigoIdentificador() {
        return identificador;
    }
    
    //valores de kg inventados, retorna true se os valores de capacidade de carga estiverem entre esses valores
    public boolean validaInformacaoes(float capacidade) {
        return capacidade >= 100 || capacidade <= 500;
    }

   
    public String exibirInfos() {
        return "VeiculoEntrega{" + "identificador=" + identificador + ", placa=" + placa + ", modelo=" + modelo + ", capacidadeCarga=" + capacidadeCarga + ", anoDeFabricacao=" + anoDeFabricacao + '}';
    }
    
    
}
