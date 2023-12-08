package com.mycompany.sistema.ufjf.model;

import java.util.List;
import java.util.Random;

public class Entrega {
    
    private int identificadorEntrega;
    private Entregador entregador;
    private Cliente cliente;
    private double valorEntrega;
    private String endereco;
    private boolean statusEntrega;
    private List<Pacote> pacotes;

    public Entrega(Entregador entregador, Cliente cliente, String endereco, boolean statusEntrega, List<Pacote> pacotes) {
        this.identificadorEntrega = retornaCodigoIdentificador();
        this.entregador = entregador;
        this.cliente = cliente;
        this.valorEntrega = retornaValorEntrega();
        this.endereco = endereco;
        this.statusEntrega = statusEntrega;
        this.pacotes = pacotes;
    }
    
    private double retornaValorEntrega(){
        int distanciaKm = verificaEndereco();
        double valorFinal = distanciaKm * 0.25; //Ex: se distancia == 200 Km, valor = 50,00
        return valorFinal;
    }
    
    private int verificaEndereco(){ //retorna uma kilometragem de distancia até o endereço
        Random random = new Random();
        int kmAleatorio = random.nextInt(1901) + 100;
        return kmAleatorio;
    }
    
    private int retornaCodigoIdentificador(){
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }
    
    public void exibeInformacoesEntrega(){
        System.out.println("Identificador da entrega : " + this.identificadorEntrega);
        System.out.println(this.entregador); //Ja sobscrevi o toString().
        System.out.println(this.cliente);
        System.out.println("Valor da entrega : R$ " + this.valorEntrega);
        System.out.println("Endereço de entrega: " + this.endereco);
        System.out.println("Pedido ja foi entregue? : " + this.statusEntrega);
    }
    
    //NÃO ENTENDI O QUE ACONTECE AQUI, É ISSO?:
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
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(boolean statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public List<Pacote> getPacotes() {
        return pacotes;
    }

    public void setPacotes(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

    public double getValorEntrega() {
        return valorEntrega;
    }
    
    
}
