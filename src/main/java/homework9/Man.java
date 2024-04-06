package homework9;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, String birthday) {
        super(name, surname, birthday);
    }

    public Man(String name, String surname, String birthday, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        super(name, surname, birthday, iq, mother, father, schedule);
    }

    public Man() {

    }

    @Override
    public void greetPet() {
        super.greetPet();
        System.out.print("Hi, pet, do you want to eat?");
    }

    public void repairCar() {
        System.out.print("Wife, i am in garage.");
    }

}
