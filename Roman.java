public class Roman {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        // Behandlung fehlender oder falscher Eingabeparameter
        
        try {
            if (N < 1 || N > 5000)
                throw new IllegalArgumentException();


        } catch (IllegalArgumentException ex) {
            System.out.println("Invalid input. Please enter a valid number.");
            System.exit(2);
        }
        
        System.out.println(roman(N));
    }

    static String roman(int n) {
        int[] neededNumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; // Nummern mit bestimmten Symbolzusammensetzungen
        String[] neededSymbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}; // passende Symbole
        
        for (int i = 0; i < neededNumbers.length; i++) { // gehe das Array durch und vergleiche mit enthaltenen Nummern
            if (n >= neededNumbers[i])  { // wenn n größer gleich, kann erstes Symbol geschrieben werden
                return neededSymbols[i] + roman(n - neededNumbers[i]); // Rekursion wo n immer kleiner wird
            }
        }
        return ""; // wird benötigt, da sonst eine Fehlermeldung kommt, sollte aber nie ausgelöst werden, wenn assert() int der main-Methode greift
    }
}
