package myapplication;
import java.io.*;
import java.util.*;


public class MyDictionary {

    //Key : Slang Word
    //Value: List of definitions;

    private HashMap<String, String> Words;
    private ArrayList<String> historyWords;

    public ArrayList<String> getHistoryWords() {
        return historyWords;
    }

    public void setHistoryWords(ArrayList<String> historyWords) {
        this.historyWords = historyWords;
    }

    public HashMap<String, String> getWords() {
        return Words;
    }

    public void setWords(HashMap<String, String> words) {
        Words = words;
    }
    public String getDefinition(String key){
        return this.Words.get(key);
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
                this.historyWords= new ArrayList<String>();
            }
            else {
                this.historyWords = IOFile.readHistoryFile(Application.HISTORY_FILE);
            }
        }catch (Exception e){
            System.out.println("Loi khoi tao");
        }
    }
    public void showWord(String key){
        String definition = this.getDefinition(key);
        System.out.println(String.format("%-15s | %-55s\n",key,definition));
    }
    public void showAll(HashMap <String,String> listWords){
        System.out.println(String.format("%-15s | %55s\n","   Slang","        Dinh nghia                            "));
        if(!listWords.isEmpty()){
            //Tham khảo cách duyệt phần tử trong hashmap
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
            for (String word : this.historyWords) {
                this.showWord(word);
            }
        }
        else {
            System.out.println("Khong co lich su tìm kiem");
        }
    }

    public Boolean searchByWord(String key){
        if(key.equals("")){
            System.out.println("Khong duoc de trong");
        }
        key=key.toUpperCase();
        return this.Words.containsKey(key);
    }
    public HashMap<String, String> searchDefinitionByKeyword(String keyword){
        if(keyword.equals("")){
            System.out.println("Khong duoc de trong");
        }
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
    public void deleteWord(String word){
        if(this.Words.containsKey(word)){
            this.Words.remove(word);
        }
    }

    public void resetDictionary(){
        this.Words.clear();
        this.Words.putAll(IOFile.readDataFromFile(Application.ORIGIN_FILE));
        IOFile.writeFile(this.Words, Application.EDITED_FILE);
        System.out.println("Reset tu dien thanh cong!");
    }

    public String randomWord(){
        ArrayList<String> listWords = new ArrayList<>(this.Words.keySet());
        int randomIndex = new Random().nextInt(listWords.size());
        return  listWords.get(randomIndex);
    }

}
