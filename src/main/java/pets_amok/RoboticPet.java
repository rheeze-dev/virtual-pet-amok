package pets_amok;

public abstract class RoboticPet extends VirtualPet {

    private int oilLevel;
    private int maintenance;

    public RoboticPet(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Robotic Pet");
        this.oilLevel = 10;
        this.maintenance = 20;
    }

    public RoboticPet(String name, int health, int happiness, int oilLevel, int maintenance) {
        super(name, health, happiness);
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
        return this.oilLevel;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String addOil(int value) {
        setOilLevel(getOilLevel() + value);
        setHappiness(getHappiness() - value);
        if (value == 20)
            return "You added oil to " + getName();
        return getName() + " added oil on itself.";

    }

    public String performMaintenance(int value) {
        setMaintenance(getMaintenance() + value);
        if (value == 20)
            return "You performed maintenance to " + getName();
        return getName() + " performed maintenance on itself.";
    }

    @Override
    public String displayStats() {
        return getName() + "\t\t|NA\t\t|NA\t\t|NA\t\t|NA\t\t|NA\t\t|" + getHappiness() + "%\t\t|"
                + getOilLevel() + "%\t\t|";
    }

    @Override
    public void tick() {
        setOilLevel(getOilLevel() + 3);
        setHappiness(getHappiness() + 3);
    }

}
