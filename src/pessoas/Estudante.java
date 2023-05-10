package pessoas;


import entities.Books;
import entities.Emprestimos;

import java.io.*;

public class Estudante extends Usuario implements Serializable {
    private int matricula;

    public Estudante(String nome, int idade, String cpf, int matricula, Emprestimos emprestimos) {
        super(nome, idade, cpf, emprestimos);
        this.matricula = matricula;
    }

    public Estudante() {

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {

        StringBuilder estu = new StringBuilder();
        estu.append("nome: " + getNome() + "\n");
        estu.append("idade: " + getIdade() + "\n");
        estu.append("matricula: " + matricula + "\n");
        estu.append("Titulo Livro: "+ getBooks());

        return estu.toString();
    }



    /**
     * @return Esse metodo vou usa primeiramente com duas intenções ,
     * 1 de percorrer a lista da biblioteca e pegar o livro desejado pelo nome
     * 2 com esse metodo posso contar a quantidade de linhas necessarias e vincula com a quantidade de livro que
     * um usuario pode emprestimar
     */
    @Override
    public int numberLivros(String caminnho) throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(caminnho));
        lnr.skip(Long.MAX_VALUE);
        int retorno = lnr.getLineNumber();

        return retorno;

    }
    @Override
    public void gravar() throws IOException {
        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("src/arquivos/"+getNome()+".txt"));
        objectOutput.writeObject("Nome: "+getNome() + "Livro: "+ getBooks());
        System.out.println("Livro gravado");
        objectOutput.close();

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


}

