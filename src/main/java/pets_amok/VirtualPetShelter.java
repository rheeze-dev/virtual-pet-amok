package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VirtualPetShelter {

    Map<String, VirtualPet> pets = new HashMap<>();

    public Collection<VirtualPet> getAllPets() {
        return pets.values();
    }

    public VirtualPet getPet(String name) {
        return pets.get(name);
    }

    public Set<String> getAllPetNames() {
        return pets.keySet();
    }

    public void rescuePet(VirtualPet newPet) {
        pets.put(newPet.getName(), newPet);
    }

    public void adoptPet(String name) {
        pets.remove(name);
    }

    public String feedAll(int value) {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.feed(value) + "\n");
            }
        }
        return str.toString();
    }

    public String hydrateAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.hydrate(20) + "\n");
            }
        }
        return str.toString();
    }

    public String restAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.rest(20) + "\n");
            }
        }
        return str.toString();
    }

    public String playAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.play(20) + "\n");
            }
        }
        return str.toString();
    }

    public String playPet(String name) {
        OrganicPet pet = (OrganicPet) getPet(name);
        return pet.play(20) + "\n";
    }

    public String healAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.heal(20) + "\n");
            }
        }
        return str.toString();
    }

    public String performMaintenanceAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof RoboticPet) {
                RoboticPet roboticPet = (RoboticPet) pet;
                str.append(roboticPet.performMaintenance(20) + "\n");
            }
        }
        return str.toString();
    }

    public String addOilAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof RoboticPet) {
                RoboticPet roboticPet = (RoboticPet) pet;
                str.append(roboticPet.addOil(20) + "\n");
            }
        }
        return str.toString();
    }

    public String cleanLitterBoxAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicCat) {
                OrganicCat organicCat = (OrganicCat) pet;
                str.append(organicCat.cleanLitterBox() + "\n");
            }
        }
        return str.toString();
    }

    public String cleanAllCages() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicDog) {
                OrganicDog organicDog = (OrganicDog) pet;
                str.append(organicDog.cleanCage() + "\n");
            }
        }
        return str.toString();
    }

    public String walkAllDogs() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicDog) {
                OrganicDog organicDog = (OrganicDog) pet;
                str.append(organicDog.walkDog(20) + "\n");
            } else {
                RoboticDog roboticDog = (RoboticDog) pet;
                str.append(roboticDog.walkDog(20) + "\n");
            }
        }
        return str.toString();
    }

    public boolean hasPetName(String name) {
        if (pets.containsKey(name)) {
            return true;
        }
        return false;
    }

    public void tickAll() {
        for (VirtualPet pet : getAllPets()) {
            pet.tick();
        }
    }

    public boolean areValuesLessThan100() {
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                if (organicPet.getHunger() >= 100 || organicPet.getThirst() >= 100 || organicPet.getTiredness() >= 100
                        || organicPet.getBoredom() >= 100 || organicPet.getSickness() >= 100
                        || organicPet.getHappiness() >= 100)
                    return false;
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                if (roboticPet.getOilLevel() >= 100 || roboticPet.getHappiness() >= 100)
                    return false;
            }
        }
        return true;
    }

    public String displayMessage() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                if (organicPet.getHunger() >= 100)
                    str.append(organicPet.getName() + " starved!\n");
                if (organicPet.getThirst() >= 100)
                    str.append(organicPet.getName() + " got dehydrated!\n");
                if (organicPet.getTiredness() >= 100)
                    str.append(organicPet.getName() + " got soo tired!\n");
                if (organicPet.getBoredom() >= 100)
                    str.append(organicPet.getName() + " got soo bored!\n");
                if (organicPet.getSickness() >= 100)
                    str.append(organicPet.getName() + " got soo sick!\n");
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                if (roboticPet.getOilLevel() >= 100)
                    str.append(roboticPet.getName() + " stopped working due to rust!");
                if (roboticPet.getHappiness() >= 100)
                    str.append(roboticPet.getName() + " stopped working due to sadness!");
            }
        }
        return str.toString();
    }

    public String performPriorityNeedAll() {
        StringBuilder str = new StringBuilder();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.performPriorityNeed() + "\n");
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                str.append(roboticPet.performPriorityNeed() + "\n");
            }
        }
        return str.toString();
    }

    public String displayAllStats() {
        StringBuilder str = new StringBuilder();
        str.append("Name\t\t|Hunger\t\t|Thirst\t\t|Tiredness\t|Boredom\t|Sickness\t|Happiness\t|Oil level\t|\n"
                + "----------------|---------------|---------------|---------------|---------------|---------------|---------------|---------------|\n");
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                str.append(organicPet.displayStats() + "\n");
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                str.append(roboticPet.displayStats() + "\n");
            }
        }
        return str.toString();
    }

    public String displayPet() {
        String pet = "      __\n" +
                " w  c(..)o   (\n" +
                "  \\__(-)    __)\n" +
                "      /\\   (\n" +
                "     /(_)___)\n" +
                "    w /|\n" +
                "      | \\\n" +
                "      m  m";
        return pet;
    }
}
