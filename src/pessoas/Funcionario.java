package pessoas;

import entities.Emprestimos;

import java.io.*;

public class Funcionario extends Usuario implements Serializable {
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

    @Override
    public String toString() {

        StringBuilder estu = new StringBuilder();
        estu.append("nome: " + getNome() + "\n");
        estu.append("idade: " + getIdade() + "\n");
        estu.append("cpf: " +getCpf()+ "\n");
        estu.append("Titulo Livro: "+ getBooks() + "\n");

        return estu.toString();
    }
}
