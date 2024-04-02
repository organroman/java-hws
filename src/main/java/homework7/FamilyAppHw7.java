package homework7;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FamilyAppHw7 {
    public static void main(String[] args) {

        Pet pet = new Fish("Bunny");
//        System.out.println(pet);

        Pet pet1 = new Dog("Dog");
//        System.out.println(pet1);

        Man johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.setIq(100);

//        johnDoe.repairCar();
        johnDoe.setSchedule(Map.of(DayOfWeek.MONDAY, "Write a novel", DayOfWeek.TUESDAY, "Go to gym"));


//        System.out.println(johnDoe);

        Set<Pet> famOnePets = new HashSet<>();
        Woman janeDoe = new Woman("Jane", "Doe", 1987);
        janeDoe.setIq(90);
        Dog blackDoe = new Dog("Black");
        blackDoe.foul();
        blackDoe.addHabits("play");
        blackDoe.addHabits("eat");

        famOnePets.add(blackDoe);
        famOnePets.add(pet);

        Family famOne = new Family(janeDoe, johnDoe);
        famOne.setPets( famOnePets);
//        janeDoe.greetPet();
        johnDoe.greetPet();
//        janeDoe.makeUp();

        famOne.bornChild();
//        System.out.println(famOne);

//        Human child = famOne.bornChild();
//        System.out.println(child);

    }
}
