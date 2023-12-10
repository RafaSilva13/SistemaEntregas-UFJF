package com.mycompany.sistema.ufjf;

import com.mycompany.sistema.ufjf.exeptions.*;
import com.mycompany.sistema.ufjf.view.TelaLogin;
public class SistemaUFJF {

    public static void main(String[] args) throws DataException, CpfException, EmailException, TelefoneException {
//        System.out.println("Hello World!");
       
//        try {
//            VeiculoEntrega veiculo = new VeiculoEntrega("ABDC-1234", 15, "09/12/2023");

//            System.out.println(veiculo);
//        
    //        Cpf cpf = Cpf.parser("112.333112-11");
    //        System.out.println(cpf.toString());

    //        Telefone telefone = Telefone.parser("(32 2222-2222");
    //        System.out.println(telefone.toString());

    //        Email email = new Email("caiogmail.com");
    //        System.out.println(email.toString());

    //        
            //System.out.println(carro.exibirInfos());
//
//
//            Entregador entregador = new Entregador("Junior Marques", Cpf.parser("741.852.963-56"), Telefone.parser("(32)94444-5555"), new Email("junin@gmail.com"), "junin", "123", veiculo, veiculo);
//
//            System.out.println(entregador);
//            System.out.println(entregador.retornaVeiculo());
//
//            Cliente cliente = new Cliente("Rafael Pereira", Cpf.parser("123.456.789-10"), Telefone.parser("(32)99999-9999"), new Email("rafa@gmail.com"), "rafa", "123");
//            float peso = 5;
//            float largura = 5;
//            float altura = 10;
//    //        
//            Pacote pacote = new PacotePequeno(peso, "Rua B", "Rua A", altura, largura, "Pacote Pequeno", true);
//            Pacote pacote2 = new PacoteGrande(peso, "Rua B", "Rua A", altura, largura, "Pacote Grande");
//            
//            Entrega entrega = new Entrega(entregador, cliente, false, pacote);
//    //        
//    //        entrega.exibeInformacoesEntrega();
//
//            TelaCliente tela = new TelaCliente();
//            tela.exibirTelaClientes(cliente);
//
            TelaLogin tela = new TelaLogin();
            tela.exibirTelaLogin();
//        } catch (EmailException e) {
//            JOptionPane.showMessageDialog(null, "O email é invalido!");
//        } catch (TelefoneException e) {
//            JOptionPane.showMessageDialog(null, "O telefone é invalido!");
//        } catch (CpfException e) {
//            JOptionPane.showMessageDialog(null, "O CPF é invalido!");
//        }catch (DataException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        } catch (VeiculoEntregaException e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
    }
}
