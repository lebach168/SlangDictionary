package myapplication;
import java.io.*;
import java.util.*;

public class MyDictionary {

    //Key : Slang Word
    //Value: List of definitions;
    public final static String ORIGIN_FILE = "slang.txt";
    public final static String HISTORY_FILE="history.txt";
    public final static String EDITED_FILE = "edited.txt";

    public HashMap<String, String> Words;
    public HashMap<String,String> historyWords;

    public MyDictionary()  {
        try{
            File editedFile = new File(EDITED_FILE);
            if(editedFile.exists()){
                this.Words = IOFile.readDataFromFile(EDITED_FILE);
            }
            else {
                this.Words = IOFile.readDataFromFile(ORIGIN_FILE);
            }
            File historyFile = new File(HISTORY_FILE);
            if(!historyFile.exists()){
                this.historyWords= new HashMap<>();
            }
            else {
                this.historyWords = IOFile.readDataFromFile(HISTORY_FILE);
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
            if(this.Words.get(key).toUpperCase().contains(keyword.toUpperCase()));

            SlangWords.put(key,this.Words.get(key));
        }
        return SlangWords;
    }


    public static  void  addWord(){

    }
    public static void editWord(){

    }
    public static void deleteWord(){ //Confirm truoc khi xoa

    }

    public void  resetDictionary(){
        this.Words=IOFile.readDataFromFile(ORIGIN_FILE);
        IOFile.writeFile(this.Words,EDITED_FILE);
        System.out.println("Reset tu dien thanh cong!");
    }

    public String randomWord(){
        ArrayList<String> listWords = new ArrayList<>(this.Words.keySet());
        int randomIndex = new Random().nextInt(listWords.size());
        return  listWords.get(randomIndex);
    }

    public static void game1(){

    }
    public static void game2(){

    }

}
