public class Persona {
    String nome;
    String cognome;
    String sesso;

    public Persona(String nome, String cognome, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cognome: " + cognome + ", Sesso: " + sesso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Persona)) return false;

        Persona persona = (Persona) obj;
        return nome.equalsIgnoreCase(persona.nome)
                && cognome.equalsIgnoreCase(persona.cognome)
                && sesso.equalsIgnoreCase(persona.sesso);
    }

    @Override
    public int hashCode() {
        return (nome.toLowerCase() + cognome.toLowerCase() + sesso.toLowerCase()).hashCode();
    }
}
