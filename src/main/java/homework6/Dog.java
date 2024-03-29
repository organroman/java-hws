package homework6;

public class Dog extends Pet implements CanFoul {
    public Dog(String nickname) {
        super(nickname);
        this.species = Species.DOG;
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOG;
    }

    public Dog() {
        this.species = Species.DOG;
    }

    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s. Я скучив", super.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }
}
