import java.util.Scanner;
import java.util.Random;
import java.lang.String;

public class Tris {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] griglia = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        stampaGriglia(griglia);

        while (true) {
            turnoGiocatore(griglia, scanner);
            if (isGiocoFinito(griglia)){
                break;
            }
            stampaGriglia(griglia);

            turnoComputer(griglia);
            if (isGiocoFinito(griglia)){
                break;
            }
            stampaGriglia(griglia);
        }
        scanner.close();
    }

  //------------------- METODI : ----------------------------
  
    private static boolean isGiocoFinito(char[][] griglia){
        if (vittoria(griglia, 'x')){
            stampaGriglia(griglia);
            System.out.println("Hai vinto!");
            return true;
        }
        if(vittoria(griglia, 'o')){
            stampaGriglia(griglia);
            System.out.println("Il pc ha vinto!");
            return true;
        }
        for(int i=0; i< griglia.length; i++){
            for (int j=0; j< griglia.length; j++){
                if(griglia[i][j] == ' '){
                    return false;
                }
            }
        }
        stampaGriglia(griglia);
        System.out.println("Gioco finito");
        return true;
    }

    //metodo per stampare griglia:
    private static void stampaGriglia(char[][] griglia) {
        System.out.println(griglia[0][0] + "|" + griglia[0][1] + "|" + griglia[0][2]);
        System.out.println("-+-+-");
        System.out.println(griglia[1][0] + "|" + griglia[1][1] + "|" + griglia[1][2]);
        System.out.println("-+-+-");
        System.out.println(griglia[2][0] + "|" + griglia[2][1] + "|" + griglia[2][2]);
    }

  //giocatore sceglie la casella
    private static void turnoGiocatore(char[][] griglia, Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("In che posizione vuoi iniziare? (1-9)");
            userInput = scanner.nextLine();
            if(isMossaValida(griglia, userInput)){
                break;
            } else{
                System.out.println(userInput + "Mossa non valida !");
            }
        } spazioMossa(griglia, userInput, 'x');
    }

  //scelta computer tramite funzione random()
    private static void turnoComputer(char[][] griglia) {
    Random rand = new Random();
    int inputComputer;
    while (true) {
        inputComputer = rand.nextInt(9) + 1;
        if (isMossaValida(griglia, Integer.toString(inputComputer))) {
            break;
        }
    }
    System.out.println("Turno computer " + inputComputer);
    spazioMossa(griglia, Integer.toString(inputComputer), 'o');
}

  
  //casi in un è possibile fare il tris:
    private static boolean vittoria(char[][] griglia, char simbolo){
        if(     (griglia[0][0] == simbolo && griglia[0][1] == simbolo && griglia [0][2]==simbolo) ||
                (griglia[1][0] == simbolo && griglia[1][1] == simbolo && griglia [1][2]==simbolo) ||
                (griglia[2][0] == simbolo && griglia[2][1] == simbolo && griglia [2][2]==simbolo) ||

                (griglia[0][0] == simbolo && griglia[1][0] == simbolo && griglia [2][0]==simbolo) ||
                (griglia[0][1] == simbolo && griglia[1][1] == simbolo && griglia [2][1]==simbolo) ||
                (griglia[0][2] == simbolo && griglia[1][2] == simbolo && griglia [2][2]==simbolo) ||

                (griglia[0][0] == simbolo && griglia[1][1] == simbolo && griglia [2][2]==simbolo) ||
                (griglia[0][2] == simbolo && griglia[1][1] == simbolo && griglia [2][0]==simbolo) )
        {
            return true;
        }
        return false;
        }
  

    //scelta casella
    private static void spazioMossa(char[][] griglia, String posizione, char simbolo) {
        switch (posizione) {
            case "1": //uso " " perchè lavoro con le stringhe
                griglia[0][0] = simbolo;
                break;
            case "2":
                griglia[0][1] = simbolo;
                break;
            case "3":
                griglia[0][2] = simbolo;
                break;
            case "4":
                griglia[1][0] = simbolo;
                break;
            case "5":
                griglia[1][1] = simbolo;
                break;
            case "6":
                griglia[1][2] = simbolo;
                break;
            case "7":
                griglia[2][0] = simbolo;
                break;
            case "8":
                griglia[2][1] = simbolo;
                break;
            case "9":
                griglia[2][2] = simbolo;
                break;
            default:
                System.out.println("->");
        }
    }
  

    //faccio il check se la casella è già occupata
    private static boolean isMossaValida(char[][] griglia, String posizione) {
        switch (posizione) {
            case "1":
                return (griglia[0][0] == ' ');
            case "2":
                return (griglia[0][1] == ' ');
            case "3":
                return (griglia[0][2] == ' ');
            case "4":
                return (griglia[1][0] == ' ');
            case "5":
                return (griglia[1][1] == ' ');
            case "6":
                return (griglia[1][2] == ' ');
            case "7":
                return (griglia[2][0] == ' ');
            case "8":
                return (griglia[2][1] == ' ');
            case "9":
                return (griglia[2][2] == ' ');
            default:
                return false;
        }
    }
}
