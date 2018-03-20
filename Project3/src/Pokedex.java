public class Pokedex implements PokedexInterface{

    private Pokemon[] pokemonArray;
    private boolean duplicateFound = false;

    //constructor
    public Pokedex(int numPokemon){
        pokemonArray = new Pokemon[numPokemon];
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
            //Below: If there is a Pokemon in the position AND the name of that Pokemon in all
            // caps is equal to the parameter "species" in all caps, then a duplicate was found
            if (pokemonArray[ii]!=null && pokemonArray[ii].getSpecies().toUpperCase().equals(species.toUpperCase())){
                duplicateFound = true;
            }
        }
        int numFilledSpaces = pokemonArray.length-nullCount;

        //add to next spot in pokemonArray if not a duplicate and array isn't full
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
        int[] stats = new int[3];
        //First, find what the index of your Pokemon of interest is, using "species"
        int index = getIndex(species);

        if (index==-1){
            return null; //Pokemon is missing
        }
        else {
            stats[0] = pokemonArray[index].getAttack();
            stats[1] = pokemonArray[index].getDefense();
            stats[2] = pokemonArray[index].getSpeed();
            return stats;
        }
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
        //First, find what the index of your Pokemon of interest is, using "species"
        int index = getIndex(species);

        if (index==-1){
            return false; //Pokemon is missing
        }
        else {
            pokemonArray[index].setAttack(2*pokemonArray[index].getAttack()); //double attack
            pokemonArray[index].setDefense(4*pokemonArray[index].getDefense()); //quadruple defense
            pokemonArray[index].setSpeed(3*pokemonArray[index].getSpeed()); //triple speed
            return true;
        }
    }

    public int getIndex(String species){
        for (int ii = 0; ii <= pokemonArray.length-1; ii++){
            if (pokemonArray[ii]!=null && pokemonArray[ii].getSpecies().toUpperCase().equals(species.toUpperCase())){
                return ii;
            }
        }
        return -1; //Pokemon is missing (checkStats and evolvePokemon)
    }


}
