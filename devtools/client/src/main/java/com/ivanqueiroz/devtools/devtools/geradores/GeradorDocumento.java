package com.ivanqueiroz.devtools.devtools.geradores;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ivan Queiroz <ivanqueiroz@gmail.com>
 */
public class GeradorDocumento {

    private static final Integer[] PESOS_DIGITO_UM = {10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final Integer[] PESOS_DIGITO_DOIS = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public static Integer[] gerarNumerosIniciaisCPF(Integer uf) {
        Random random = new Random();
        Integer[] resultado = new Integer[9];
        for (int i = 0; i < 9; i++) {
            resultado[i] = random.nextInt(10);
        }
        if(uf !=null){
            resultado[8]=uf;
        }
        return resultado;
    }

    public static Integer calculaDigitoVerificador(Integer[] digitos, Integer[] peso) {
        int aux = 0;
        for (int i = 0; i < digitos.length; i++) {
            aux = aux + (peso[i] * digitos[i]);
        }
        int resto = aux % 11;
        if (resto >= 2) {
            return 11 - resto;
        } else {
            return 0;
        }
    }
    
    public static String gerar(Integer uf){
        Integer[] numeros = gerarNumerosIniciaisCPF(uf);
        Integer primeiroDigito = calculaDigitoVerificador(numeros, PESOS_DIGITO_UM);
        numeros = Arrays.copyOf(numeros, 10);
        numeros[9] = primeiroDigito;
        Integer segundoDigito = calculaDigitoVerificador(numeros, PESOS_DIGITO_DOIS);
        numeros = Arrays.copyOf(numeros, 11);
        numeros[10] = segundoDigito;
        StringBuilder cpf = new StringBuilder();
        for (int numero : numeros) {
            cpf.append(numero);
        }
        return cpf.toString();
    }
    
    public static String gerar(){
        return gerar(null);
    }

    public static void main(String[] args) {
        System.out.println(GeradorDocumento.gerar(5));
    }
}
