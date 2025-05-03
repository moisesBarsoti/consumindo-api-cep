package main;

import bean.ConsultaEndereco;
import bean.Endereco;
import bean.GeradorDeArquivos;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsultaEndereco endereco = new ConsultaEndereco();

        System.out.println("Digite um número de cep");
        String cep = scan.nextLine();

        try {
            Endereco novoEndereco = endereco.buscaEndereco(cep);
            System.out.println(endereco);
            GeradorDeArquivos gerador = new GeradorDeArquivos();
            gerador.salvaJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando a aplicação");
        }

        System.out.println(endereco);
    }
}
