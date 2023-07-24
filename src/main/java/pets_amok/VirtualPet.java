package pets_amok;

public abstract class VirtualPet {
    private String name;
    private String description;
    private int health;
    private int happiness;

    public VirtualPet(String name, int health, int happiness) {
        this.name = name;
        this.description = "Virtual Pet";
        this.health = health;
        this.happiness = happiness;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public abstract String performPriorityNeed();

    public abstract String displayStats();

    public abstract void tick();

}
