package pessoas;
import entities.Emprestimos;
import repository.Dao;
import entities.Books;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public abstract class Usuario extends Pessoa implements Dao {


    private int telefone;

    private Emprestimos emprestimos;
    private int cont;
    private List<Books> books = new ArrayList<>();

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Usuario() {

    }

    public Usuario(String name, int idade, int telefone, String cpf, Emprestimos emprestimos) {
        super(name, idade, cpf);
        this.telefone = telefone;
        this.emprestimos = emprestimos;

    }


    public Usuario(String name, int idade, String cpf, Emprestimos emprestimos) {
        super(name, idade, cpf);
        this.emprestimos = emprestimos;

    }


    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Emprestimos getEmprestimos() {
        return emprestimos;
    }


    public List<Books> getBooks() {
        return books;
    }

    public void addBook(Books livros) throws IOException {
        books.add(livros);
    }

    public void removeBook(Books livros) {
        books.remove(livros);
    }


    public void lerLivro() {
        System.out.println(" USUARIO ESTA LENDO O LIVRO");
    }


    public int numberLivros(String caminho) throws IOException, IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader(caminho));
        lnr.skip(Long.MAX_VALUE);
        int retorno = lnr.getLineNumber();
        return retorno;

    }


    @Override
    public String toString() {
        return "Usuario" +
                ", telefone=" + telefone +
                ", emprestimos=" + emprestimos
                ;
    }

    @Override
    public void gravar() throws IOException {

        String caminho;
        File arquivo = new File("C://Users//Administrador//biblioteca//src//arquivos//usuario"+getNome()+".txt");

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

    public void pegaLivros(String nomeLivro) throws IOException {
        int a = numberLivros("src/arquivos/biblioteca");

        for (int i = 0; i < a; i++) {
            Books aux = new Books();
            aux.setTitulo((Files.readAllLines(Paths.get("src/arquivos/biblioteca")).get(i)));

            if (aux.getTitulo().equalsIgnoreCase(nomeLivro)) {
                System.out.println("o nome digitado a no arquivo ");
                addBook(aux);
                //gravo o livro pegado pelo aluno em sua lista
                gravar();
                //e gravo na lista de emprestimos tambem
                gravaEmprestismo();

            }

        }
    }
    /**
     * @return Esse metodo faz com que a cada livro que o usuario pega , esse livro vai para uma lista de
     * emprestimo mostrando o nome do usuario , data e o titulo do livro emprestado
     */
    public void livrosEmprestimos(){
        try {
            FileWriter writer = new FileWriter("src/arquivos/Emprestimo",true);
            writer.write(getNome() + "\n" + getBooks() + getEmprestimos());
            writer.close();
            System.out.println("Dados gravados");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public void gravaEmprestismo() {



    }
}