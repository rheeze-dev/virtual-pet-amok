package pets_amok;

public class RoboticDog extends RoboticPet implements Dog {

    public RoboticDog(String name, int happiness) {
        super(name, happiness);
        this.setDescription("Robotic Dog");
    }

    public RoboticDog(String name, int happiness, int oilLevel) {
        super(name, happiness, oilLevel);
        this.setDescription("Robotic Dog");
    }

    @Override
    public String walkDog(int value) {
        setHappiness(getHappiness() + value);
        setOilLevel(getOilLevel() - value);
        if (getHappiness() >= 100)
            setHappiness(100);
        if (value == 20)
            return "You took " + getName() + " for a walk.";
        return getName() + " went for a walk on his own.";
    }

    @Override
    public String performPriorityNeed() {
        int[] arr = { getOilLevel(), getHappiness() };
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
        else
            return walkDog(5);
    }
}