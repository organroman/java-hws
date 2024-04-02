package homework7;

import homework5.Pet;
import homework5.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private homework7.Family famOne;
    private homework7.Human mikeDoe;

    private homework7.Human evaDoe;

    @BeforeEach
    public void setUp() {
        Map<homework7.DayOfWeek, String> scheduleJohn = Map.of(
                DayOfWeek.MONDAY, "task1");


        Man johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setYear(1985);
        johnDoe.setIq(80);
        johnDoe.setSchedule(scheduleJohn);

        Woman janeDoe = new Woman("Jane", "Doe", 1987);
        Dog blackDoe = new Dog("Black");
        mikeDoe = new homework7.Human();
        mikeDoe.setName("Mike");
        mikeDoe.setSurname("Doe");
        mikeDoe.setYear(2005);

        famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
        famOne.addChild(mikeDoe);

        evaDoe = new homework7.Human("Eva", "Doe", 2020);
    }

    @Test
    public void testToString() {
        String expected = "Family{father =John Doe, mother =Jane Doe, children =[Mike Doe], pet =DOG{nickname=Black, age=0, trickLevel=0, habits=[], legs=4, canFly=false, hasFur=true}}";
        String real = famOne.toString();
        assertEquals(expected, real);
    }

    @Test
    public void testDeleteChildObjIsDeleted() {
        famOne.deleteChild(mikeDoe);
        ArrayList<homework7.Human> childrenReal = famOne.getChildren();

        for (homework7.Human child : childrenReal) {
            assertNotEquals(mikeDoe, child);
        }
    }

    @Test
    public void testDeleteChildObjIsNotDeleted() {
//        ArrayList<Human> childrenReal = famOne.getChildren();
        ArrayList<homework7.Human> childrenReal = famOne.getChildren();

        famOne.deleteChild(evaDoe);
        for (homework7.Human child : childrenReal) {
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
        int realChildrenLength = famOne.getChildren().size();
        int expectedChildrenLength = 2;

        assertEquals(realChildrenLength, expectedChildrenLength);

//        Human[] realChildren = famOne.getChildren();
        boolean evaAdded = false;
        for (Human child : famOne.getChildren()) {
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

