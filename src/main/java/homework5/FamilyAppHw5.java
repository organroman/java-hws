package homework5;

public class FamilyAppHw5 {
    public static void main(String[] args) {
        String[][] scheduleJohn = {
                {DayOfWeek.FRIDAY.name(), "task1"}
        };

        Human johnDoe = new Human();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setYear(1985);
        johnDoe.setIq(80);
        johnDoe.setSchedule(scheduleJohn);
        System.out.println(johnDoe);

        Human janeDoe = new Human("Jane", "Doe", 1987);
        Pet blackDoe = new Pet(Animal.DOG, "Black");
        Human mikeDoe = new Human();
        mikeDoe.setName("Mike");
        mikeDoe.setSurname("Doe");
        mikeDoe.setYear(2005);

        Family famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
//        famOne.addChild(mikeDoe);
        System.out.println(famOne);

        Human[] famOneChild = famOne.getChildren();
        for (int i = 0; i < famOneChild.length; i++) {
            System.out.println("fam one child: " + famOneChild[i]);
        }



//        for (int i = 0; i < 500000 ; i++) {
//            String name = "Jane" + i;
//            String surName = "Doe" + i;
//            int year = 1980;
//
//            Human human = new Human(name, surName, year);
//        }

    }
}
