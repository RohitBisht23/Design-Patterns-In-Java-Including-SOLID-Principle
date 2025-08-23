public class MarrioWithFireFlower implements Decorator {

    private Character character;

    public MarrioWithFireFlower(Character character) {
        this.character = character;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void getAbilities() {
        character.getAbilities();
        System.out.println("Marrio can throw fireballs");
    }
}