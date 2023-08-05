package pets_amok;

import java.util.Scanner;

public class VirtualPetShelterApp {

    static Scanner scanner = new Scanner(System.in);
    static VirtualPetShelter pets = new VirtualPetShelter();

    public static void main(String[] args) {
        initialPets();
        System.out.println("Thank you for volunteering at Big Al's Virtual Pet Shelter!");
        while (pets.isHealthGreaterThan0()) {
            System.out.println("Status of your pets: ");
            System.out.println(pets.displayAllStats());
            promptGameMenu();
            inputChecker();
            int toDo = scanner.nextInt();
            System.out.println();
            if (toDo == 1) {
                promptFoodOptions();
                inputChecker();
                int food = scanner.nextInt();
                System.out.println();
                if (food == 1) {
                    System.out.println("Pet food are organic pets favorite food.");
                    System.out.println(pets.feedAll(30));
                } else if (food == 2) {
                    System.out.println("Treats are organic pets 2nd favorite food.");
                    System.out.println(pets.feedAll(20));
                } else if (food == 3) {
                    System.out.println("Left-overs are organic pets worst food. The organic pets refused to eat it.\n");
                } else
                    continue;
            } else if (toDo == 2)
                System.out.println(pets.hydrateAll());
            else if (toDo == 3)
                System.out.println(pets.restAll());
            else if (toDo == 4) {
                System.out.print(
                        "Press 1 to play with a single organic pet. Press 2 to play with all the organic pets. Press any number except 1 and 2 to change what you want to do: ");
                inputChecker();
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1) {
                    System.out.print("Organic pets names: ");
                    System.out.println(pets.getAllOrganicPetNames());
                    playSinglePet();
                } else if (input == 2)
                    System.out.println(pets.playAll());
                else {
                    System.out.println("");
                    continue;
                }
            } else if (toDo == 5)
                System.out.println(pets.healAll());
            else if (toDo == 6)
                System.out.println("Did nothing.\n");
            else if (toDo == 7) {
                System.out.print(
                        "Press 1 if the pet is organic dog, press 2 if the pet is organic cat, press 3 if the pet is robotic dog, press 4 if the pet is robotic cat, press any number except 1 to 4 to change what you want to do: ");
                inputChecker();
                int typeOfPet = scanner.nextInt();
                scanner.nextLine();
                if (typeOfPet < 1 && typeOfPet > 4)
                    continue;
                System.out.print(
                        "Press 1 to specify all stats, press 0 to discontinue the rescue process or press any number except 1 and 0 to use default stats: ");
                inputChecker();
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 0) {
                    System.out.println("You have discontinued the rescue process.\n");
                    continue;
                }
                System.out.print("Please enter Pet's name: ");
                String petName = petNameChecker();
                if (input == 1)
                    promptAdditionalDetails(petName, typeOfPet);
                else {
                    System.out.println();
                    if (typeOfPet == 1)
                        pets.rescuePet(new OrganicDog(petName));
                    else if (typeOfPet == 2)
                        pets.rescuePet(new OrganicCat(petName));
                    else if (typeOfPet == 3)
                        pets.rescuePet(new RoboticDog(petName));
                    else
                        pets.rescuePet(new RoboticCat(petName));
                }
            } else if (toDo == 8) {
                promptAdoptPet();
                adoptionChecker();
            } else if (toDo == 9) {
                System.out.println(pets.walkAllDogs());
            } else if (toDo == 10) {
                System.out.println(pets.cleanAllCages());
            } else if (toDo == 11) {
                System.out.println(OrganicCat.cleanLitterBox() + "\n");
            } else if (toDo == 12) {
                System.out.println(pets.performMaintenanceAll());
            } else if (toDo == 13) {
                System.out.println(pets.addOilAll());
            } else {
                System.out.println("The game has been closed!");
                break;
            }
            if (pets.getAllPets().isEmpty()) {
                System.out.println("Congratulations! All pets have been adopted.");
                break;
            }
            pets.tickAll();
            System.out.println(pets.performPriorityNeedAll());
        }
        System.out.println(pets.displayMessage());
        System.out.println(pets.displayPet());
        scanner.close();
    }

    private static void inputChecker() {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            System.out.print("> ");
            scanner.next();
        }
    }

    private static String petNameChecker() {
        while (true) {
            String name = scanner.nextLine();
            String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            if (!pets.hasPetName(formattedName))
                return formattedName;
            System.out.print("Pet name already exist! Please enter a different name: ");
        }
    }

    private static void adoptionChecker() {
        while (true) {
            String name = scanner.nextLine();
            String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            if (pets.hasPetName(formattedName)) {
                pets.adoptPet(formattedName);
                System.out.println("You have adopted " + formattedName + "\n");
                break;
            } else if (formattedName.equalsIgnoreCase("0")) {
                System.out.println("You discontinued the adoption process.\n");
                break;
            }
            System.out.print("Pet name you entered does not exist! Please type it correctly: ");
        }
    }

    private static void playSinglePet() {
        while (true) {
            System.out.print("Enter name of the organic pet you want to play with: ");
            String petName = scanner.nextLine();
            String formattedName = petName.substring(0, 1).toUpperCase()
                    + petName.substring(1).toLowerCase();
            if (pets.hasPetName(formattedName)) {
                System.out.println(pets.playPet(formattedName));
                break;
            } else {
                System.out.println("Entered pet name does not exist!");
            }
        }
    }

    private static void initialPets() {
        pets.rescuePet(new OrganicDog("Mali"));
        pets.rescuePet(new OrganicCat("Kupa"));
        pets.rescuePet(new RoboticDog("Robodog"));
        pets.rescuePet(new RoboticCat("Robocat"));
    }

    private static void promptGameMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Give food to organic pets");
        System.out.println("2. Give water to organic pets");
        System.out.println("3. Make organic pets rest");
        System.out.println("4. Play with organic pets");
        System.out.println("5. Cure organic pets");
        System.out.println("6. Do nothing");
        System.out.println("7. Rescue a pet");
        System.out.println("8. Adopt a pet");
        System.out.println("9. Walk all dogs");
        System.out.println("10. Clean organic dogs cages");
        System.out.println("11. Clean the organic cats shelter litterbox");
        System.out.println("12. Perform maintenance to all robotic pets");
        System.out.println("13. Oil all robotic pets");
        System.out.println("Enter any number except 1 to 13 to quit the game.");
        System.out.println();
        System.out.print("> ");
    }

    private static void promptFoodOptions() {
        System.out.println("Choose food you want to feed to the organic pets.");
        System.out.println("1. Pet food");
        System.out.println("2. Treats");
        System.out.println("3. Left-overs");
        System.out.println("Press any number except 1 to 3 to change what you want to do.");
        System.out.println();
        System.out.print("> ");
    }

    private static void promptAdditionalDetails(String petName, int typeOfPet) {
        System.out.print("Please enter organic pet's happiness level (any number from 0 to 99): ");
        inputChecker();
        int happiness = scanner.nextInt();
        if (typeOfPet == 1 || typeOfPet == 2) {
            System.out.print("Please enter organic pet's hunger level (any number from 0 to 99): ");
            inputChecker();
            int hunger = scanner.nextInt();
            System.out.print("Please enter organic pet's thirst level (any number from 0 to 99): ");
            inputChecker();
            int thirst = scanner.nextInt();
            System.out.print("Please enter organic pet's tiredness level (any number from 0 to 99): ");
            inputChecker();
            int tiredness = scanner.nextInt();
            System.out.print("Please enter organic pet's boredom level (any number from 0 to 99): ");
            inputChecker();
            int boredom = scanner.nextInt();
            System.out.print("Please enter organic pet's sickness level (any number from 0 to 99): ");
            inputChecker();
            int sickness = scanner.nextInt();
            System.out.println();
            if (typeOfPet == 1)
                pets.rescuePet(new OrganicDog(petName, happiness, hunger, thirst,
                        tiredness, boredom, sickness));
            else
                pets.rescuePet(new OrganicCat(petName, happiness, hunger, thirst,
                        tiredness, boredom, sickness));
        } else {
            System.out.print("Please enter Robotic pet's oil level (any number from 0 to 99): ");
            inputChecker();
            int oilLevel = scanner.nextInt();
            System.out.print("Please enter Robotic pet's maintenance level (any number from 0 to 99): ");
            inputChecker();
            int maintenance = scanner.nextInt();
            System.out.println();
            if (typeOfPet == 3)
                pets.rescuePet(new RoboticDog(petName, happiness, oilLevel, maintenance));
            else
                pets.rescuePet(new RoboticCat(petName, happiness, oilLevel, maintenance));
        }
    }

    private static void promptAdoptPet() {
        for (VirtualPet pet : pets.getAllPets()) {
            System.out.println("Pet name: " + pet.getName() + ", Pet description: " + pet.getDescription());
        }
        System.out.println();
        System.out.print(
                "Please enter the name of the pet you want to adopt or press 0 to exit adoption process: ");
        scanner.nextLine();
    }
}
