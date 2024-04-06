package homework8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FamilyServiceTest {
    private CollectionFamilyDao familyDao = new CollectionFamilyDao(new ArrayList<>());
    private FamilyService familyService = new FamilyService(familyDao);


    private Man johnDoe;
    private Woman janeDoe;
    private Dog blackDoe;
    private Woman evaSmith;
    private Man johnSmith;

    private RoboCat robicBin;
    private Human someMan;


    @BeforeEach
    public void setUp() {

        johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setIq(100);

        janeDoe = new Woman("Jane", "Doe", 1987);
        janeDoe.setIq(90);

        blackDoe = new Dog("Black");
        blackDoe.addHabits("play");
        blackDoe.addHabits("eat");

        evaSmith = new Woman("Eva", "Smith", 1990);
        johnSmith = new Man("John", "Smith", 1988);

        robicBin = new RoboCat("Robic");

        someMan = new Human();
        someMan.setName("Noname");
    }

    @AfterEach
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void getAllFamilies() {
        List<Family> families = familyService.getAllFamilies();
        assertTrue(families.isEmpty());
    }

    @Test
    public void createNewFamily() {
        familyService.createNewFamily(janeDoe, johnDoe);
        List<Family> families = familyService.getAllFamilies();
        assertEquals(1, families.size());

    }

    @Test
    public void bornChild() {
        familyService.createNewFamily(janeDoe, johnDoe);
        List<Family> families = familyService.getAllFamilies();
        Family fam = families.get(0);
        familyService.bornChild(fam, "Boy", "Girl");
        assertEquals(1, fam.children.size());
    }

    @Test
    public void adoptChild() {
        familyService.createNewFamily(janeDoe, johnDoe);
        List<Family> families = familyService.getAllFamilies();
        Family fam = families.get(0);
        familyService.adoptChild(fam, someMan);
        assertEquals(1, fam.children.size());
    }

    @Test
    public void count() {
        familyService.createNewFamily(janeDoe, johnDoe);
        familyService.createNewFamily(evaSmith, johnSmith);
        int count = familyService.count();
        assertEquals(2,count);
    }

    @Test
    public void addPet() {
        familyService.createNewFamily(janeDoe, johnDoe);
        familyService.addPet(0, blackDoe);
        familyService.addPet(0, robicBin);
        Family fam = familyService.getFamilyById(0);
        assertEquals(2,  fam.getPets().size());
    }

    @Test
    public void deleteFamilyByIndex() {
        familyService.createNewFamily(janeDoe, johnDoe);
        familyService.deleteFamilyByIndex(0);
        assertTrue(familyService.getAllFamilies().isEmpty());
    }

}
