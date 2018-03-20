import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String Args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to your new Pokedex!");
        System.out.print("How many Pokemon are in your region?: "); //Question mark or not?

        int numPokemon = scan.nextInt();

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
                        System.out.print("\nPlease enter the Pokemon’s Species: ");
                        species = scan.next();
                        boolean addSuccess = myPokedex.addPokemon(species);
                        if (!addSuccess){
                            if (myPokedex.getDuplicateFound()){
                                System.out.println("Duplicate");
                            }
                            else{
                                System.out.println("Max");
                            }
                        }
                        break;
                    case 3: //Check stats
                        //Validate user input below? If so, implement method similar to "option"
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
                        //Validate user input below? If so, implement method similar to "option"
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
