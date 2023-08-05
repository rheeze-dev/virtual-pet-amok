package pets_amok;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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

    public Set<String> getAllOrganicPetNames() {
        Set<String> petnames = new HashSet<String>();
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                petnames.add(pet.getName());
            }
        }
        return petnames;
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
            } else if (pet instanceof RoboticDog) {
                RoboticDog roboticDog = (RoboticDog) pet;
                str.append(roboticDog.walkDog(20) + "\n");
            }
        }
        return str.toString();
    }

    public boolean hasPetName(String name) {
        if (pets.keySet().contains(name))
            return true;
        return false;
    }

    public void tickAll() {
        for (VirtualPet pet : getAllPets()) {
            pet.tick();
        }
    }

    public boolean isHealthGreaterThan0() {
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                if (organicPet.getHealth() <= 0)
                    return false;
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                if (roboticPet.getHealth() <= 0)
                    return false;
            }
        }
        return true;
    }

    public String displayMessage() {
        StringBuilder str = new StringBuilder();
        boolean isLitterBoxMessageDisplayed = false;
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
                if (organicPet.getHappiness() <= 0)
                    str.append(organicPet.getName() + " got soo sad!\n");
                if (OrganicCat.getLitterBox() >= 100) {
                    if (!isLitterBoxMessageDisplayed) {
                        str.append("Organic cats litterbox has overflowed and made all organic cats sick!");
                        isLitterBoxMessageDisplayed = true;
                    }
                }
                if (organicPet instanceof OrganicDog) {
                    OrganicDog organicDog = (OrganicDog) organicPet;
                    if (organicDog.getCageCleanliness() >= 100)
                        str.append(organicDog.getName() + "'s cage got so dirty!");
                }
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                if (roboticPet.getOilLevel() <= 0)
                    str.append(roboticPet.getName() + " stopped working due to rust!\n");
                if (roboticPet.getMaintenance() <= 0)
                    str.append(
                            roboticPet.getName() + " stopped working due to damaged parts from lack of maintenance!");
                if (roboticPet.getHappiness() <= 0)
                    str.append(roboticPet.getName() + " stopped working due to sadness!\n");
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
                organicPet.healthChecker();
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                str.append(roboticPet.performPriorityNeed() + "\n");
                roboticPet.healthChecker();
            }
        }
        return str.toString();
    }

    public String displayAllStats() {
        StringBuilder str = new StringBuilder();
        str.append(
                "Name\t|Description\t|Hunger\t|Thirst\t|Tiredness\t|Boredom|Sickness\t|Cage\t|Litter box\t|Happiness\t|Maintenance\t|Oil |Health\t|\n"
                        + "--------|---------------|-------|-------|---------------|-------|---------------|-------|---------------|---------------|---------------|----|--------|\n");
        for (VirtualPet pet : getAllPets()) {
            if (pet instanceof OrganicPet) {
                OrganicPet organicPet = (OrganicPet) pet;
                organicPet.healthChecker();
                str.append(organicPet.displayStats() + "\n");
            } else {
                RoboticPet roboticPet = (RoboticPet) pet;
                roboticPet.healthChecker();
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
