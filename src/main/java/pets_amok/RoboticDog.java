package pets_amok;

public class RoboticDog extends RoboticPet implements Dog {

    public RoboticDog(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Robotic Dog");
    }

    @Override
    public String walkPet(int value) {
        setHappiness(getHappiness() - value);
        setOilLevel(getOilLevel() + value);
        if (value == 20) {
            return "You took " + getName() + " for a walk.";
        }
        return getName() + " went for a walk on his own.";
    }

    @Override
    public String performPriorityNeed() {
        int[] arr = { getOilLevel(), getHappiness() };
        int max = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == 0)
            return addOil(5);
        else
            return walkPet(5);
    }

}