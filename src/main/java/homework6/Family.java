package homework6;

import java.util.Objects;


public class Family {
    Human father;
    Human mother;
    Human[] children;
    Pet pet;

    public Family(Human mother, Human father) {
        this.father = father;
        this.mother = mother;
        father.setFamily(this);
        mother.setFamily(this);
        this.children = new Human[0];
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        child.setFamily(this);
        Human[] newChildren = new Human[this.children.length + 1];
        System.arraycopy(this.children, 0, newChildren, 0, this.children.length);
        newChildren[newChildren.length - 1] = child;
        setChildren(newChildren);
    }

    public boolean deleteChild(int idx) {
        if (idx < 0 || idx >= this.children.length) {
            return false;
        }
        Human[] newChildren = new Human[this.children.length - 1];
        System.arraycopy(this.children, 0, newChildren, 0, idx);
        System.arraycopy(this.children, idx + 1, newChildren, idx, this.children.length - idx - 1);
        setChildren(newChildren);
        return true;
    }

    public boolean deleteChild(Human child) {
        int idx = -1;

        for (int i = 0; i < this.children.length; i++) {
            if (this.children[i].equals(child)) {
                idx = i;
            }
        }
        if (idx == -1) {
            return false;
        }

        Human[] newChildren = new Human[this.children.length - 1];
        System.arraycopy(this.children, 0, newChildren, 0, idx);
        System.arraycopy(this.children, idx + 1, newChildren, idx, this.children.length - idx - 1);
        setChildren(newChildren);
        return true;
    }

    public int CountFamily() {
        return 2 + this.children.length;

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

        for (int i = 0; i < this.children.length; i++) {
            childrenStr
                    .append(children[i].getName())
                    .append(" ")
                    .append(children[i].getSurname());

            if (i < this.children.length - 1) childrenStr.append(", ");


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

        if (pet != null) {
            outcome.append(", pet =")
                    .append(this.getPet().toString());
        }
        outcome.append("}");


        return outcome.toString();
    }
}
