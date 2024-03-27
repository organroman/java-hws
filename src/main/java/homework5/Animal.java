package homework5;

public enum Animal {
    CAT(4, false, true),
    DOG(4, false, true),
    RABBIT(4, false, true),
    FISH(0, false, false),
    PARROT(2, true, false);

    final int numberOfLegs;
    final boolean canFly;
    final boolean hasFur;

    Animal(int numberOfLegs, boolean canFly, boolean hasFur) {
        this.numberOfLegs = numberOfLegs;
        this.canFly = canFly;
        this.hasFur = hasFur;
    }
}
