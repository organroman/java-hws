package homework8;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(String nickname) {
        super(nickname);
        this.species = Species.ROBO_CAT;
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
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
