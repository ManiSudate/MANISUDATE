public class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public void stampaDati(){
        System.out.println("Nome: "+ nome);
        System.out.println("Cognome: "+ cognome);
    }
}

