package pets_amok;

public class OrganicCat extends OrganicPet {
    private static int litterBox = 0;

    public OrganicCat(String name, int health, int happiness) {
        super(name, health, happiness);
        this.setDescription("Organic Cat");
    }

    public static int getLitterBox() {
        return litterBox;
    }

    public static void setLitterBox(int newLitter) {
        litterBox = newLitter;
    }

}
