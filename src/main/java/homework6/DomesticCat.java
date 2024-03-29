package homework6;

public class DomesticCat extends Pet implements CanFoul {
    public DomesticCat(String nickname) {
        super(nickname);
        this.species = Species.DOMESTIC_CAT;
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        this.species = Species.DOMESTIC_CAT;
    }

    public DomesticCat() {
        this.species = Species.DOMESTIC_CAT;
    }

    @Override
    public void respond() {
        System.out.printf("Привіт, хазяїн. Я - %s. Я скучив", super.getNickname());
    }

    @Override
    public void foul() {
        System.out.println("Привіт, хазяїн. Йди прибери");
    }
}
