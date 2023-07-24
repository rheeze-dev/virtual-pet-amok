package pets_amok;

public abstract class RoboticPet extends VirtualPet {

    private int oilLevel;

    public RoboticPet(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Robotic Pet");
        this.oilLevel = 10;
    }

    public int getOilLevel() {
        return this.oilLevel;
    }

    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }

    public String addOil(int value) {
        setOilLevel(getOilLevel() + value);
        setHappiness(getHappiness() - value);
        return getName() + " added oil to itself.";
    }

    @Override
    public String displayStats() {
        return getName() + "\t\t|" + getDescription() + "|NA\t\t|NA\t\t|NA\t\t|NA\t\t|" + getHappiness() + "%\t\t|"
                + getOilLevel() + "%\t\t|";
    }

    @Override
    public void tick() {
        setOilLevel(getOilLevel() + 3);
        setHappiness(getHappiness() + 3);
    }

}
