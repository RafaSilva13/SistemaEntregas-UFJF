/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.CpfExeption;
import com.mycompany.sistema.ufjf.exeptions.EmailException;
import com.mycompany.sistema.ufjf.exeptions.TelefoneException;
import java.util.Random;



/**
 *
 * @author josemiguel
 */
public class Cliente extends Usuario {
    
    private String nome;
    private int identificadorCliente;
    private Cpf cpf;
    private int quantidadeDePedidos;
    private Telefone numeroDeTelefone;
    private Email email;

    public Cliente(String nome, String cpf, String numeroDeTelefone, String email, String usuario, String senha) throws CpfExeption, TelefoneException, EmailException{
        super(usuario, senha);
        this.nome = nome;
        this.identificadorCliente = criaIdentificador();
        this.quantidadeDePedidos = 0;
        
        Cpf cpfAux = new Cpf();
        this.cpf = cpfAux.parser(cpf);
        
        Telefone telefoneAux = new Telefone();
        this.numeroDeTelefone = telefoneAux.parser(numeroDeTelefone);
            
        this.email = new Email(email);
        
    }
     

    //Acredito que verifica se os dados esão no json e se sim, faz login, se não, não faz
    @Override
    public boolean fazLogin(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public int retornaCodigoIdentificador(){
        return this.identificadorCliente;
    }
   
    public void verPedidos(){
        System.out.println("Número de pedidos do cliente " + this.nome + " é : " + this.quantidadeDePedidos);
    }

    //Cria um numero aleatorio de identificador e falta salá-lo no json
    public int criaIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    

    
}
