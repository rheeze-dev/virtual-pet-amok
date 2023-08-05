package pets_amok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VirtualPetTest {

    @Test
    void shouldGetOrganicCatName() {
        OrganicCat test = new OrganicCat("Tom");
        assertEquals("Tom", test.getName(), "Method should display the pet's name!");
    }

    @Test
    void shouldAddTenToOrganicCatFieldsEveryTick() {
        OrganicCat test = new OrganicCat("Tom");
        int boredomValue = test.getBoredom();
        test.tick();
        assertEquals(boredomValue + 10, test.getBoredom(), "Method should add 10 to the current value of boredom!");
    }

    @Test
    void shouldLessTwentyOnTheLitterBox() {
        int litterBoxValue = OrganicCat.getLitterBox();
        OrganicCat.cleanLitterBox();
        assertEquals(litterBoxValue - 20, OrganicCat.getLitterBox(),
                "Method should less 20 to the current value of the litter box!");
    }

    @Test
    void shouldReturnTomAteOnItsOwn() {
        OrganicCat test = new OrganicCat("Tom");
        assertEquals("Tom ate on it's own.", test.feed(10),
                "Feed method should return String 'Tom ate on it's own.'");
    }

    @Test
    void shouldLessTwentyOnThirstField() {
        OrganicCat test = new OrganicCat("Tom");
        int thirstValue = test.getThirst();
        test.hydrate(20);
        assertEquals(thirstValue - 20, test.getThirst(),
                "Hydrate method should less 20 to the current value of the thirst field.");
    }

    @Test
    void shouldReturnTomHasReachedItsTirednessLimit() {
        OrganicCat test = new OrganicCat("Tom");
        test.setTiredness(110);
        assertEquals("Tom has reached it's tiredness limit.", test.rest(10),
                "Rest method should return String 'Tom has reached it's tiredness limit'");
    }

    @Test
    void shouldAddTenToTirednessField() {
        OrganicCat test = new OrganicCat("Tom");
        int tirednessValue = test.getTiredness();
        test.play(10);
        assertEquals(tirednessValue + 10, test.getTiredness(),
                "Play method should add 10 to the tiredness field.");
    }

    @Test
    void shouldLessTwentyToSicknessField() {
        OrganicCat test = new OrganicCat("Tom");
        test.setSickness(50);
        int sicknessValue = test.getSickness();
        test.heal(20);
        assertEquals(sicknessValue - 20, test.getSickness(),
                "Heal method should less 20 to the sickness field.");
    }

    @Test
    void shouldGetOrganicDogName() {
        OrganicDog test = new OrganicDog("Spot");
        assertEquals("Spot", test.getName(), "Method should display the pet's name!");
    }

    @Test
    void shouldCleanCage() {
        OrganicDog test = new OrganicDog("Spot");
        int cageCleanlinessValue = test.getCageCleanliness();
        test.cleanCage();
        assertEquals(cageCleanlinessValue - 20, test.getCageCleanliness(),
                "Method should less 20 on the value of the cage cleanliness!");
    }

    @Test
    void shouldWalkDog() {
        OrganicDog test = new OrganicDog("Spot");
        assertEquals("You took Spot for a walk.", test.walkDog(20),
                "Method should return string with the name of the dog!");
    }

    @Test
    void shouldAddTenToOrganicDogFieldsEveryTick() {
        OrganicDog test = new OrganicDog("Spot");
        int hungerValue = test.getHunger();
        test.tick();
        assertEquals(hungerValue + 10, test.getHunger(), "Method should add 10 to the current value of hunger!");
    }

    @Test
    void shouldGetRoboticCatName() {
        RoboticCat test = new RoboticCat("Robocat");
        assertEquals("Robocat", test.getName(), "Method should display the pet's name!");
    }

    @Test
    void shouldGetRoboticDogName() {
        RoboticDog test = new RoboticDog("Robodog");
        assertEquals("Robodog", test.getName(), "Method should display the pet's name!");
    }

    @Test
    void shouldAddTwentyToHappinessField() {
        RoboticDog test = new RoboticDog("Robodog");
        test.walkDog(20);
        assertEquals(100, test.getHappiness(), "Happiness field should have maximum value of 100!");
    }

    @Test
    void shouldReturnYouAddedOilToRobodog() {
        RoboticDog test = new RoboticDog("Robodog");
        assertEquals("You added oil to Robodog", test.addOil(20),
                "Method should return 'You added oil to Robodog'");
    }

    @Test
    void shouldReturnRobodogPerformedMaintenanceToItself() {
        RoboticDog test = new RoboticDog("Robodog");
        assertEquals("Robodog performed maintenance to itself.", test.performMaintenance(10),
                "Method should return 'Robodog performed maintenance to itself.'");
    }

    @Test
    void shouldLessTenToMaintenanceField() {
        RoboticDog test = new RoboticDog("Robodog");
        int maintenanceValue = test.getMaintenance();
        test.tick();
        assertEquals(maintenanceValue - 10, test.getMaintenance(),
                "Maintenance field should be lessened by ten.");
    }

    @Test
    void shouldReturnFalse() {
        VirtualPetShelter test = new VirtualPetShelter();
        assertEquals(false, test.hasPetName("Test"),
                "HasPetName method should return false.");
    }

    @Test
    void shouldReturnTrue() {
        VirtualPetShelter test = new VirtualPetShelter();
        assertEquals(true, test.isHealthGreaterThan0(),
                "isHealthGreaterThan0 method should return true.");
    }

}
