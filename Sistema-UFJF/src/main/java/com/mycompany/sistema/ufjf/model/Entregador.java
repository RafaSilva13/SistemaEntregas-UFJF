package com.mycompany.sistema.ufjf.model;

import java.util.Objects;
import java.util.Random;
import com.mycompany.sistema.ufjf.model.MeioDeTransporte;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class Entregador extends Usuario implements MeioDeTransporte {
    
    private int identificadorEntregador;
    private String nome;
    private Cpf cpf;
    private Email email;
    private Telefone numeroDeTelefone;
    private VeiculoEntrega veiculo;
    
    public Entregador() {
    }

    public Entregador(String nome, Cpf cpf, Telefone numeroDeTelefone, Email email, String usuario, String senha, VeiculoEntrega veiculo) {
        super(usuario, senha);
        this.nome = nome;
        this.identificadorEntregador = criaIdentificador();
        this.cpf = cpf;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
        this.veiculo = veiculo;
    }

    //retorna identifacor aleatorio (mas ainda não esta armazenando os que ja foram criados - usar a persistencia)
    public int criaIdentificador() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    // Getters
    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public Email getEmail() {
        return email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Telefone getNumeroDeTelefone() {
        return numeroDeTelefone;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public VeiculoEntrega retornaVeiculo () {
        return veiculo;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setNumeroDeTelefone(Telefone numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
     
    public int retornaCodigoIdentificador() {
        return identificadorEntregador;
    }
    
    @Override
    public boolean fazLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }
    
    public String realizarEntrega() {
        return "Usando veiculo de transporte: " + this.retornaVeiculo();
    }
    
    @Override
    public String entregar() {
        return realizarEntrega();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "; Usuário: " + usuario + "; CPF: " + cpf.toString() + "; Telefone: " + numeroDeTelefone.toString() + "; Email: " + email + "; " +  entregar();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entregador entregador = (Entregador)obj;
        
        return Objects.equals(cpf, entregador.cpf) || Objects.equals(usuario, entregador.usuario);    
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, numeroDeTelefone, email, usuario);
    }
}
