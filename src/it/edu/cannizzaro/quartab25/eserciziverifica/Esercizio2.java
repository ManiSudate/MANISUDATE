public class Esercizio2 {
    public static int contaVocali(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(contaVocali("Ciao"));
        System.out.println(contaVocali("Programmazione"));
        System.out.println(contaVocali("Java"));
    }
}