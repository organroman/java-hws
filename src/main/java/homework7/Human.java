package homework7;

import java.util.Map;

import static homework4.Pet.arrayToString;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(String name, String surname, int year, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq >= 0 && iq <= 100) this.iq = iq;
    }


    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule( Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {

        for(Pet pet: this.family.getPets() ){
            System.out.printf("Привіт, %s! \n", pet.getNickname());

        }
    }

    public void describePets() {
        StringBuilder outcome = new StringBuilder("У мене є");
        String trickLevelStr;
        for(Pet pet:  this.family.pets ){
            if (pet.getTrickLevel() >= 50) {
                trickLevelStr = "дуже хитрий";
            } else trickLevelStr = "майже не хитрий";

            outcome.append(pet.getSpecies()).append(" їй ").append(pet.getAge()).append("він").append(trickLevelStr);

        }


        System.out.println(outcome);
    }

        static String MapToStr(Map<DayOfWeek, String> xss) {
        StringBuilder outcome = new StringBuilder("[");

        for (Map.Entry<DayOfWeek, String> entry : xss.entrySet()) {
            outcome
                    .append("  ")
                    .append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(",");

        }

        return outcome.append("]").toString();
    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();
        outcome
                .append("Human{name=")
                .append(this.name)
                .append(", surname=")
                .append(this.surname)
                .append(", year=")
                .append(this.year)
                .append(", iq=")
                .append(this.iq);

        if (schedule != null) {
            outcome.append(", schedule=")
                    .append(MapToStr(this.schedule));
        }


        outcome.append("}");


        return outcome.toString();
    }
}
