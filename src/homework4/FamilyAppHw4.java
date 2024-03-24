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

        Pet blackDoe = new Pet("Husky", "Black");


        Family famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
        famOne.addChild(mikeDoe);
        System.out.println(famOne);
        System.out.println(janeDoe);
        System.out.println(blackDoe);

        Human[] famOneChild = famOne.getChildren();
        for (int i = 0; i < famOneChild.length; i++) {
            System.out.println(famOneChild[i]);
        }


        Family famTwo = new Family(
                new Human("Arn", "Wag", 1990),
                new Human("Mary", "Me", 1995)
        );

        System.out.printf("family two %s", famTwo);
    }
}
