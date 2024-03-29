package homework6;

public class RoboCat extends Pet{
    public RoboCat(String nickname) {
        super(nickname);
        this.species = Species.ROBO_CAT;
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.ROBO_CAT;
    }

    public RoboCat() {
        this.species = Species.ROBO_CAT;
    }

    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s. Я скучив", super.getNickname());

    }
}
