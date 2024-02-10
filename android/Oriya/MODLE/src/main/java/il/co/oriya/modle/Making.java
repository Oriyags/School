package il.co.oriya.modle;

public class Making {

    private String firstNameFirstLetter;
    private String familyNameFirstLetter;

    public String getFirstNameFirstLetter() {
        return firstNameFirstLetter;
    }

    public void setFirstNameFirstLetter(String firstNameFirstLetter) {
        this.firstNameFirstLetter = firstNameFirstLetter;
    }

    public String getFamilyNameFirstLetter() {
        return familyNameFirstLetter;
    }

    public void setFamilyNameFirstLetter(String familyNameFirstLetter) {
        this.familyNameFirstLetter = familyNameFirstLetter;
    }

    public String combined() {
        return String.format("%s.%s", this.familyNameFirstLetter, this.firstNameFirstLetter);
    }
}