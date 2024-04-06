package homework8;

import java.util.*;

public class FamilyAppHw8 {
    public static void main(String[] args) {

        FamilyService familyService = new FamilyService(new CollectionFamilyDao(new ArrayList<>()));
        FamilyController familyController = new FamilyController(familyService);

// ------- FAMILY ONE
        //---- father
        Man johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setIq(100);
        // ----  mother
        Woman janeDoe = new Woman("Jane", "Doe", 1987);
        janeDoe.setIq(90);

        // --- pets
        Dog blackDoe = new Dog("Black");
        blackDoe.addHabits("play");
        blackDoe.addHabits("eat");
        DomesticCat kittyDoe = new DomesticCat("Kitty");

        familyController.createNewFamily(johnDoe, janeDoe);
//        familyController.addPet(0, blackDoe);
//        familyController.addPet(0, kittyDoe);

        // ------- FAMILY TWO
        Woman evaSmith = new Woman("Eva", "Smith", 1990);
        Man johnSmith = new Man("John", "Smith", 1988);
        Fish swimmingBeast = new Fish("Ariel");

        familyController.createNewFamily(johnSmith, evaSmith);
        familyController.displayAllFamilies();
//        familyController.addPet(1, swimmingBeast);

        // ------- FAMILY THREE
        Woman gretaBin = new Woman("Greta", "Bin", 1990);
        Man sherlockBin = new Man("Sherlock", "Bin", 1988);
        RoboCat robicBin = new RoboCat("Robic");

        Human someMan = new Human();
        someMan.setName("Noname");

        familyController.createNewFamily(gretaBin, sherlockBin);
        familyController.addPet(2, robicBin);

        Family familyThree = familyController.getFamilyById(2);
        familyController.adoptChild(familyThree, someMan);

        Family familyOne = familyController.getFamilyById(0);
        familyController.bornChild(familyOne, "Bill", "Julia");

        familyController.displayAllFamilies();
        List<Family> moreThan2 = familyController.getFamiliesBiggerThan(2);
        System.out.printf("Families with more than 2 members: %s", moreThan2);
        System.out.println();

        List<Family> lessThan3 = familyController.getFamiliesLessThan(3);
        System.out.printf("Families with less than 3 members: %s", lessThan3);

        System.out.println();
        System.out.printf("Families with 2 members: %s", familyController.countFamiliesWithMemberNumber(2));

        familyController.deleteFamilyByIndex(2);
        familyController.displayAllFamilies();

        familyController.deleteAllChildrenOlderThen(2000);
        familyController.displayAllFamilies();

        System.out.printf("Total number of families: %s", familyController.count());
        System.out.println();
        System.out.printf("Pets of family: %s", familyController.getPets(0));
    }
}
