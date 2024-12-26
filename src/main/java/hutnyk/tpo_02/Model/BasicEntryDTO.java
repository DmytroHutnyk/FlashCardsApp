package hutnyk.tpo_02.Model;

public class BasicEntryDTO {
    private String english;
    private String german;
    private String polish;


    public BasicEntryDTO(String english, String german, String polish) {
        this.english = english;
        this.german = german;
        this.polish = polish;
    }


    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getGerman() {
        return german;
    }

    public void setGerman(String german) {
        this.german = german;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

}
