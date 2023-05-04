package pessoas;

import entities.Emprestimos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Funcionario extends Usuario {
   private String sexo;
   private String email;




   public Funcionario(String nome , int idade, String cpf, Emprestimos emprestimos){
       super(nome,idade,cpf,emprestimos);

   }
    public Funcionario(String nome, int idade, String cpf, String sexo, String email, Emprestimos emprestimos) {
        super(nome, idade, cpf,emprestimos);
        this.sexo = sexo;
        this.email = email;
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
        File arquivo = new File("C://Users//Administrador//POO2.0//src//Biblio//pessoas//funcionario"+getNome()+".txt");

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
