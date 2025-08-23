public class MarrioWithTanookiSuit implements Decorator {

    private Character character;

    public MarrioWithTanookiSuit(Character character) {
        this.character = character;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void getAbilities() {
        character.getAbilities();
        System.out.println("Marrio can turn into a statue");
    }

}
