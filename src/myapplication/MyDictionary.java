package myapplication;
import java.io.*;
import java.util.*;


public class MyDictionary {

    //Key : Slang Word
    //Value: List of definitions;

    private HashMap<String, String> Words;
    private HashMap<String,String> historyWords;

    public HashMap<String, String> getWords() {
        return Words;
    }

    public void setWords(HashMap<String, String> words) {
        Words = words;
    }

    public HashMap<String, String> getHistoryWords() {
        return historyWords;
    }

    public void setHistoryWords(HashMap<String, String> historyWords) {
        this.historyWords = historyWords;
    }

    public MyDictionary()  {
        try{
            File editedFile = new File(Application.EDITED_FILE);
            if(editedFile.exists()){
                this.Words = IOFile.readDataFromFile(Application.EDITED_FILE);
            }
            else {
                this.Words = IOFile.readDataFromFile(Application.ORIGIN_FILE);
            }
            File historyFile = new File(Application.HISTORY_FILE);
            if(!historyFile.exists()){
                this.historyWords= new HashMap<>();
            }
            else {
                this.historyWords = IOFile.readDataFromFile(Application.HISTORY_FILE);
            }
        }catch (Exception e){
            System.out.println("Loi khoi tao");
        }
    }
    public void showWord(String key){
        System.out.println(key + " - " + this.Words.get(key));
    }
    public void showAll(HashMap <String,String> listWords){
        if(!listWords.isEmpty()){
            Set<String> keySet = listWords.keySet();
            for (String key : keySet) {
                this.showWord(key);
            }
        }
        else {
            System.out.println("Empty");
        }
    }
    public void showHistory(){
        if(!this.historyWords.isEmpty()){
            Set<String> keySet = this.historyWords.keySet();
            for (String key : keySet) {
                this.showWord(key);
            }
        }
        else {
            System.out.println("Empty");
        }
    }

    public Boolean searchByWord(String key){
        key=key.toUpperCase();
        return this.Words.containsKey(key);
    }
    public HashMap<String, String> searchDefinitionByKeyword(String keyword){
        HashMap<String, String> SlangWords = new HashMap<>();
        Set<String> keySet = this.Words.keySet();
        for(String key:keySet){
            if(this.Words.get(key).toUpperCase().contains(keyword.toUpperCase())){
                SlangWords.put(key,this.Words.get(key));
            }
        }
        return SlangWords;
    }

    public void addWord(String word, String definition){
        this.Words.put(word, definition);
    }
    public void editWord(String word, String definition){
        this.Words.replace(word,definition);
    }
    public void deleteWord(String word){ //Confirm truoc khi xoa
        if(this.Words.containsKey(word)){
            this.Words.remove(word);
        }
        else{
            System.out.println("Khong tim thay tu trong tu dien!");
        }
    }

    public void resetDictionary(){
        this.Words=IOFile.readDataFromFile(Application.ORIGIN_FILE);
        IOFile.writeFile(this.Words, Application.EDITED_FILE);
        System.out.println("Reset tu dien thanh cong!");
    }

    public String randomWord(){
        ArrayList<String> listWords = new ArrayList<>(this.Words.keySet());
        int randomIndex = new Random().nextInt(listWords.size());
        return  listWords.get(randomIndex);
    }

}
