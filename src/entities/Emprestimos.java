package entities;


import pessoas.Estudante;
import pessoas.Usuario;
import repository.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimos implements Dao {


    private Usuario usuario;

    private Date dataDoEmprestimo;


    public Emprestimos(){
        getDataDoEmprestimo();

    }


    public Emprestimos(Date dataDoEmprestimo) {
        dataDoEmprestimo.toInstant();
        this.dataDoEmprestimo = dataDoEmprestimo;
    }

      /**
       * posso ate formata como a data deve ser enviada , ja que no momento em que o livro e pego
       * o sistema de emprestimo que deve fornece a data , e não  na classe teste que devemos instancia uma data
       *

       */


    public Date getDataDoEmprestimo() {
        return dataDoEmprestimo = new Date() ;
    }

     public boolean devolverLivro(){
         return true;
     }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "" + dataDoEmprestimo
                ;
    }

    @Override
    public void gravar() {
        try {
            FileWriter writer = new FileWriter("src/arquivos/Emprestimos", true);
            writer.write("CPF: " + usuario.getCpf() + "\n" + "Titulo do livro: " +
                usuario.getBooks() + "\n" + "Data: " + dataDoEmprestimo + "\n"+ "CPF: " + usuario.getCpf());
            writer.close();
            System.out.println("livro cadastrado");
        } catch (IOException e) {
            e.printStackTrace();
        }



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
}
