package pets_amok;

public class RoboticDog extends RoboticPet implements Dog {

    public RoboticDog(String name) {
        super(name);
        this.setDescription("Robotic Dog");
    }

    public RoboticDog(String name, int happiness, int oilLevel, int maintenance) {
        super(name, happiness, oilLevel, maintenance);
        this.setDescription("Robotic Dog");
    }

    @Override
    public String walkDog(int value) {
        setHappiness(getHappiness() + value >= 100 ? 100 : getHappiness() + value);
        setOilLevel(getOilLevel() - value);
        setMaintenance(getMaintenance() + value);
        if (value == 20)
            return "You took " + getName() + " for a walk.";
        return getName() + " went for a walk on his own.";
    }

    @Override
    public String performPriorityNeed() {
        int[] arr = { getOilLevel(), getHappiness(), getMaintenance() };
        int min = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        if (index == 0)
            return addOil(5);
        else if (index == 1)
            return walkDog(5);
        return performMaintenance(5);
    }
}