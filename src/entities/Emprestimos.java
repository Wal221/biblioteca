package entities;


import pessoas.Estudante;
import pessoas.Pessoa;
import pessoas.Usuario;
import repository.Dao;
import streamTeste.ProductOnline;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Emprestimos implements Dao , Serializable {


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
    public void gravar() throws IOException {

        ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("src/arquivos/emprestimo.txt"));
        objectOutput.writeObject(this.usuario);
        objectOutput.close();

    }

    @Override
    public void excluir() {

    }

    @Override
    public void ler() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream( "src/arquivos/emprestimo.txt"));
        Usuario usuario1 = (Usuario) objectInput.readObject();
        objectInput.close();
        System.out.println(usuario1);

    }

    @Override
    public void atualizar() {

    }
}
