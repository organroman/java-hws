package homework4;

public class FamilyAppHw4 {
    public static void main(String[] args) {
        String[][] scheduleJohn = {
                {"day", "task1"}
        };

        Human johnDoe = new Human();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setYear(1985);
        johnDoe.setIq(80);
        johnDoe.setSchedule(scheduleJohn);

        Human janeDoe = new Human("Jane", "Doe", 1987);

        Human mikeDoe = new Human();
        mikeDoe.setName("Mike");
        mikeDoe.setSurname("Doe");
        mikeDoe.setYear(2005);

        Human evaDoe = new Human();
        evaDoe.setName("Eva");
        evaDoe.setSurname("Doe");
        evaDoe.setYear(2007);

        Human sharonDoe = new Human();
        sharonDoe.setName("Sharon");
        sharonDoe.setSurname("Doe");
        sharonDoe.setYear(2009);

        Human jackDoe = new Human();
        jackDoe.setName("Jack");
        jackDoe.setSurname("Doe");
        jackDoe.setYear(2009);

        Pet blackDoe = new Pet("Husky", "Black");


        Family famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
        famOne.addChild(mikeDoe);
        famOne.addChild(evaDoe);
        famOne.addChild(sharonDoe);
        famOne.addChild(jackDoe);
        System.out.println(famOne);
        System.out.println(janeDoe);
        System.out.println(blackDoe);

        Human[] famOneChild = famOne.getChildren();
        for (int i = 0; i < famOneChild.length; i++) {
            System.out.println("fam one child: " + famOneChild[i]);
        }

        famOne.deleteChild(mikeDoe);
        System.out.println("FamOne children" + famOne);

        famOne.deleteChild(2);
        System.out.println("FamOne children" + famOne);


        Family famTwo = new Family(
                new Human("Arn", "Wag", 1990),
                new Human("Mary", "Me", 1995)
        );

        System.out.printf("family two %s", famTwo);
    }
}
