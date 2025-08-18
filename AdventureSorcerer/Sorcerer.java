public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character c) {
        c.setCurrentHealth(c.getCurrentHealth()+healCapacity);
        if (c.getCurrentHealth() > c.getMaxHealth()) {
            c.setCurrentHealth(c.getMaxHealth());
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", this.getName(), this.healCapacity);
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", this.getName(),this.getCurrentHealth(),this.healCapacity);
    }
}