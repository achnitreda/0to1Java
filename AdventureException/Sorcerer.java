public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
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
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), healCapacity);
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", getName(),getCurrentHealth(),healCapacity);
    }

    @Override
    public void takeDamage(int n) {
        setCurrentHealth(getCurrentHealth()-n);
        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }

    @Override
    public void attack(Character c) {
        heal(this);
        if (getWeapon() != null) {
            c.takeDamage(getWeapon().getDamage());
        } else {
            c.takeDamage(10);
        }
    }
}