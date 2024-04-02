package homework7;

import java.util.Map;

public final class Man extends Human {
    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, int year, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        super(name, surname, year, iq, mother, father, schedule);
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
