/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.CpfException;
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

    @Override
    public String toString() {
        return "Cpf{" + "cPFString=" + cPFString + ", cPFSemPontos=" + cPFSemPontos + '}';
    }
    
    public static Cpf parser(String cpf1) throws CpfException {
        
        String cpf = cpf1.replaceAll("[^0-9]", "");
        
        // Verifica se o CPF tem 11 dígitos e Verifica se todos os caracteres são numéricos
        if (11 == cpf.length()) {
            return new Cpf(cpf1, cpf);
        } else {
            throw new CpfException("Cpf não válido!");
        }
    }
}
