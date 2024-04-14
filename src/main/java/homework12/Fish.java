package homework12;

import java.util.Set;

public class Fish extends Pet {
    public Fish(String nickname) {
        super(nickname);
        this.species = Species.FISH;
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.FISH;
    }

    public Fish() {
        this.species = Species.FISH;
    }

    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s. Я не розмовляю", super.getNickname());
    }
}
