package pets_amok;

import java.util.Random;

public class OrganicDog extends OrganicPet implements Dog {

    private int waste;
    private int cageCleanliness;

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

    public int getCageCleanliness() {
        return this.cageCleanliness;
    }

    public void setCageCleanliness(int cageCleanliness) {
        this.cageCleanliness = cageCleanliness;
    }

    public String cleanCage() {
        setCageCleanliness(getCageCleanliness() - 10);
        return "Cage has been cleaned.";
    }

    @Override
    public String walkDog(int value) {
        setHappiness(getHappiness() - value);
        setWaste(getWaste() - value);
        if (value == 20)
            return "You walked " + getName();
        return getName() + " went for a walk on it's own.";
    }

}
