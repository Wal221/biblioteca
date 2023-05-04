package pessoas;


import entities.Emprestimos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Professor extends Usuario {
    private String curso;
    private String tipo;


    public Professor(String nome, int idade, String cpf, String sexo, String email, String curso, String tipo,
                     Emprestimos emprestimos) {
      super(nome, idade, cpf,emprestimos);
        this.curso = curso;
        this.tipo = tipo;
    }


    @Override
    public void excluir() {

    }

    @Override
    public void ler() {

    }

    @Override
    public void atualizar() {

    }

    @Override
    public void gravar() {
        String caminho;
        File arquivo = new File("C://Users//Administrador//POO2.0//src//Biblio//pessoas//professor"+getNome()+".txt");

        try {
            arquivo.createNewFile();
            caminho = arquivo.getPath();
            System.out.print("Arquivo criado com sucesso!");

            FileWriter writer = new FileWriter(caminho,true);
            writer.write(  "Nome: "+getNome()+ "\n" + "Titulo: " +getBooks()+ "\n" );
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
