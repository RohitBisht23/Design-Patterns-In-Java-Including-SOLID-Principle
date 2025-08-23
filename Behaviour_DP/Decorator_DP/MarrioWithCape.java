class MarrioWithCape implements Decorator { //Is-A relationship

    private Character character; //Has-A relationship

    public MarrioWithCape(Character character) {
        this.character = character;
    }

    @Override
    public Character getCharacter() {
        return character;
    }

    @Override
    public void getAbilities() {
        character.getAbilities();
        System.out.println("Marrio can fly");
    }
}
