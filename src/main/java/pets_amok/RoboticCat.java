package pets_amok;

public class RoboticCat extends RoboticPet {

    public RoboticCat(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Robotic Cat");
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
        // else
        // return wal;
        return "";
    }

}
