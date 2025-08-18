import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 18, 2, 4);
        Sorcerer morrigan = new Sorcerer("Morrigan", 21, 5);
        Monster dragon = new Monster("Dragon", 12);

        dragon.attack(alistair);
        dragon.attack(morrigan);
        
        alistair.attack(dragon);
        morrigan.attack(dragon);

        System.out.println(Character.printStatus());
    }

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

    protected int setCurrentHealth(int currHealth) {
        this.currentHealth = currHealth;
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

    public abstract void takeDamage(int n);

    public abstract void attack(Character c);
}