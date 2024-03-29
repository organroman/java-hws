package homework6;

public class FamilyAppHw6 {
    public static void main(String[] args) {

        Pet pet = new Fish("Bunny");
        System.out.println(pet);

        Pet pet1 = new Dog("Dog");
        System.out.println(pet1);

        Man johnDoe = new Man();
        johnDoe.setName("John");
        johnDoe.setSurname("Doe");
        johnDoe.repairCar();

        Woman janeDoe = new Woman("Jane", "Doe", 1987);
        Dog blackDoe = new Dog("Black");
        blackDoe.foul();

        Family famOne = new Family(janeDoe, johnDoe);
        famOne.setPet(blackDoe);
        janeDoe.greetPet();
        janeDoe.makeUp();

    }
}
