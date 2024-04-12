package homework11;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
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
        families.forEach(family -> System.out.println(family.prettyFormat()));
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
        for (Family family : families) {
            List<Human> children = family.getChildren();
            Iterator<Human> child = children.iterator();

            while (child.hasNext()) {
                Human ch = child.next();
                LocalDate birthDay = LocalDate.ofEpochDay(ch.getBirthday() / (24 * 60 * 60 * 1000));
                Period period = Period.between(birthDay, LocalDate.now());
                if (period.getYears() > age) {
                    child.remove();
                }
            }
            familyDao.saveFamily(family);
        }
    }

    public int count() {
        return familyDao.getAllFamilies().size();
    }

    public Family getFamilyById(int idx) {
        Family family = familyDao.getFamilyByIndex(idx);
//        System.out.println(family.prettyFormat());
        return family;
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
