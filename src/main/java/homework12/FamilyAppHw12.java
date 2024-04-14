package homework12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyAppHw12 {
    static FamilyService familyService = new FamilyService(new CollectionFamilyDao(new ArrayList<>(), "happyFamily.bin"));
    static FamilyController familyController = new FamilyController(familyService);

    static String showTheListOfCommands() {
        StringBuilder commands = new StringBuilder();
        commands.append("- 1. Заповнити тестовими даними (автоматом створити кілька сімей та зберегти їх у базі)\n")
                .append("- 2. Відобразити весь список сімей (відображає список усіх сімей з індексацією, що починається з 1)\n")
                .append("- 3. Відобразити список сімей, де кількість людей більша за задану\n")
                .append("- 4. Відобразити список сімей, де кількість людей менша за задану\n")
                .append("- 5. Підрахувати кількість сімей, де кількість членів дорівнює\n")
                .append("- 6. Створити нову родину\n")
                .append("- 7. Видалити сім'ю за індексом сім'ї у загальному списку\n")
                .append("- 8. Редагувати сім'ю за індексом сім'ї у загальному списку\n")
                .append("- 9. Видалити всіх дітей старше віку (у всіх сім'ях видаляються діти старше зазначеного віку - вважатимемо, що вони виросли)\n")
                .append("- 10. Зберегти у файл. \n")
                .append("- 11. Завантажити із файлу. )\n");
        return commands.toString();
    }

    static String showTheSubListOfEditFamilyCommands() {
        StringBuilder commands = new StringBuilder();
        commands.append("- 1. Народити дитину\n")
                .append("- 2. Усиновити дитину\n")
                .append("- 3. Повернутися до головного меню");
        return commands.toString();
    }

    static void fillWithTestData() throws IOException {
        // ------- FAMILY ONE
        Man johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setIq(100);
        johnDoe.setSchedule(Map.of(DayOfWeek.MONDAY, "fitness", DayOfWeek.TUESDAY, "library"));
        Woman janeDoe = new Woman("Jane", "Doe", "24/01/1987");
        janeDoe.setIq(90);

        // --- pets
        Dog blackDoe = new Dog("Black");
        blackDoe.addHabits("play");
        blackDoe.addHabits("eat");
        DomesticCat kittyDoe = new DomesticCat("Kitty");

        // ------- FAMILY TWO
        Woman evaSmith = new Woman("Eva", "Smith", "24/01/1990");
        Man johnSmith = new Man("John", "Smith", "24/01/1987");
        Fish swimmingBeast = new Fish("Ariel");

        // ------- FAMILY THREE
        Woman gretaBin = new Woman("Greta", "Bin", "24/01/1987");
        Man sherlockBin = new Man("Sherlock", "Bin", "24/01/1987");
        RoboCat robicBin = new RoboCat("Robic");
        Man someMan = new Man();
        someMan.setName("Ivan");
        someMan.setBirthday("20/10/2000");
        someMan.setIq(65);

        try {
            familyController.createNewFamily(johnDoe, janeDoe);
            Family famOne = familyController.getFamilyById(0);
            familyController.bornChild(famOne, "Mike", "Dana");
            familyController.bornChild(famOne, "Michel", "Diana");
            familyController.addPet(0, kittyDoe);
            familyController.addPet(0, blackDoe);

            familyController.createNewFamily(johnSmith, evaSmith);
            Family famTwo = familyController.getFamilyById(1);
            familyController.addPet(1, swimmingBeast);
            familyController.bornChild(famTwo, "Will", "Gal");

            familyController.createNewFamily(sherlockBin, gretaBin);
            familyController.addPet(2, robicBin);
            Family famThree = familyController.getFamilyById(2);
            familyController.adoptChild(famThree, someMan);

            System.out.println("Families have been created\n");
//            familyController.displayAllFamilies();
        } catch (Exception x) {
            System.out.println("Error during fill test data with families\n");
        }

    }

    static void showAllFamilies() throws IOException {
        List<Family> families = familyController.getAllFamilies();
        record Pair(int idx, String family) {
        }
        ;
        if (families.size() == 0) {
            System.out.println("The list of families is empty\n");
            return;
        }

        try {
            Map<Integer, String> allFamilies = IntStream.range(0, families.size())
                    .mapToObj(idx -> new Pair(idx, families.get(idx).prettyFormat()))
                    .collect(
                            Collectors.toMap(
                                    Pair::idx,
                                    Pair::family

                            )

                    );
            allFamilies.forEach((idx, family) -> System.out.printf("%d -> %s%n", idx + 1, family));
            System.out.println();
        } catch (Exception x) {
//            x.printStackTrace();
            System.out.println("Sorry, something went wrong with showing families\n");
        }
    }

    static Integer getAndValidateNumber(String message) {
        Scanner scanner = new Scanner(System.in);
        String userEnter;
        System.out.print(message);
        do {
            userEnter = scanner.next();
            if (!userEnter.matches("-?(0|[1-9]\\d*)")) {
                System.out.print("It's not a valid number. Enter again: ");
            }
        } while (!userEnter.matches("-?(0|[1-9]\\d*)"));
        return Integer.parseInt(userEnter);
    }

    static void showFamiliesWithMembersMoreThan() {
        int userNumber = getAndValidateNumber("Enter the number of family members: ");
        List<Family> families = familyController.getFamiliesBiggerThan(userNumber);

        if (families.isEmpty()) {
            System.out.printf("Sorry, there is no families with members more than %s\n", userNumber);
            return;
        }
        System.out.printf("Families with members more than %s:\n", userNumber);
        families.forEach(family -> System.out.println(family.prettyFormat()));
    }

    static void showFamiliesWithMembersLessThan() {
        int userNumber = getAndValidateNumber("Enter the number of family members: ");
        List<Family> families = familyController.getFamiliesLessThan(userNumber);

        if (families.isEmpty()) {
            System.out.printf("Sorry, there is no families with members less than %s\n", userNumber);
            return;
        }
        System.out.printf("Families with members less than %s:\n", userNumber);
        families.forEach(family -> System.out.println(family.prettyFormat()));
    }

    static void showNumberOfFamiliesWithMembersEqualsTo() {
        int userNumber = getAndValidateNumber("Enter the number of family members: ");
        int familiesCount = familyController.countFamiliesWithMemberNumber(userNumber);

        if (familiesCount == 0) {
            System.out.printf("Sorry, there is no families with members number equals to %s\n", userNumber);
            return;
        }
        System.out.printf("There are '%d' Families with members equals to %s:\n", familiesCount, userNumber);
    }

    public static void createNewFamily() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter mother name:");
        String motherName = scanner.next();
        System.out.print("Enter mother surname:");
        String motherSurname = scanner.next();
        System.out.print("Enter mother birthday year - YYYY:");
        String motherBirthdayYear = scanner.next();
        System.out.print("Enter mother birthday month - MM:");
        String motherBirthdayMonth = scanner.next();
        System.out.print("Enter mother birthday day - DD:");
        String motherBirthdayDay = scanner.next();
        System.out.print("Enter mother iq:");
        String motherIq = scanner.next();

        String motherBirthday = motherBirthdayDay + "/" + motherBirthdayMonth + "/" + motherBirthdayYear;

        Woman mother = new Woman(motherName, motherSurname, motherBirthday);
        mother.setIq(Integer.parseInt(motherIq));

        System.out.print("Enter father name:");
        String fatherName = scanner.next();
        System.out.print("Enter father surname:");
        String fatherSurname = scanner.next();
        System.out.print("Enter father birthday year - YYYY:");
        String fatherBirthdayYear = scanner.next();
        System.out.print("Enter father birthday month - MM:");
        String fatherBirthdayMonth = scanner.next();
        System.out.print("Enter father birthday day - DD:");
        String fatherBirthdayDay = scanner.next();
        System.out.print("Enter father iq:");
        String fatherIq = scanner.next();

        String fatherBirthday = fatherBirthdayDay + "/" + fatherBirthdayMonth + "/" + fatherBirthdayYear;

        Man father = new Man(fatherName, fatherSurname, fatherBirthday);
        father.setIq(Integer.parseInt(fatherIq));

        try {
            familyController.createNewFamily(father, mother);
            System.out.printf("New family between %s and %s has been created\n", motherName, fatherName);
        } catch (Exception x) {
            System.out.println("Something went wrong during creating family");
        }

    }

    static void deleteFamily() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the family number you would like to delete:");
        String idxFromUser = scanner.next();

        try {
            familyController.deleteFamilyByIndex(Integer.parseInt(idxFromUser) - 1);
            System.out.printf("Family with number %s has been deleted\n", idxFromUser);
        } catch (Exception x) {
            System.out.println("Sorry the family doesn't exist ");
        }

    }

    static void bornChild() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of family: ");
        String familyNum = scanner.next();
        int familyIdx = Integer.parseInt(familyNum) - 1;

        try {
            Family family = familyController.getFamilyById(familyIdx);
            System.out.print("Enter the name of child if it will be a boy: ");
            String boyName = scanner.next();
            System.out.print("Enter the name of child if it will be a girl: ");
            String girlName = scanner.next();
            familyController.bornChild(family, boyName, girlName);
            System.out.printf("Congratulations with new family member: \n %s", family.prettyFormat());
            System.out.println();
        } catch (Exception x) {
            System.out.println("Something went wrong during born child");
        }
    }

    public static void adoptChild() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of family: ");
        String familyNum = scanner.next();
        int familyIdx = Integer.parseInt(familyNum) - 1;

        try {
            Family family = familyController.getFamilyById(familyIdx);
            System.out.print("Enter the name: ");
            String childName = scanner.next();
            System.out.print("Enter the birthday ('dd/mm/yyyy'): ");
            String childBirthday = scanner.next();
            System.out.print("Enter the iq: ");
            String childIq = scanner.next();
            System.out.print("Enter sex (male/female): ");
            String childSex = scanner.next();
            Human child;
            if (childSex.equalsIgnoreCase("male")) {
                child = new Man();
            } else child = new Woman();

            child.setName(childName);
            child.setBirthday(childBirthday);
            child.setIq(Integer.parseInt(childIq));

            familyController.adoptChild(family, child);
            System.out.printf("Congratulations you adopted:  %s\n", child.prettyFormat());
        } catch (Exception x) {
            System.out.println("Something went wrong during adopting child");
        }
    }

    static void deleteAllChildrenOlderThan() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the age of children you would like to delete: ");
        String age = scanner.next();

        try {
            familyController.deleteAllChildrenOlderThen(Integer.parseInt(age));
            System.out.printf("Children older than %s years were deleted!\n", age);
        } catch (Exception ex) {
            System.out.println("Something went wrong during deleting children");
        }
    }

    static void handleMenu(int menuNumber) throws IOException {
        switch (menuNumber) {
            case 1 -> fillWithTestData();
            case 2 -> showAllFamilies();
            case 3 -> showFamiliesWithMembersMoreThan();
            case 4 -> showFamiliesWithMembersLessThan();
            case 5 -> showNumberOfFamiliesWithMembersEqualsTo();
            case 6 -> createNewFamily();
            case 7 -> deleteFamily();
            case 8 -> handleSubMenu();
            case 9 -> deleteAllChildrenOlderThan();
            case 10 -> saveData();
            case 11 -> loadData();
            default -> showTheListOfCommands();
        }

    }

    static void saveData() throws IOException {
        try {
            familyController.saveData();
            System.out.println("Data has been saved!\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong while saving data\n");
        }
    }

    static void loadData() throws IOException {
        try {
            familyController.loadData();
            System.out.println("Data has been loaded!\n");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong while loading data\n");
        }
    }

    static void handleSubMenu() throws IOException {
        System.out.println(showTheSubListOfEditFamilyCommands());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of command from the list: ");
        int subMenuNum = scanner.nextInt();
        switch (subMenuNum) {
            case 1 -> bornChild();
            case 2 -> adoptChild();
            case 3 -> showTheListOfCommands();
            default -> handleSubMenu();
        }
    }

    static void runApp() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userValue;
        System.out.println(showTheListOfCommands());
        do {

            System.out.print("Enter the number of command from the list: ");
            userValue = scanner.next();
            System.out.println();
            if (userValue.equals("exit")) {
                System.out.println("Program is closed!");
            } else {
                handleMenu(Integer.parseInt(userValue));
                System.out.println(showTheListOfCommands());

            }


        } while (!userValue.equals("exit"));


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        runApp();
    }

}
