package homework8;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, mother, father, schedule);
    }

    public Woman() {
    }

    @Override
    public void greetPet() {
        for(Pet pet: super.getFamily().getPets()) {
            System.out.printf("Привіт, %s, \n", pet.getNickname());

        }


    }
    public void makeUp() {
        System.out.println("Honey, i went to the saloon");
    }
}
