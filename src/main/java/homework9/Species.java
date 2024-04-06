package homework9;

public enum Species {
    DOG(4, false, true),
    RABBIT(4, false, true),
    FISH(0, false, false),
    PARROT(2, true, false),
    UNKNOWN(-1, false, false),
    DOMESTIC_CAT(4, false, true),
    ROBO_CAT(4, false, false);

    final int numberOfLegs;
    final boolean canFly;
    final boolean hasFur;

    Species(int numberOfLegs, boolean canFly, boolean hasFur) {
        this.numberOfLegs = numberOfLegs;
        this.canFly = canFly;
        this.hasFur = hasFur;
    }

}
