
 public abstract class Character {
    private int health;
    private String name;
    private int damage;
     private int magicCharges ;

    protected Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    protected void attack1(Character target, Character attacker) {
        target.setHealth(target.getHealth() - attacker.getDamage());
        target.onHit(attacker);
    }

    public void onHit(Character attacker) {
        System.out.println(attacker.getName() + " hits for " + attacker.getDamage() + " damage!");

    }


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
