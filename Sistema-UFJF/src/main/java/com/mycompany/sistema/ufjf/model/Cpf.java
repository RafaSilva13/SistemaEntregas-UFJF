/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.CpfException;
import java.util.Objects;
/**
 *
 * @author sihuanb
 */
public class Cpf {
    private String cPFString;
    private String cPFSemPontos;

    public Cpf(String cPFString, String cPFSemPontos) {
        this.cPFString = cPFString;
        this.cPFSemPontos = cPFSemPontos;
    }
    
    public Cpf(){}
    
    public static Cpf parser(String cpf1) throws CpfException {
        
        String cpf = cpf1.replaceAll("[^0-9]", "");
        
        // Verifica se o CPF tem 11 dígitos e Verifica se todos os caracteres são numéricos
        if (11 == cpf.length()) {
            return new Cpf(cpf1, cpf);
        } else {
            throw new CpfException("Cpf não válido!");
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cpf otherCpf = (Cpf) obj;
        return Objects.equals(cPFSemPontos, otherCpf.cPFSemPontos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cPFSemPontos);
    }

    @Override
    public String toString() {
        return cPFString;
    }
}
