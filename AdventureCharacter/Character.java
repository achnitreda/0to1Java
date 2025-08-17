public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 5);
        
        System.out.println(aragorn.toString());
        System.out.println(uruk.toString());
        
        aragorn.attack(uruk);

        System.out.println(uruk.toString());
        
        aragorn.takeDamage(12);

        System.out.println(aragorn.toString());
    }

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