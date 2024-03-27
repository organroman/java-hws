package homework5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyTest {
    @Test
    public void  testToString() {
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
        famOne.addChild(mikeDoe);

        String expected = "Family{father =John Doe, mother =Jane Doe, children =[Mike Doe], pet =DOG{nickname=Black, age=0, trickLevel=0, legs=4, canFly=false, hasFur=true}}";
        String real = famOne.toString();

        assertEquals(expected, real);
    }
}
