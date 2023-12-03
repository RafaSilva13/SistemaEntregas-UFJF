/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.DataExeption;
/**
 *
 * @author sihuanb
 */
public class Data {
    private String data;
    private int dia;
    private int mes;
    private int ano;

    private Data(String data, int dia, int mes, int ano) {
        this.data = data;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }


    @Override
    public String toString() {
        return "Data{" + "data=" + data + ", dia=" + dia + ", mes=" + mes + ", ano=" + ano + '}';
    }

    
    
    
    public static Data parser(String data) throws DataExeption {
        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            // Verifica se os valores são válidos (por exemplo, dia <= 31, mês <= 12)
            String[] partes = data.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            if ((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12)) {
                return new Data (data , dia, mes, ano);
            } else {
                throw new DataExeption ("Data no formato errado.");
            }
        }
        return null;
       
    }
        
}
