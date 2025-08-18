public class Monster extends Character {
    public Monster(String name, int maxHealth){
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP", getName(),getCurrentHealth());
        }
        return String.format("%s is a monster and is dead", getName());
    }

    @Override
    public void takeDamage(int n) {
        setCurrentHealth((getCurrentHealth()-(int) Math.floor(n*0.8)));
        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }

    @Override
    public void attack(Character c) {
        c.takeDamage(7);
    }
}