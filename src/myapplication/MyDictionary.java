package myapplication;
import java.io.*;
import java.util.*;

public class MyDictionary {

    //Key : Slang Word
    //Value: List of definitions;

    public HashMap<String, String> Words;

    public HashMap<String, String> getWords() {
        return Words;
    }

    public MyDictionary(String filename)  {
        try{
            this.Words = IOFile.readDataFromFile(filename);
        }catch (Exception e){
            System.out.println("Loi khoi tao");
        }
    }
    public void showWord(String key){
        System.out.println(key + " - " + this.Words.get(key));
    }
    public void showAll(){
        if(!this.Words.isEmpty()){
            Set<String> keySet = this.Words.keySet();
            for (String key : keySet) {
                System.out.println(key + " - " + this.Words.get(key));
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
            SlangWords.put(key,keyword);
        }
        return SlangWords;
    }

    public static  void  addWord(){

    }
    public static void editWord(){

    }
    public static void deleteWord(){ //Confirm truoc khi xoa

    }

    public static void  resetDictionary(){

    }

//    public static SlangWord randomWord(){
//
//        return a;
//    }

    public static void game1(){

    }
    public static void game2(){

    }

}
