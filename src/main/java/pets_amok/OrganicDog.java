package pets_amok;

public class OrganicDog extends OrganicPet implements Dog {

    private int waste = 0;
    private int cageCleanliness;

    public OrganicDog(String name) {
        super(name);
        this.setDescription("Organic Dog");
    }

    public OrganicDog(String name, int happiness, int hunger, int thirst, int tiredness, int boredom,
            int sickness) {
        super(name, happiness, hunger, thirst, tiredness, boredom, sickness);
        this.setDescription("Organic Dog");
    }

    public int getWaste() {
        return this.waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
        if (getWaste() >= 3) {
            setCageCleanliness(getCageCleanliness() + 20);
            setWaste(0);
        }
    }

    public int getCageCleanliness() {
        return this.cageCleanliness;
    }

    public void setCageCleanliness(int cageCleanliness) {
        this.cageCleanliness = cageCleanliness;
    }

    public String cleanCage() {
        setCageCleanliness(getCageCleanliness() - 20);
        return getName() + "'s cage has been cleaned.";
    }

    @Override
    public void tick() {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setTiredness(getTiredness() + 10);
        setBoredom(getBoredom() + 10);
        setSickness(getSickness() + 10);
        setHappiness(getHappiness() - 10);
        setWaste(getWaste() + 1);
    }

    @Override
    public String walkDog(int value) {
        setHappiness(getHappiness() + value >= 100 ? 100 : getHappiness() + value);
        setBoredom(getBoredom() - value <= 0 ? 0 : getBoredom() - value);
        setHunger(getHunger() + value);
        setThirst(getThirst() + value);
        setTiredness(getTiredness() + value);
        setWaste(-1);
        if (value == 20) {
            return "You took " + getName() + " for a walk.";
        }
        return getName() + " went for a walk on his own.";
    }

    @Override
    public void healthChecker() {
        int arr[] = { getHunger(), getThirst(), getTiredness(), getBoredom(), getSickness(), getCageCleanliness() };
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        if (max >= (100 - getHappiness())) {
            setHealth(100 - max);
        } else {
            setHealth(getHappiness());
        }
    }

    @Override
    public String displayStats() {
        return getName() + "\t|" + getDescription() + "\t|" + getHunger() + "%\t|" + getThirst() + "%\t|"
                + getTiredness() + "%\t\t|" + getBoredom() + "%\t|" + getSickness() + "%\t\t|" + getCageCleanliness()
                + "%\t|" + "NA\t\t|" + getHappiness() + "%\t\t|NA\t\t|NA  |" + getHealth() + "%\t\t|";
    }

}
