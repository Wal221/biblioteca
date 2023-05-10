package pessoas;


import entities.Emprestimos;

import java.io.*;

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
    public void ler() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream( "src/arquivos/"+getNome()+".txt"));
        Usuario usuario1 = (Usuario) objectInput.readObject();
        objectInput.close();
        System.out.println(usuario1);


    }

    @Override
    public void atualizar() {

    }

    @Override
    public void gravar() throws IOException {
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("src/arquivos/"+getNome()+".txt"));
        objectOutput.writeObject("Nome: "+getNome() + "Livro: "+ getBooks());
        System.out.println("Livro gravado");
        objectOutput.close();

    }
}
