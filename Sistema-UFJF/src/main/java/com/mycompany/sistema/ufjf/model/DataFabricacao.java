package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.DataException;
import java.time.LocalDate;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class DataFabricacao {
    private String data;
    private int dia;
    private int mes;
    private int ano;

    private DataFabricacao(String data, int dia, int mes, int ano) {
        this.data = data;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return data;
    }

    public static DataFabricacao parser(String data) throws DataException {
        if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            // Verifica se os valores são válidos (por exemplo, dia <= 31, mês <= 12)
            String[] partes = data.split("/");
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            
            LocalDate dataAtual = LocalDate.now();
            int diaAtual = dataAtual.getDayOfMonth();
            int mesAtual = dataAtual.getMonthValue();
            int anoAtual = dataAtual.getYear();
            
            if ((dia >= 1 && dia <= 31) && (mes >= 1 && mes <= 12) && (ano <= anoAtual && mes <= mesAtual && ano <= anoAtual)) {
                return new DataFabricacao (data , dia, mes, ano);
            } else {
                throw new DataException ();
            }
        }
        
        throw new DataException();
       
    }
        
}
