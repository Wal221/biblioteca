package pessoas;
import entities.Emprestimos;
import repository.Dao;
import entities.Books;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class Usuario extends Pessoa implements Dao {


    private int telefone;

    private Emprestimos emprestimos ;
    private int cont;
    private List<Books> books = new ArrayList<>();

    public void setBooks(List<Books> books) {
        this.books = books;
    }

    public Usuario(){

    }
    public Usuario(String name, int idade, int telefone, String cpf, Emprestimos emprestimos) {
        super(name,idade,cpf);
        this.telefone = telefone;
        this.emprestimos = emprestimos;

    }



    public Usuario(String name, int idade, String cpf, Emprestimos emprestimos ){
        super(name, idade, cpf);
        this.emprestimos =emprestimos;

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
    public void addBook(Books livros){
        books.add(livros);
    }
    public void removeBook(Books livros){
        books.remove(livros);
    }



    public void lerLivro(){
        System.out.println(" USUARIO ESTA LENDO O LIVRO");
    }


        public int limiteLivros() throws IOException, IOException {
            LineNumberReader lnr = new LineNumberReader(new FileReader(""));
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
        File arquivo = new File("");

        try {
            arquivo.createNewFile();
            caminho = arquivo.getPath();
            System.out.print("Arquivo criado com sucesso!");

            FileWriter writer = new FileWriter(caminho,true);
            writer.write(  "\n" );
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
