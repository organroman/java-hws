package homework5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family famOne;
    private Human mikeDoe;

    private Human evaDoe;

    @BeforeEach
    public void setUp() {
        String[][] scheduleJohn = {
                {DayOfWeek.FRIDAY.name(), "task1"}
        };

        Human johnDoe = new Human();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setYear(1985);
        johnDoe.setIq(80);
        johnDoe.setSchedule(scheduleJohn);

        Human janeDoe = new Human("Jane", "Doe", 1987);
        Pet blackDoe = new Pet(Animal.DOG, "Black");
        mikeDoe = new Human();
        mikeDoe.setName("Mike");
        mikeDoe.setSurname("Doe");
        mikeDoe.setYear(2005);

        famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
        famOne.addChild(mikeDoe);

        evaDoe = new Human("Eva", "Doe", 2020);
    }

    @Test
    public void testToString() {
        String expected = "Family{father =John Doe, mother =Jane Doe, children =[Mike Doe], pet =DOG{nickname=Black, age=0, trickLevel=0, legs=4, canFly=false, hasFur=true}}";
        String real = famOne.toString();
        assertEquals(expected, real);
    }

    @Test
    public void testDeleteChildObjIsDeleted() {
        famOne.deleteChild(mikeDoe);
        Human[] childrenReal = famOne.getChildren();

        for (Human child : childrenReal) {
            assertNotEquals(mikeDoe, child);
        }
    }

    @Test
    public void testDeleteChildObjIsNotDeleted() {
        Human[] childrenReal = famOne.getChildren();

        famOne.deleteChild(evaDoe);
        for (Human child : childrenReal) {
            assertEquals(mikeDoe, child);
        }
    }

    @Test
    public void testDeleteChildIdxIsNotDeleted() {
        boolean real = famOne.deleteChild(3);
        boolean expected = false;

        assertEquals(real, expected);
    }

    @Test
    public void testDeleteChildIdxIstDeleted() {
        boolean real = famOne.deleteChild(0);
        boolean expected = true;

        assertEquals(real, expected);
    }

    @Test
    public void testAddChild() {
        famOne.addChild(evaDoe);
        int realChildrenLength = famOne.getChildren().length;
        int expectedChildrenLength = 2;

        assertEquals(realChildrenLength, expectedChildrenLength);

//        Human[] realChildren = famOne.getChildren();
        boolean evaAdded = false;
        for (Human child: famOne.getChildren()) {
            if (child.equals(evaDoe)) {
                evaAdded = true;
                break;
            }
        }
        assertTrue(evaAdded);
    }
    @Test
    public void countFamily() {
      int realCountFamily = famOne.CountFamily();
      int expectedCountFamily = 3;

      assertEquals(realCountFamily, expectedCountFamily);

      famOne.addChild(evaDoe);
      int realCountAfterAdding = famOne.CountFamily();

      assertEquals(realCountAfterAdding, 4);
    }
}

