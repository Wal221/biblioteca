package pessoas;


import entities.Emprestimos;

import java.io.*;

public class Estudante extends Usuario {
    private int matricula;

    public Estudante(String nome, int idade, String cpf, int matricula, Emprestimos emprestimos) {
        super(nome, idade, cpf, emprestimos);
        this.matricula = matricula;
    }

    public Estudante() {

    }


    @Override
    public String toString() {

        StringBuilder estu = new StringBuilder();
        estu.append("nome: " + getNome() + "\n");
        estu.append("idade: " + getIdade() + "\n");
        estu.append("matricula: " + matricula + "\n");

        return estu.toString();
    }


    @Override
    public void gravar() throws IOException {
        int i = 0;
        String caminho;
        File arquivo = new File("C://Users//Administrador//biblioteca//src//arquivos" +
                "estudante" + getNome() + ".txt");
        try {
            arquivo.createNewFile();
            caminho = arquivo.getPath();
            System.out.print("Arquivo criado com sucesso!");

            FileWriter writer = new FileWriter(caminho, true);
            writer.write("Nome: " + getNome() + "\n" + "Titulo: " + getBooks() + "\n" +
                    "Emprestimo: " + getEmprestimos() + "\n");
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

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
    public void excluir() {

    }

    @Override
    public void ler() {

    }

    @Override
    public void atualizar() {

    }

    public void gravaEmprestismo() {
        try {
            FileWriter writer = new FileWriter("src/arquivos/Emprestimos", true);
            writer.write("Nome: " + getNome() + "\n" + "Titulo do livro: " + getBooks() + "\n" + "Data: "
                    + getEmprestimos());
            writer.close();
            System.out.println("livro cadastrado");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

