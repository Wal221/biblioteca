package teste;

import entities.Books;
import entities.Emprestimos;
import pessoas.Estudante;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner inpu = new Scanner(System.in);
        Emprestimos emprestimos = new Emprestimos();
        Estudante estudante = new Estudante("Walmir", 14, "708", 2022, emprestimos );
        Books livros = new Books();


        for(int i = 0; i < 1; i++ ){
            System.out.print("titulos dos livros deseja cadastrar: ");
            String titulo = inpu.nextLine();
            livros = new Books(titulo);
             livros.gravar();

        }

        System.out.println("Livros disponiveis");
           livros.ler();

        System.out.println("Digite o nome do livro que deseja pegar");
          String nomeLivro = inpu.nextLine();

          estudante.pegaLivros(nomeLivro);






    }
}