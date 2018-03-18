import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String Args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your new Pokedex!");
        System.out.print("How many Pokemon are in your region: ");

        int numPokemon = scan.nextInt();

        //SET THE SIZE OF POKEDEX TO numPokemon

        System.out.print("\nYour new Pokedex can hold " + numPokemon + " Pokemon. ");
        System.out.println("Let's start using it!\n");

        boolean running = true;
        while (running) {

            boolean error;

            //Check for valid input
            int option = 6;
            do {
                menu();
                error = false;
                try {
                    option = scan.nextInt();
                } catch (InputMismatchException somethingWentWrong) {
                    System.out.println("\nThat is not a valid choice. Try again.\n");
                    error = true;
                    scan.next();
                }
            }while (error);

            if (option>=1 && option<=6) {
                switch (option) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                        running = false;
                        return;
                }
            }
            else{
                System.out.println("\nThat is not a valid choice. Try again.");
            }

            System.out.println();

        }

    }

    public static void menu(){
        System.out.println("1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.print("\nWhat would you like to do? ");
    }

}
