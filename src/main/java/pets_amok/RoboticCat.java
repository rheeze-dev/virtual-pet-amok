package pets_amok;

public class RoboticCat extends RoboticPet {

    public RoboticCat(String name) {
        super(name);
        this.setDescription("Robotic Cat");
    }

    public RoboticCat(String name, int happiness, int oilLevel, int maintenance) {
        super(name, happiness, oilLevel, maintenance);
        this.setDescription("Robotic Cat");
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
        return performMaintenance(5);
    }
}
