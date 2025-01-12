public class Riddle {
    public static void main(String[] args) {
        int N = 7;
        int[] reihe = new int[2 * N];
        
        if (N < 3 || N > 15) {
            System.out.println("Bitte eine ganze Zahl >=3 und <=15 eingeben");
            System.exit(0);
        }

        int results = sortieren(N, reihe, 0, N);

        if (results == 0) {
            System.out.println("keine Loesung");
        }
        else if (N < 10) {
            //  keine Code, damit ich nichts bei der Ausgabe kaputt mache
        }
        else {
            System.out.println(results + " Loesungen");
        }
    }

    static int sortieren(int n, int[] reihe, int results, int maximalN) { // maximalN wird extra benoetigt, fuer das if-Statement am Anfang
        if (n == 0) { // alle Zahlen sind eingereiht und es wurde eine Loesung gefunden
            if (maximalN < 10) {
                for (int zahl : reihe) {
                    System.out.print(zahl + " ");
                }   
                System.out.println();
            }
            return results + 1; // Anzahl Loesungen erhoehen
        }; 


        for (int i = 0; i < reihe.length - n - 1; i++) { // - n - 1 weil n bei jedem Durchgang zwei mal eingetragen werden soll, ohne das gehen wir out of Bounce
            if (reihe[i] == 0 && reihe[i + n + 1] == 0) { // jetzige Stelle und Stelle mit n Stellen daswischen (zwischen Zahlen muss Abstand n + 1 sein)
                reihe[i] = n; // eintragen der n Werte an passenden Stellen
                reihe[i + n + 1] = n;
            

            results = sortieren(n - 1, reihe, results, maximalN); // Rekursion, maximalN wird unveraendert uebernommen, da es sich ja nicht aendern soll

            // falls beide if Statements nicht greifen, soll die Reihe wieder zurueckgesetzt werden, dass da nicht irgendwelche Werte drinne sind
            // beide if Statements muessen greifen, da die Reihe sonst nicht moeglich sein kann
            reihe[i] = 0;
            reihe[i + n + 1] = 0;
            }
        }
        return results;
    }    
}
