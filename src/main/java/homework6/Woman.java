package homework6;

public final class Woman extends Human{
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, int year, int iq, Human mother, Human father, String[][] schedule) {
        super(name, surname, year, iq, mother, father, schedule);
    }

    public Woman() {
    }

    @Override
    public void greetPet() {
        super.greetPet();
        System.out.printf("Привіт, %s, \n", super.getFamily().getPet().getNickname());


    }
    public void makeUp() {
        System.out.println("Honey, i went to the saloon");
    }
}
