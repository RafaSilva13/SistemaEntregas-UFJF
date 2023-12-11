package com.mycompany.sistema.ufjf.model;

import com.mycompany.sistema.ufjf.exeptions.TelefoneException;
import java.util.Objects;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class Telefone {
    private int ddd;
    private String numero;

    public Telefone(int ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }
    
    public Telefone(){}

    // Método estático parser para criar um objeto Telefone a partir de uma String
    public static Telefone parser(String telefone) throws TelefoneException {
        // Remover caracteres não numéricos da string do telefone
        String numeros1 = telefone.replaceAll("\\(", "");
        String numeros2 = numeros1.replaceAll("\\)", "");
        String numeros3 = numeros2.replaceAll("-", "");
        String numeros = numeros3.replaceAll(" ", "");
        

        // Extrair o DDD e o número da string
        String ddd = numeros.substring(0, 2);
        String numero = numeros.substring(2);

        // Verificar se o DDD e o número têm o formato correto
        if (ddd.length() == 2 && (numero.length() == 8 || numero.length() == 9)) {
            // Retornar um novo objeto Telefone
            int dd = Integer.parseInt(ddd);
            return new Telefone(dd, numero);
        } else {
            // Caso contrário, lançar uma exceção ou lidar com o erro de outra forma
            throw new TelefoneException("Formato de telefone inválido: ");
            //e.getMe
        }
    }
    
    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
     public static String formatarNumero(String numero) {
        StringBuilder reversed = new StringBuilder(numero).reverse();
        StringBuilder formatted = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {
            formatted.append(reversed.charAt(i));
            if (i == 3) {
                formatted.append('-');
            }
        }

        return formatted.reverse().toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Telefone otherTelefone = (Telefone) obj;
        return ddd == otherTelefone.ddd && Objects.equals(numero, otherTelefone.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, numero);
    }

    @Override
    public String toString() {
        return "(" + ddd + ")" + formatarNumero(numero);
    }
}
