import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String Args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your new Pokedex!");
        System.out.print("How many Pokemon are in your region: ");

        int numPokemon = scan.nextInt();

        Pokedex myPokedex = new Pokedex(numPokemon);

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
                        //Validate user input below? If so, implement method similar to "option"
                        System.out.print("Please enter the Pokemon’s Species: ");
                        String species = scan.next();
                        myPokedex.addPokemon(species);

                        //If there is already a Pokemon with the same species name (ignoring casing),
                        // the output should be “Duplicate”

                        //When the Pokedex is full and a user tries to add a Pokemon,
                        // the output should be “Max”.

                        //this can return false if it doesn't work
                        //How should I use this with my two different error messages?
                        break;
                    case 3: //Check stats
                        //Validate user input below? If so, implement method similar to "option"
                        System.out.print("Please enter the Pokemon of interest: ");
                        //if returns null, print "Missing"
                        //(A Pokemon is missing from the Pokedex)
                        break;
                    case 4: //evolve pokemon
                        //Validate user input below? If so, implement method similar to "option"
                        System.out.print("Please enter the Pokemon of interest: ");
                        //if returns false, print "Missing"
                        //(A Pokemon is missing from the Pokedex)
                        break;
                    case 5: //sort pokemon


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

    public static void menu(){
        System.out.println("1. List Pokemon");
        System.out.println("2. Add Pokemon");
        System.out.println("3. Check a Pokemon's Stats");
        System.out.println("4. Evolve Pokemon");
        System.out.println("5. Sort Pokemon");
        System.out.println("6. Exit");
        System.out.print("\nWhat would you like to do? ");
    }

    //Use for listPokemon. Possibly make different variations for other options
    public static void printStringArray(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }
    }

}
