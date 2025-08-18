import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private final Weapon weapon;

    private static List<Character> allCharacters = new ArrayList<>();

    public Weapon getWeapon() {
        return weapon;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    protected int setCurrentHealth(int currHealth) {
        this.currentHealth = currHealth;
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    public Character(String name, int maxHealth, Weapon weapon) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public static String printStatus() {
        String border = "------------------------------------------";
        String intro = "Characters currently fighting :";
        String noChar = "Nobody's fighting right now !";
        String res = border + "\n";
        
        if (allCharacters == null || allCharacters.isEmpty()) {
            res += noChar + "\n" + border + "\n";
            return res;
        }
        
        res += intro + "\n";
        for (Character c : allCharacters) {
            res += " - " + c.toString() + "\n";
        }
        
        return res + border + "\n";
    }

    public static Character fight(Character c1,Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            try {
                c1.attack(c2);
            } catch (DeadCharacterException e) {
                break;
            }
            if (c2.getCurrentHealth() > 0) {
                try {
                    c2.attack(c1);
                } catch (DeadCharacterException e) {
                    break;
                }
            }
        }
        if (c1.getCurrentHealth() > 0) {
            return c1;
        }else{
            return c2;
        }
    }

    @Override
    public String toString() {
        if (this.currentHealth <= 0) {
            return String.format("%s : KO", this.name);
        }
        return String.format("%s : %d/%d", this.name,this.currentHealth,this.maxHealth);
    }

    public abstract void takeDamage(int n) throws DeadCharacterException;

    public abstract void attack(Character c) throws DeadCharacterException;
}