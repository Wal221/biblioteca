package obras;

public class Fotografia extends Obrass {

    private String obrasDeArte;


    public Fotografia(){

    }

    public Fotografia(String obrasDeArte) {
        this.obrasDeArte = obrasDeArte;
    }

    public String getObrasDeArte() {
        return obrasDeArte;
    }

    @Override
    public String acaoObras() {
        return "Fotografia sendo vizualizada" + obrasDeArte + titulo;
    }
}


