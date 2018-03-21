import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String Args[]){
        System.out.println("Welcome to your new Pokedex!");
        Scanner scan = new Scanner(System.in);

        //Check for valid input
        int numPokemon = 0;
        boolean error1;
        do {
            System.out.print("How many Pokemon are in your region?: ");
            error1 = false;
            try {
                numPokemon = scan.nextInt();
            } catch (InputMismatchException somethingWentWrong) {
                System.out.println("\nThat is not a valid choice. Try again.");
                error1 = true;
                scan.next();
            }
        }while (error1);

        //initialize new Pokedex with user's inputted number of Pokemon in region
        Pokedex myPokedex = new Pokedex(numPokemon);

        System.out.print("\nYour new Pokedex can hold " + numPokemon + " Pokemon. ");
        System.out.println("Let's start using it!\n");

        String species;
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

            //use switch cases for the 6 user options
            if (option>=1 && option<=6) {
                switch (option) {
                    case 1: //list Pokemon
                        String pokemonNames[] = myPokedex.listPokemon();
                        if (pokemonNames == null){
                            System.out.println("Empty");
                        }
                        else{
                            printStringArray(pokemonNames);
                        }
                        break;
                    case 2: //add Pokemon
                        System.out.print("\nPlease enter the Pokemon's Species: ");
                        species = scan.next();
                        boolean addSuccess = myPokedex.addPokemon(species);
                        if (!addSuccess){
                            if (myPokedex.getDuplicateFound() && myPokedex.getMaxFound()){
                                System.out.println("Max");
                            }
                            else if (myPokedex.getDuplicateFound()){
                                System.out.println("Duplicate");
                            }
                            else{
                                System.out.println("Max");
                            }
                        }
                        break;
                    case 3: //Check stats
                        System.out.print("\nPlease enter the Pokemon of interest: ");
                        species = scan.next();
                        int stats[] = myPokedex.checkStats(species);
                        if (stats == null){
                            System.out.println("Missing");
                        }
                        else {
                            System.out.println("\nThe stats for " + species + " are:");
                            System.out.println("Attack: " + stats[0]);
                            System.out.println("Defense: " + stats[1]);
                            System.out.println("Speed: " + stats[2]);
                        }
                        break;
                    case 4: //evolve pokemon
                        System.out.print("\nPlease enter the Pokemon of interest: ");
                        species = scan.next();
                        boolean evolveSuccess = myPokedex.evolvePokemon(species);
                        if (!evolveSuccess){
                            System.out.println("Missing");
                        }
                        else{
                            System.out.println(species + " has evolved!");
                        }
                        break;
                    case 5: //sort pokemon
                        myPokedex.sortPokedex();
                        break;
                    case 6: //exit
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

    private static void menu(){
        System.out.println("1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.print("\nWhat would you like to do? ");
    }

    //Use for listPokemon
    private static void printStringArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

}
