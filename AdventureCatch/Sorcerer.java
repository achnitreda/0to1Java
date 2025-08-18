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
    public void heal(Character c) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        if (c.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(c);
        }
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
    public void takeDamage(int n) throws DeadCharacterException {
    System.out.println("takeDamage called. Current health: " + getCurrentHealth());
    
    if (getCurrentHealth() <= 0) {
        System.out.println("Throwing exception - character is dead");
        throw new DeadCharacterException(this);
    }
    
    setCurrentHealth(getCurrentHealth() - n);
    if (getCurrentHealth() < 0) {
        setCurrentHealth(0);
    }
    
    System.out.println("After damage, health: " + getCurrentHealth());
    }

    @Override
    public void attack(Character c) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        heal(this);
        if (getWeapon() != null) {
            c.takeDamage(getWeapon().getDamage());
        } else {
            c.takeDamage(10);
        }
    }
}