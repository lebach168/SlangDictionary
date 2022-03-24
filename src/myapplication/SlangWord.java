package myapplication;

import java.util.ArrayList;

public class SlangWord implements Comparable<SlangWord>{
    private String word;
    private String definition;

    public SlangWord(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

//    public void addDefinition(String def){
//        this.definition.add(def);
//    }

    @Override
    public int compareTo(SlangWord w2) {
        return (this.word).compareTo(w2.getWord());
    }
}
