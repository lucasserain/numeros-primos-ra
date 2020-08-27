package br.com.serain.PrimoAlg.service.Algoritmos;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CheckPrimo {
    private BigDecimal timeAlg1 = new BigDecimal(0);
    private BigDecimal timeAlg2 = new BigDecimal(0);
    private BigDecimal timeAlg3 = new BigDecimal(0);
    private BigDecimal timeAlg4 = new BigDecimal(0);

    public Integer Alg1(Integer n){
        long tempoInicial =  System.nanoTime();

        int EhPrimo = 1, //em princípio, n é primo
                d=2;
        if (n <= 1)
            EhPrimo = 0;

        while (EhPrimo == 1 && d <= n / 2) {
            if (n % d  == 0)
                EhPrimo = 0;
            d = d + 1;
        }

        long endTime = System.nanoTime();

        timeAlg1 = new BigDecimal((endTime - tempoInicial) + timeAlg1.longValueExact() );
        return EhPrimo;

    }

    public Integer Alg2(Integer n){
        long tempoInicial = System.nanoTime();
        int EhPrimo = 1, //em princípio, n é primo
                d=2,
                resto;
        if (n <= 1)
            EhPrimo = 0;

        while (EhPrimo == 1 && d <= n / 2) {
            resto = n % d;
            if (resto == 0)
                EhPrimo = 0;
            d = d + 1;
        }
        long endTime = System.nanoTime();
        timeAlg2 = new BigDecimal((endTime - tempoInicial) + timeAlg2.longValueExact());
        return EhPrimo;
    }

    public Integer Alg3(Integer n){
        long tempoInicial = System.nanoTime();
        int EhPrimo;
        int d=3;
        if (n <= 1 || (n != 2 && n % 2 == 0))
            EhPrimo = 0;    //* nenhum numero inteiro <= 1 ou par > 2 e' primo *//*
        else
            EhPrimo = 1;        //* o numero e' primo ate que se prove o contrario *//*

        while (EhPrimo==1  && d <= n/2) {
            if (n % d == 0)
                EhPrimo = 0;
            d = d + 2;        //* testar apenas ímpares*//*
        }

        long endTime = System.nanoTime();
        timeAlg3 = new BigDecimal((endTime - tempoInicial) + timeAlg3.longValueExact());

        return EhPrimo;
    }

    public Integer Alg4(Integer n){
        long tempoInicial = System.nanoTime();
        int EhPrimo, //em princípio, n é primo
                d=3;
        if (n <= 1 || (n != 2 && n % 6 == 1 && n % 6 == 5))
            EhPrimo = 0;    //* nenhum numero inteiro <= 1 ou ~ adjacente a 6 eh primo *//*
        else
            EhPrimo = 1;
        while (EhPrimo==1  && d <= n / 2) {
            if (n % d == 0)
                EhPrimo = 0;
            d = d + 2;
        }
        long endTime = System.nanoTime();
        timeAlg4 = new BigDecimal((endTime - tempoInicial) + timeAlg4.longValueExact());
        return EhPrimo;
    }

    public void Orquestrador(List<Integer> numeros){
        BigDecimal media1;
        BigDecimal media2;
        BigDecimal media3;
        BigDecimal media4;

        System.out.println("Algoritmo 1");
        for (Integer item:numeros) {
            for(int i=0; i<30; i++){
                Alg1(item);
            }
            media1 = BigDecimal.valueOf(timeAlg1.longValueExact() / numeros.size());
            System.out.println("Tempo Medio do numero:" + item + " --- " + media1.setScale(6) + "ns");
        }

        System.out.println("Algoritmo 2");
        for (Integer item:numeros) {
            for(int i=0; i<30; i++){
                Alg2(item);
            }
            media2 = BigDecimal.valueOf(timeAlg2.longValueExact() / numeros.size());

            System.out.println("Tempo Medio do numero:" + item + "  " + media2.setScale(5) + "ns");
        }

        System.out.println("Algoritmo 3");
        for (Integer item:numeros) {
            for(int i=0; i<30; i++){
                Alg3(item);
            }
            media3 = BigDecimal.valueOf(timeAlg3.longValueExact() / numeros.size());

            System.out.println("Tempo Medio do numero:" + item + "  " + media3.setScale(5) + "ns");
        }

        System.out.println("Algoritmo 4");
        for (Integer item:numeros) {
            for(int i=0; i<30; i++){
                Alg4(item);
            }
            media4 = BigDecimal.valueOf(timeAlg4.longValueExact() / numeros.size());

            System.out.println("Tempo Medio do numero:" + item + "  " + media4.setScale(5) + "ns");
        }


    }
}
