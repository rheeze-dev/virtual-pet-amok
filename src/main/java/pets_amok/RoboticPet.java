package pets_amok;

public abstract class RoboticPet extends VirtualPet implements Robot {

    private int oilLevel;
    private int maintenance;

    public RoboticPet(String name) {
        super(name);
        this.oilLevel = 80;
        this.maintenance = 50;
    }

    public RoboticPet(String name, int happiness, int oilLevel, int maintenance) {
        super(name);
        this.oilLevel = oilLevel;
        this.maintenance = maintenance;
    }

    public int getOilLevel() {
        return this.oilLevel;
    }

    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }

    public int getMaintenance() {
        return this.maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String addOil(int value) {
        setOilLevel(getOilLevel() + value >= 100 ? 100 : getOilLevel() + value);
        setHappiness(getHappiness() + value >= 100 ? 100 : getHappiness() + value);
        setMaintenance(getMaintenance() - value);
        if (value == 20)
            return "You added oil to " + getName();
        return getName() + " added oil to itself.";
    }

    @Override
    public String performMaintenance(int value) {
        setMaintenance(getMaintenance() + value >= 100 ? 100 : getMaintenance() + value);
        setHappiness(getHappiness() + value >= 100 ? 100 : getHappiness() + value);
        setOilLevel(getOilLevel() + value >= 100 ? 100 : getOilLevel() + value);
        if (value == 20)
            return "You performed maintenance to " + getName();
        return getName() + " performed maintenance to itself.";
    }

    @Override
    public void healthChecker() {
        int arr[] = { getOilLevel(), getMaintenance(), getHappiness() };
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        setHealth(min);
    }

    @Override
    public String displayStats() {
        return getName() + "\t|" + getDescription() + "\t|" + "NA\t|NA\t|NA\t\t|NA\t|NA\t\t|NA\t|NA\t\t|"
                + getHappiness() + "%\t\t|" + getMaintenance() + "%\t\t|" + getOilLevel() + "% |" + getHealth()
                + "%\t\t|";
    }

    @Override
    public void tick() {
        setOilLevel(getOilLevel() - 10);
        setHappiness(getHappiness() - 10);
        setMaintenance(getMaintenance() - 10);
    }

}
