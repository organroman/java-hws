package homework12;

import java.io.Serializable;
import java.util.Map;

public final class Woman extends Human implements Serializable {
    public Woman(String name, String surname, String birthday) {
        super(name, surname, birthday);
    }

    public Woman(String name, String surname, String birthday, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthday, iq, mother, father, schedule);
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
