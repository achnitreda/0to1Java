public class DeadCharacterException extends Exception {
    private final Character character;

    public DeadCharacterException(Character c) {
        this.character = c;
    }

    @Override
    public String getMessage() {
        String type = getCharacterType(character);
        return String.format("The %s %s is dead.", type,character.getName());
    }

    private String getCharacterType(Character c) {
        if (c instanceof Sorcerer) {
            return "sorcerer";
        } else if (c instanceof Monster) {
            return "monster";
        } else if (c instanceof Templar) {
            return "templar";
        } else {
            return "";
        }
    }
}