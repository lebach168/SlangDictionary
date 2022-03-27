package myapplication;

import java.util.*;



public class Menu {
    public static void mainMenu(){
        System.out.println("--------------------------Slang Dictionary--------------------------");
        System.out.println("--1.Tim kiem slang - dedfinintion");
        System.out.println("--2.Tim kiem definition - slang");
        System.out.println("--3.Lich su tim kiem");
        System.out.println("--4.Them tu moi");
        System.out.println("--5.Chinh sua");
        System.out.println("--6.Xoa tu");
        System.out.println("--7.Reset tu dien");
        System.out.println("--8.Random slang word");
        System.out.println("--9.Tro choi do vui 1");
        System.out.println("--10.Tro choi do vui 2");
        System.out.println("--11. Thoat");
        System.out.println("--------------------------------------------------------------------");
    }
    public static void cls()
    {
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println("");
        }
    }
    public static void pause(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to continue...");
        sc.nextLine();
    }

    public static void search1(MyDictionary dictionary){
        Menu.cls();
        System.out.print("Nhap slang word muon tim kiem : ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        if(dictionary.searchByWord(word)){
            dictionary.showWord(word);
            HashMap <String, String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.put(word, dictionary.getWords().get(word));
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeFile(dictionary.getHistoryWords() , Application.HISTORY_FILE);
        }
        else{
            System.out.println("Khong tim thay tu!");
        }
        //Luu lai vao lich su tim kiem
    }
    public static void search2(MyDictionary dictionary){
        Menu.cls();
        System.out.print("Tim kiem dinh nghia lien quan : ");
        Scanner sc = new Scanner(System.in);
        String keyword = sc.next();
        HashMap <String, String> listWords = dictionary.searchDefinitionByKeyword(keyword);
        if(listWords.size()==0) {
            System.out.print("Khong tim thay tu phu hop");
        }
        else {
            dictionary.showAll(listWords);
            HashMap <String, String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.putAll(listWords);
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeFile(dictionary.getHistoryWords() , Application.HISTORY_FILE);


        }

        //Luu lai vao lich su tim kiem
    }
    public static void manageHistory(MyDictionary dictionary){
        Menu.cls();
        System.out.println("Cac tu da tim kiem: ");
        dictionary.showHistory();
        System.out.println("Nhap d de xoa lich su tim kiem, Nhan phim bat kì khac de quay lai ");
        Scanner sc = new Scanner(System.in);
        String keyboardInput = sc.next();
        if(keyboardInput.equals("D")|| keyboardInput.equals("d")){
            HashMap <String, String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.clear();
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeFile(dictionary.getHistoryWords(), Application.HISTORY_FILE);
            System.out.println("Xoa lich su tim kiem thanh cong!");
        }
    }
    public static void addNewWord(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Them tu moi------------------");
        System.out.print("Nhap slang word: ");
        String word = sc.next();
        System.out.print("Nhap dinh nghia cua tu: (Cac nghia cua tu cach nhau boi | )");
        String definition = sc.next();
        dictionary.addWord(word, definition);
        IOFile.writeFile(dictionary.getWords(), Application.EDITED_FILE);

    }
    public static void editSlangWord(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Chinh sua tu------------------");
        System.out.print("Nhap slang word muon chinh sua: ");
        String word = sc.next();
        HashMap <String,String> tempList= new HashMap<>();
        tempList.putAll(dictionary.getWords());
        if(!tempList.containsKey(word)){
            System.out.println("Khong tim thay tu");
            return;
        }
        System.out.println(word+" co dinh nghia : " + tempList.get(word));
        System.out.print("Nhap lai slang word (Nhan enter de bo qua): ");
        String newWord = sc.next();
        System.out.print("Nhap lai dinh nghia (Nhan enter de bo qua): ");
        String newDefinition = sc.next();
        if(newWord.equals("")){
            newWord = word;
        }
        if(newDefinition.equals("")){
            newDefinition = tempList.get(word);
        }
        dictionary.editWord(newWord,newDefinition);
        if(!newWord.equals(word)){
            dictionary.deleteWord(word);
        }
        System.out.println("Chinh sua thong tin thanh cong");
    }
    public static void deleteWordFromDictionary(MyDictionary dictionary){ //Confirm truoc khi xoa
        Menu.cls();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------Xoa tu------------------");
        System.out.print("Nhap slang word muon xoa: ");
        String word = sc.next();
        HashMap <String,String> tempList= new HashMap<>();
        tempList.putAll(dictionary.getWords());
        if(!tempList.containsKey(word)){
            System.out.println("Khong tim thay tu");
            return;
        }
        System.out.println("Ban co chac chan muon xoa? (Yes / No)");
        String confirm = sc.next().toUpperCase();

        switch (confirm){
            case "YES":
                dictionary.deleteWord(word);
                System.out.println("Xoa thanh cong");
                break;
            case "NO":
                System.out.println("Quay tro ve");
                break;
            default:
                System.out.println("Lua chon khong hop le, tro ve");
        }
    }
    public static void slangWordOfTheDay(MyDictionary dictionary){

    }
    public static void game1(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
    }
    public static void game2(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
    }
}
