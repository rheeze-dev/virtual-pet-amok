package pets_amok;

import java.util.Random;

public abstract class OrganicPet extends VirtualPet {

    private int hunger;
    private int thirst;
    private int tiredness;
    private int boredom;
    private int sickness;
    private Random random = new Random();

    public OrganicPet(String name) {
        super(name);
        this.hunger = 36;
        this.thirst = 28;
        this.tiredness = 12;
        this.boredom = 25;
        this.sickness = 10;
    }

    public OrganicPet(String name, int happiness, int hunger, int thirst, int tiredness, int boredom,
            int sickness) {
        super(name);
        this.hunger = hunger;
        this.thirst = thirst;
        this.tiredness = tiredness;
        this.boredom = boredom;
        this.sickness = sickness;
        this.setHappiness(happiness);
    }

    public int getHunger() {
        return this.hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getTiredness() {
        return this.tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public int getSickness() {
        return this.sickness;
    }

    public void setSickness(int sickness) {
        this.sickness = sickness;
    }

    @Override
    public abstract void tick();

    public String feed(int value) {
        if (value == 30 || value == 20) {
            if (getBoredom() >= random.nextInt(150))
                return getName() + " is bored and refused to eat.";
            else {
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + 20);
                return "You fed " + getName() + ".";
            }
        } else {
            if (getHunger() <= 100) {
                setHunger(getHunger() - value < 0 ? 0 : getHunger() - value);
                setThirst(getThirst() + value);
                return getName() + " ate on it's own.";
            }
            return getName() + " has reached it's starvation limit.";
        }
    }

    public String hydrate(int value) {
        setThirst(getThirst() - value < 0 ? 0 : getThirst() - value);
        if (value == 20)
            return "You gave water to " + getName() + ".";
        else {
            if (getThirst() <= 100)
                return getName() + " drank water on it's own.";
            return getName() + " has reached it's dehydration limit.";
        }
    }

    public String rest(int value) {
        if (value == 20) {
            if (getHunger() >= random.nextInt(150))
                return getName() + " is hungry and refused to sleep.";
            else {
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
                return "You put " + getName() + " to sleep.";
            }
        } else {
            if (getTiredness() <= 100) {
                setTiredness(getTiredness() - value < 0 ? 0 : getTiredness() - value);
                setBoredom(getBoredom() + value);
                return getName() + " took a nap on it's own.";
            }
            return getName() + " has reached it's tiredness limit.";
        }
    }

    public String play(int value) {
        if (value == 20) {
            if (getSickness() >= random.nextInt(150))
                return getName() + " is sick and refused to play.";
            else {
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
                return "You played with " + getName() + ".";
            }
        } else {
            if (getBoredom() <= 100) {
                setBoredom(getBoredom() - value < 0 ? 0 : getBoredom() - value);
                setTiredness(getTiredness() + value);
                setHunger(getHunger() + value);
                setThirst(getThirst() + value);
                setSickness(getSickness() + value);
                return getName() + " played on it's own.";
            }
            return getName() + " has reached it's boredom limit.";
        }
    }

    public String heal(int value) {
        setTiredness(getTiredness() - value > 0 ? getTiredness() - value : 0);
        setHunger(getHunger() - value > 0 ? getHunger() - value : 0);
        setThirst(getThirst() - value > 0 ? getThirst() - value : 0);
        setBoredom(getBoredom() - value > 0 ? getBoredom() - value : 0);
        setSickness(getSickness() - value > 0 ? getSickness() - value : 0);
        if (value == 20)
            return "You made " + getName() + " feel better.";
        else {
            if (getSickness() <= 100)
                return getName() + " self medicated.";
            return getName() + " has reached it's sickness limit.";
        }
    }

    @Override
    public String performPriorityNeed() {
        int[] arr = { getHunger(), getThirst(), getTiredness(), getBoredom(), getSickness() };
        int max = arr[0];
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == 0)
            return feed(5);
        else if (index == 1)
            return hydrate(5);
        else if (index == 2)
            return rest(5);
        else if (index == 3)
            return play(5);
        else
            return heal(5);
    }
}
