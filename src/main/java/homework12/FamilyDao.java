package homework12;

import java.io.IOException;
import java.util.List;


public interface FamilyDao {

    List<Family> getAllFamilies();

    Family getFamilyByIndex(int idx);

    boolean deleteFamily(int idx);

    boolean deleteFamily(Family family);

    void saveFamily(Family family);

    List<Family> loadData() throws IOException, ClassNotFoundException;

    void saveData() throws IOException;

}
