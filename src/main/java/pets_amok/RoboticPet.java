package pets_amok;

public abstract class RoboticPet extends VirtualPet {

    private int oilLevel;

    public RoboticPet(String name, int happiness) {
        super(name, happiness);
        this.setDescription("Robotic Pet");
        this.oilLevel = 70;
    }

    public RoboticPet(String name, int happiness, int oilLevel) {
        super(name, happiness);
        this.setDescription("Robotic Pet");
        this.oilLevel = oilLevel;
    }

    public int getOilLevel() {
        return this.oilLevel;
    }

    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }

    public String addOil(int value) {
        setOilLevel(getOilLevel() + value);
        setHappiness(getHappiness() + value);
        if (getOilLevel() >= 100)
            setOilLevel(100);
        if (getHappiness() >= 100)
            setHappiness(100);
        if (value == 20)
            return "You added oil to " + getName();
        return getName() + " added oil to itself.";
    }

    @Override
    public void healthChecker() {
        if (getOilLevel() >= getHappiness()) {
            setHealth(getHappiness());
        } else {
            setHealth(getOilLevel());
        }
    }

    @Override
    public String displayStats() {
        return getName() + "\t|" + getDescription() + "\t|" + "NA\t|NA\t|NA\t\t|NA\t\t|NA\t\t|NA\t|NA\t\t|"
                + getHappiness() + "%\t\t|"
                + getOilLevel() + "%\t|" + getHealth() + "%\t|";
    }

    @Override
    public void tick() {
        setOilLevel(getOilLevel() - 10);
        setHappiness(getHappiness() - 10);
    }

}
