package repository;

import java.io.IOException;

public interface Dao {

    public void gravar() throws IOException;
    public void excluir();
    public void ler();
    public void atualizar();
}
