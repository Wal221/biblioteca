package teste;

import entities.Books;
import entities.Emprestimos;
import pessoas.Estudante;
import pessoas.Funcionario;

import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner inpu = new Scanner(System.in);
        Emprestimos emprestimos = new Emprestimos();

        Estudante estudante = new Estudante("Walmir", 14, "708", 2021, emprestimos );
        Books livros = new Books("Livro1");
        estudante.addBook(livros);

        emprestimos.setUsuario(estudante);
        emprestimos.gravar();
      emprestimos.ler();







    }
}