package homework11;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Human {
    private String name;
    private String surname;
    private long birthday;
    private int iq;
    private Family family;
    private Map<DayOfWeek, String> schedule;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Human(String name, String surname, String birthday) {
        this.name = name;
        this.surname = surname;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localDate = LocalDate.parse(birthday, formatter).atStartOfDay();
        this.birthday = localDate.toEpochSecond(ZoneOffset.UTC) * 1000;
    }

    public Human(String name, String surname, String birthday, int iq, Human mother, Human father, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        LocalDateTime localDate = LocalDateTime.parse(birthday);
        this.birthday = localDate.toEpochSecond(ZoneOffset.UTC) * 1000;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String birthday, int iq) {
        this.name = name;
        this.surname = surname;
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localDate = LocalDate.parse(birthday, formatter).atStartOfDay();
        this.birthday = localDate.toEpochSecond(ZoneOffset.UTC) * 1000;
        this.iq = iq;
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

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime localDate = LocalDate.parse(birthday, formatter).atStartOfDay();
        this.birthday = localDate.toEpochSecond(ZoneOffset.UTC) * 1000;
    }
    public void setBirthday(LocalDate birthday) {
        Instant instant = birthday.atStartOfDay(ZoneOffset.UTC).toInstant();
           this.birthday = instant.toEpochMilli();
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

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void greetPet() {

        for (Pet pet : this.family.getPets()) {
            System.out.printf("Привіт, %s! \n", pet.getNickname());

        }
    }

    public void describePets() {
        StringBuilder outcome = new StringBuilder("У мене є");
        String trickLevelStr;
        for (Pet pet : this.family.pets) {
            if (pet.getTrickLevel() >= 50) {
                trickLevelStr = "дуже хитрий";
            } else trickLevelStr = "майже не хитрий";

            outcome.append(pet.getSpecies()).append(" їй ").append(pet.getAge()).append("він").append(trickLevelStr);

        }


        System.out.println(outcome);
    }

    public String describeAge() {
        LocalDate curDate = LocalDate.now();
        LocalDate birthDay = LocalDate.ofEpochDay(this.birthday / (24 * 60 * 60 * 1000));
        Period period = Period.between(birthDay, curDate);
        int years = period.getYears();
        ;
        int months = period.getMonths();
        int days = period.getDays();

        return String.format("%s years, %s months, %s days", years, months, days);


    }

    static String mapToStr(Map<DayOfWeek, String> xss, String openBracket, String closeBracket, String delimeter) {
        StringBuilder outcome = new StringBuilder(openBracket);
        int size = xss.size();
        int count = 0;

        for (Map.Entry<DayOfWeek, String> entry : xss.entrySet()) {
            outcome
//                    .append("  ")
                    .append(entry.getKey())
                    .append(delimeter)
                    .append(entry.getValue());
//                    .append(",");

            count++;
            if (count < size) {
                outcome.append(", ");
            }

        }

        return outcome.append(closeBracket).toString();
    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();
        outcome
                .append("Human{name=")
                .append(this.name)
                .append(", surname=")
                .append(this.surname)
                .append(", birthday=");
        LocalDateTime localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.birthday), ZoneOffset.UTC);
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        outcome.append(formattedDate)
                .append(", iq=")
                .append(this.iq);

        if (schedule != null) {
            outcome.append(", schedule=")
                    .append(mapToStr(this.schedule, "[", "]", ": "));
        }


        outcome.append("}");


        return outcome.toString();
    }

    public String prettyFormat() {
        StringBuilder outcome = new StringBuilder("{");

        LocalDateTime localDate = LocalDateTime.ofInstant(Instant.ofEpochMilli(this.birthday), ZoneOffset.UTC);
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        outcome.append("name='")
                .append(this.name)
                .append("', surname='")
                .append(this.surname)
                .append("', birthday='")
                .append(formattedDate)
                .append("', iq=")
                .append(this.iq)
                .append("', schedule=");
        if (this.schedule == null) {
            outcome.append("null");
        } else outcome.append(mapToStr(this.schedule, "{", "}", "="));
        outcome.append("},");

        return outcome.toString();
    }
}
