package obras;

public abstract class Obrass {
    /**@return
    * Atributo que da titulo as obras a classes filhas
     */
   public String titulo;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract String acaoObras();
}
