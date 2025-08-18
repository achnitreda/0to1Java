public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getShield(){
        return shield;
    }

    @Override
    public int getHealCapacity(){
        return healCapacity;
    }

    @Override
    public void heal(Character c){
        c.setCurrentHealth(c.getCurrentHealth()+healCapacity);
        if (c.getCurrentHealth() > c.getMaxHealth()) {
            c.setCurrentHealth(c.getMaxHealth());
        }
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() <= 0) {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", this.getName(), this.shield, this.healCapacity);
        }
        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", this.getName(),this.getCurrentHealth(),this.healCapacity,this.shield);
    } 

    @Override
    public void takeDamage(int n) {
        setCurrentHealth(getCurrentHealth()-(n-getShield()));
        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }

    @Override
    public void attack(Character c) {
        heal(this);
        if (getWeapon() != null) {
            c.takeDamage(getWeapon().getDamage());
        }else { 
            c.takeDamage(6);
        }
    }
}