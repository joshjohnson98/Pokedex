public class Pokemon {
    private String name = "Some name";
    private int attack = 0;
    private int defense = 0;
    private int speed = 0;

    public Pokemon(String species){ //Should the parameter in constructor be "species"?
        name = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }

    //Should I delete the getter and setter for species?
    public String getSpecies(){
        return name;
    }

    public void setSpecies(String species){
        name = species;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int newAttack){
        attack = newAttack;
    }

    public int getDefense(){
        return defense;
    }

    public void setDefense(int newDefense){
        defense = newDefense;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }

}
