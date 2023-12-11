package com.mycompany.sistema.ufjf.model;

import java.util.Objects;
import java.util.Random;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class Entrega {
    
    private int identificadorEntrega;
    private Entregador entregador;
    private Cliente cliente;
    private double valorEntrega;
    private String statusEntrega;
    private Pacote pacote;

    public Entrega(Cliente cliente, String statusEntrega, Pacote pacote) {
        this.identificadorEntrega = retornaCodigoIdentificador();
        this.cliente = cliente;
        this.valorEntrega = pacote.retornaValorEntrega();
        this.statusEntrega = statusEntrega;
        this.pacote = pacote;
    }
    
    private int retornaCodigoIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    @Override
    public String toString(){
        
        String nomeEntregador = (entregador != null && entregador.getNome() != null) ? entregador.getNome() : "-";
        
        return "Pedido: " + identificadorEntrega + " ; Entregador: " + nomeEntregador + " ; Cliente: " + cliente.getNome() + " ; Valor: R$" + valorEntrega + " ; Status: " + statusEntrega + " ; Pacote: <" + pacote + ">";
    }
    
    public void cadastraEntregador(Entregador entregador){
        this.entregador = entregador;
    }

    //GETTERS E SETTERS
    public int getIdentificadorEntrega() {
        return identificadorEntrega;
    }

    public void setIdentificadorEntrega(int identificadorEntrega) {
        this.identificadorEntrega = identificadorEntrega;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return this.pacote.getDestino();
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public Pacote getPacotes() {
        return pacote;
    }

    public void setPacotes(Pacote pacotes) {
        this.pacote = pacotes;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Entrega otherEntrega = (Entrega) obj;
        return identificadorEntrega == otherEntrega.identificadorEntrega &&
                Double.compare(otherEntrega.valorEntrega, valorEntrega) == 0 &&
                statusEntrega == otherEntrega.statusEntrega &&
                Objects.equals(entregador, otherEntrega.entregador) &&
                Objects.equals(cliente, otherEntrega.cliente) &&
                Objects.equals(pacote, otherEntrega.pacote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificadorEntrega, entregador, cliente, valorEntrega, statusEntrega, pacote);
    }
}
