package homework11;

import java.util.ArrayList;


public interface FamilyDao {

    ArrayList<Family> getAllFamilies();

    Family getFamilyByIndex(int idx);

    boolean deleteFamily(int idx);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);

}
