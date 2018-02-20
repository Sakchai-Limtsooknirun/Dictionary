package model;

public class Vocabulary {
    private String partOfSpeech;
    private String meaning;
    private String example;
    private String name;

    public Vocabulary(String name, String partOfSpeech, String meaning, String example) {
        this.partOfSpeech = partOfSpeech;
        this.meaning = meaning;
        this.example = example;
        this.name = name;
    }


    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getExample() {
        return example;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Word:  %s   PartOfSpeech:  %s   Meaning:  %s   Example:  %s  ",
                this.name, this.partOfSpeech, this.meaning, this.example);
    }

}

