package homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FamilyService {
    private final FamilyDao familyDao;

//    public FamilyService() {
//        familyDao = new CollectionFamilyDao(new ArrayList<>());
//    }
public FamilyService(FamilyDao familyDao) {
   this.familyDao = familyDao;
}

    public ArrayList<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        ArrayList<Family> families = familyDao.getAllFamilies();
        record Pair(int idx, Family family) {
        }
        ;
        Map<Integer, List<Family>> allFamilies = IntStream.range(0, families.size())
                .mapToObj(idx -> new Pair(idx, families.get(idx)))
                .collect(
                        Collectors.groupingBy(
                                p -> p.idx,
                                Collectors.mapping(
                                        p -> p.family,
                                        Collectors.toList())
                        )
                );
        allFamilies.forEach((k, v) -> System.out.printf("%s -> %s\n", k, v));
    }

    public List<Family> getFamiliesBiggerThan(int familyMembersNum) {
        ArrayList<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.countFamily() > familyMembersNum).toList();
    }

    public List<Family> getFamiliesLessThan(int familyMembersNum) {
        ArrayList<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.countFamily() < familyMembersNum).toList();
    }

    public int countFamiliesWithMemberNumber(int familyMembersNum) {
        ArrayList<Family> families = familyDao.getAllFamilies();
        return families.stream().filter(family -> family.countFamily() == familyMembersNum).toList().size();
    }

    public void createNewFamily(Human father, Human mother) {
        Family newFamily = new Family(mother, father);
        familyDao.saveFamily(newFamily);
    }

    public void deleteFamilyByIndex(int idx) {
        familyDao.deleteFamily(idx);
    }

    public Family bornChild(Family family, String manName, String womanName) {
        family.bornChild(manName, womanName);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human human) {
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        List<Family> families = familyDao.getAllFamilies();
        families.forEach(family -> {
            List<Human> children = family.getChildren();
            children.forEach(child -> {
                if (child.getYear() > age) {
                    family.deleteChild(child);
                    familyDao.saveFamily(family);
                }
            });
        });
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int idx) {
        return familyDao.getFamilyByIndex(idx);
    }

    public Set<Pet> getPets(int familyIdx) {
        Family family = familyDao.getFamilyByIndex(familyIdx);
        return family.getPets();
    }

    public void addPet(int familyIdx, Pet pet) {
        Family family = familyDao.getFamilyByIndex(familyIdx);
        Set<Pet> pets = family.getPets();
        pets.add(pet);
        familyDao.saveFamily(family);
    }

}
