import java.util.Random;
import java.util.Scanner;

public class MorraCinese {
    public static void main(String[] args) {
        // user input and computer's choice
        String userAns, pcAns;
        char answer;
        // punti user e punti computer
        int userPoints = 0, pcPoints = 0;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        // ciclo nuova partita
        do {
            // ciclo partita punti < 5
            do {
                // scelta del computer
                int pcChoice = rand.nextInt(3) + 1;
                if (pcChoice == 1) {
                    pcAns = "carta";
                } else if (pcChoice == 2) {
                    pcAns = "forbice";
                } else {
                    pcAns = "sasso";
                }
                // scelta dell'utente
                System.out.print("Scegli tra carta, sasso e forbice (o esci per uscire): ");
                userAns = scan.nextLine().toLowerCase();
    
                if (userAns.equals("esci")) {
                    break;
                }


                // gioco
                if ((userAns.equals("carta") && pcAns.equals("sasso")) ||
                (userAns.equals("sasso") && pcAns.equals("forbice")) ||
                (userAns.equals("forbice") && pcAns.equals("carta"))) {
                System.out.println("Hai vinto! Il computer ha scelto " + pcAns + ".");
                userPoints++;
                } else if ((pcAns.equals("carta") && userAns.equals("sasso")) ||
                        (pcAns.equals("sasso") && userAns.equals("forbice")) ||
                        (pcAns.equals("forbice") && userAns.equals("carta"))) {
                    System.out.println("Hai perso! Il computer ha scelto " + pcAns + ".");
                    pcPoints++;
                } else if(userAns.equals(pcAns) ) {
                    System.out.println("Pareggio! Il computer ha scelto " + pcAns + ".");
                }
                System.out.println("Punteggio attuale: Utente " + userPoints + " - Computer " + pcPoints);
            } while (userPoints < 5 && pcPoints < 5);
            System.out.println("Vuoi fare un'altra partita? S per sì.");
            answer = scan.next().charAt(0);
            // Reset dei punti se si decide di giocare di nuovoì
            userPoints = 0;
            pcPoints = 0;
        } while (answer == 's' || answer == 'S');
        scan.close();
        System.out.println("Punteggio finale: Utente " + userPoints + " - Computer " + pcPoints);
        System.out.println("Grazie per aver giocato!");
    }
}
