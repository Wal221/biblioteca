package obras;

public class MidiaAudio extends Obrass{
   private String tipoDemidia;


   public MidiaAudio(){

   }

    public String getTipoDemidia() {
        return tipoDemidia;
    }

    public void setTipoDemidia(String tipoDemidia) {
        this.tipoDemidia = tipoDemidia;
    }

    @Override
    public String acaoObras() {
        return  "Ouvindo livro " + tipoDemidia;
    }
}

