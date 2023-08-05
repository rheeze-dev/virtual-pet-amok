package pets_amok;

import java.util.Random;

public class OrganicCat extends OrganicPet {

    private static int litterBox = 0;
    private Random random = new Random();

    public OrganicCat(String name) {
        super(name);
        this.setDescription("Organic Cat");
    }

    public OrganicCat(String name, int happiness, int hunger, int thirst, int tiredness, int boredom,
            int sickness) {
        super(name, happiness, hunger, thirst, tiredness, boredom, sickness);
        this.setDescription("Organic Cat");
    }

    public static int getLitterBox() {
        return litterBox;
    }

    public static void setLitterBox(int newLitter) {
        litterBox = newLitter;
    }

    public static String cleanLitterBox() {
        setLitterBox(getLitterBox() - 20);
        return "Litter box has been cleaned.";
    }

    @Override
    public void tick() {
        setHunger(getHunger() + 10);
        setThirst(getThirst() + 10);
        setTiredness(getTiredness() + 10);
        setBoredom(getBoredom() + 10);
        setSickness(getSickness() + 10);
        setHappiness(getHappiness() - 10);
        if (random.nextInt(160) >= 80)
            setLitterBox(getLitterBox() + 10);
    }

    @Override
    public void healthChecker() {
        int arr[] = { getHunger(), getThirst(), getTiredness(), getBoredom(), getSickness(), getLitterBox() };
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        if (max >= (100 - getHappiness())) {
            setHealth(100 - max);
        } else {
            setHealth(getHappiness());
        }
    }

    @Override
    public String displayStats() {
        return getName() + "\t|" + getDescription() + "\t|" + getHunger() + "%\t|" + getThirst() + "%\t|"
                + getTiredness() + "%\t\t|" + getBoredom() + "%\t|" + getSickness() + "%\t\t|NA\t|"
                + OrganicCat.getLitterBox() + "%\t\t|" + getHappiness() + "%\t\t|NA\t\t|NA  |" + getHealth() + "%\t\t|";
    }

}
