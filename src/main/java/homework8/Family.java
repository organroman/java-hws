package homework8;

import java.util.*;


public class Family implements HumanCreator {
    Human father;
    Human mother;
    ArrayList<Human> children;
    Set<Pet> pets;


    public Family(Human mother, Human father) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();

    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }


    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void addChild(Human child) {
        child.setSurname(father.getSurname());
        child.setFamily(this);
        this.children.add(child);
    }

    public boolean deleteChild(int idx) {
        if (idx < 0 || idx >= this.children.size()) {
            return false;
        }

        this.children.remove(idx);
        return true;
    }

    public boolean deleteChild(Human child) {
        if (!this.children.contains(child)) {
            return false;
        }
        this.children.remove(child);
        return true;
    }

    public int countFamily() {
        return 2 + this.children.size();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) && Objects.equals(mother, family.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(father, mother);
    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder();
        StringBuilder childrenStr = new StringBuilder("[");

        for (int i = 0; i < this.children.size(); i++) {
            childrenStr
                    .append(children.get(i).getName())
                    .append(" ")
                    .append(children.get(i).getSurname());

            if (i < this.children.size() - 1) childrenStr.append(", ");


        }
        childrenStr.append("]");

        outcome
                .append("Family{")
                .append("father =")
                .append(this.father.getName())
                .append(" ")
                .append(this.father.getSurname())
                .append(", mother =")
                .append(this.mother.getName())
                .append(" ")
                .append(this.mother.getSurname())
                .append(", children =")
                .append(childrenStr);

        if (pets != null) {
            outcome.append(", pet =[");

            for (Pet pet : this.pets) {
                outcome.append(pet.toString())
                        .append(" ,");
            }
            outcome.append(("]"));
        }

        outcome.append("}");


        return outcome.toString();

    }

    @Override
    public Human bornChild(String manName, String womanName) {
        Random random = new Random();

        int iq = 0;
        String name;

        boolean isMale = random.nextBoolean();

        if (isMale) {
            name = manName;
        } else name = womanName;

        if (this.father.getIq() > 0 && this.mother.getIq() > 0) {
            iq = (this.father.getIq() + this.mother.getIq()) / 2;
        }
        Human child;

        if (isMale) {
            child = new Man();
        } else child = new Woman();

        child.setName(name);
        child.setSurname(this.father.getSurname());
        child.setIq(iq);
        child.setFamily(this);

        addChild(child);

        return child;
    }
}
