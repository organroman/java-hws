package homework8;

import java.util.ArrayList;

public class CollectionFamilyDao implements FamilyDao {
    private ArrayList<Family> families;

    public CollectionFamilyDao(ArrayList<Family> families) {
        this.families = families;
    }

    public ArrayList<Family> getFamilies() {
        return families;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    @Override
    public ArrayList<Family> getAllFamilies() {
        return families;
    }


    @Override
    public Family getFamilyByIndex(int idx) {
        if (idx < 0 || idx > families.size()) {
            return null;
        }
        return families.get(idx);
    }

    @Override
    public boolean deleteFamily(int idx) {
        if (idx < 0 || idx > this.families.size()) {
            return false;
        }
        this.families.remove(idx);
        return true;

    }

    public boolean deleteFamily(Family family) {
        if (!this.families.contains(family)) {
            return false;
        }
        this.families.remove(family);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (this.families.contains(family)) {
            this.families.set(families.indexOf(family), family);
        } else this.families.add(family);

    }
}
