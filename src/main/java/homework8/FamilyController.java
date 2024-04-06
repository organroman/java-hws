package homework8;

import java.util.List;
import java.util.Set;


public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
      return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int familyMembersNum) {
        return familyService.getFamiliesBiggerThan(familyMembersNum);
    }

    public List<Family> getFamiliesLessThan(int familyMembersNum) {
        return familyService.getFamiliesLessThan(familyMembersNum);
    }

    public int countFamiliesWithMemberNumber(int familyMembersNum) {
       return  familyService.countFamiliesWithMemberNumber(familyMembersNum);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public void deleteFamilyByIndex(int idx) {
        familyService.deleteFamilyByIndex(idx);
    }

    public Family bornChild(Family family, String manName, String womanName) {
        return familyService.bornChild(family, manName, womanName);
    }

    public Family adoptChild(Family family, Human human) {
        return familyService.adoptChild(family, human);
    }

    public void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return familyService.count();
    }

    public Family getFamilyById(int idx) {
      return familyService.getFamilyById(idx);
    }

    public Set<Pet> getPets(int familyIdx) {
       return familyService.getPets(familyIdx);
    }

    public void addPet(int familyIdx, Pet pet) {
       familyService.addPet(familyIdx, pet);
    }

}
