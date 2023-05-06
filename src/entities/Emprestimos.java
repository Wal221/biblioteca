package entities;


import pessoas.Estudante;
import repository.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimos implements Dao {


    private List<Books> livros = new ArrayList<>();

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

    @Override
    public String toString() {
        return "" + dataDoEmprestimo
                ;
    }

    @Override
    public void gravar() {



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
