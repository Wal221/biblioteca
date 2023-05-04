package pessoas;


import java.io.*;

public class Estudante extends Usuario {
    private int matricula;

    public Estudante(String nome, int idade, String cpf, int matricula, Emprestimos emprestimos) {
        super(nome, idade, cpf, emprestimos);
        this.matricula = matricula;
    }



        @Override
        public String toString () {

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
        File arquivo = new File("C://Users//Administrador//POO2.0//src//Biblio//pessoas//" +
                "estudante" + getNome() + ".txt");


                    if( i > 3) {

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
                    }else{
                        System.out.println("A quantidade de livros pemitida e somente 3");
                    }
                    i = limiteLivros();

        //System.out.println("O limite de livros para estudantes e somente 3");
    }

    @Override
    public int limiteLivros() throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("C://Users//Administrador//POO2.0//src//Biblio//" +
                "pessoas//estudante"+getNome()+".txt"));
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



    public String livrosAssociados(){
        StringBuilder estu = new StringBuilder();
        estu.append("nome: " + getNome() + "\n");
        estu.append("Dia do emprestimo:" + getEmprestimos().getDataDoEmprestimo());

        return estu.toString();
    }

    }

