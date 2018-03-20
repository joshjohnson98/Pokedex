public class Pokedex implements PokedexInterface{

    private Pokemon[] pokemonArray;
    private boolean duplicateFound = false;

    //constructor
    public Pokedex(int numPokemon){
        pokemonArray = new Pokemon[numPokemon];
        //REMOVE BELOW. JUST TO TEST LISTPOKEMON
        /*
        Pokemon charizard = new Pokemon("charizard");
        Pokemon pikachu = new Pokemon("pikachu");
        pokemonArray[0] = pikachu;
        pokemonArray[1] = charizard;
        */

    }

    //	Return all the names of the Pokemon species in the Pokedex
    public String[] listPokemon(){
        //check number of pokemon in array to set String[] length
        int nullCount = 0;
        for (int ii = 0; ii <= pokemonArray.length-1; ii++){
            if (pokemonArray[ii] == null){
                nullCount++;
            }
        }
        int numFilledSpaces = pokemonArray.length-nullCount;
        if (numFilledSpaces == 0){
            return null; //if empty
        }
        else {
            String[] pokemonNames = new String[numFilledSpaces];

            for (int ii = 0; ii <= numFilledSpaces - 1; ii++) {
                String currentName = pokemonArray[ii].getSpecies();
                pokemonNames[ii] = currentName;
            }
            return pokemonNames;
        }
    }

    /*
        Add a Pokemon to the Pokedex and return true if it was
        successful. If not, return false.
    */
    public boolean addPokemon(String species){
        Pokemon nextPokemon = new Pokemon(species);
        //check number of pokemon in array to find next open spot in array
        int nullCount = 0;
        duplicateFound = false;
        for (int ii = 0; ii <= pokemonArray.length-1; ii++){
            if (pokemonArray[ii] == null){
                nullCount++;
            }
            if (pokemonArray[ii]!=null && pokemonArray[ii].getSpecies().equals(species)){
                duplicateFound = true;
            }
        }
        int numFilledSpaces = pokemonArray.length-nullCount;

        //add to next spot in pokemonArray if not duplicate and array isn't full
        if (duplicateFound){
            return false; //don't add
        }
        else if (numFilledSpaces == pokemonArray.length) {
            return false; //don't add
        }
        else {
            pokemonArray[numFilledSpaces] = nextPokemon;
            return true;
        }
    }

    public boolean getDuplicateFound(){
        return duplicateFound;
    }

    /*
       Return the stats of a certain Pokemon that you are
        searching for. The stats will be attack, defense, then speed
        in that order within the array that will be returned.
    */
    public int[] checkStats(String species){

        return null; //remove later
    }

    //	Sort Pokedex in lexical order (alphabetical) according to the species names.
    public void sortPokedex(){

    }


    /*
        Evolve a certain Pokemon by tripling the speed stat,
        doubling the attack stat, and quadrupling the defense stat.
        Return true if the evolve was successful.
        If not, return false.
    */
    public boolean evolvePokemon(String species){

        return false; //remove later
    }


}
