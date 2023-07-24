package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {

    private int waste;

    public OrganicDog(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Organic Dog");
    }

    public int getWaste() {
        return this.waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
    }

    @Override
    public String walkPet(int value) {
        setHappiness(getHappiness() - value);
        setWaste(getWaste() - value);
        if (value == 20)
            return "You walked " + getName();
        return getName() + " went for a walk on it's own.";
    }

}
