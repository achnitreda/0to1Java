import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    private static List<Character> allCharacters = new ArrayList<>();

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.name = name;
        this.currentHealth = maxHealth;
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
            c1.attack(c2);
            if (c2.getCurrentHealth() > 0) {
                c2.attack(c1);
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

    public void takeDamage(int n) {
        this.currentHealth -=n;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
    }

    public void attack(Character c) {
        c.takeDamage(9);
    }
}