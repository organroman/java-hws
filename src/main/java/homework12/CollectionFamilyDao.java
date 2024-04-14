package homework12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family> families;
    private File file;

    public CollectionFamilyDao(ArrayList<Family> families, String filename) {
        this.families = families;
        this.file= new File(filename);
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }

    @Override
    public List<Family> getAllFamilies() {
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

    @Override
    public List<Family> loadData() throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Family> loadedFamilies = (List<Family>) ois.readObject();
            this.families.clear(); // Clear the existing list
            this.families.addAll(loadedFamilies); // Add loaded data to the list
            return loadedFamilies;

        }
    }

    @Override
    public void saveData() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this.families);
//            System.out.println("saved");
        }
    }
}
