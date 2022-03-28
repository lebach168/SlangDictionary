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
    {   //Hàm tham khảo
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
        System.out.println("--------------Tim kiem Slang--------------");
        System.out.print("Nhap slang word muon tim kiem : ");
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase();
        if(word.equals("")){
            return;
        }
        if(dictionary.searchByWord(word)){
            HashMap<String,String> temp= new HashMap<String,String>();
            temp.put(word,dictionary.getDefinition(word));
            dictionary.showAll(temp);
            ArrayList<String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.add(word);
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeHistoryFile(dictionary.getHistoryWords() , Application.HISTORY_FILE);
        }
        else{
            System.out.println("Khong tim thay tu!");
        }
        //Luu lai vao lich su tim kiem
    }
    public static void search2(MyDictionary dictionary){
        Menu.cls();
        System.out.println("--------------Tra dinh nghia--------------");
        System.out.print("Tim kiem dinh nghia lien quan : ");
        Scanner sc = new Scanner(System.in);
        String keyword = sc.next();
        HashMap <String, String> listWords = dictionary.searchDefinitionByKeyword(keyword);
        if(listWords.size()==0) {
            System.out.println("Khong tim thay tu phu hop");
        }
        else {
            dictionary.showAll(listWords);
            ArrayList<String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.addAll(listWords.keySet());
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeHistoryFile(dictionary.getHistoryWords() , Application.HISTORY_FILE);
        }
        //Luu lai vao lich su tim kiem
    }
    public static void manageHistory(MyDictionary dictionary){
        Menu.cls();
        System.out.println("--------------Lich su tim kiem--------------");
        System.out.println("Cac tu da tim kiem: ");
        dictionary.showHistory();
        System.out.println("Nhap d de xoa lich su tim kiem, Nhan phim bat kì khac de quay lai ");
        Scanner sc = new Scanner(System.in);
        String keyboardInput = sc.nextLine();
        if(keyboardInput.equals("D")|| keyboardInput.equals("d")){
            ArrayList<String> newHistoryWords = dictionary.getHistoryWords();
            newHistoryWords.clear();
            dictionary.setHistoryWords(newHistoryWords);
            IOFile.writeHistoryFile(dictionary.getHistoryWords(), Application.HISTORY_FILE);
            System.out.println("Xoa lich su tim kiem thanh cong!");
        }
    }
    public static void addNewWord(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Them tu moi--------------");
        System.out.print("Nhap slang word: ");
        String word = sc.nextLine().toUpperCase();
        System.out.print("Nhap dinh nghia cua tu: (Cac nghia cua tu cach nhau boi | )");
        String definition = sc.nextLine();
        dictionary.addWord(word, definition);
        IOFile.writeFile(dictionary.getWords(), Application.EDITED_FILE);

    }
    public static void editSlangWord(MyDictionary dictionary){
        Menu.cls();
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------Chinh sua tu--------------");
        System.out.print("Nhap slang word muon chinh sua: ");
        String word = sc.nextLine().toUpperCase();
        HashMap <String,String> tempList= new HashMap<>();
        tempList.putAll(dictionary.getWords());
        if(!tempList.containsKey(word)){
            System.out.println("Khong tim thay tu");
            return;
        }
        System.out.println(word+" co dinh nghia : " + tempList.get(word));
        System.out.print("Nhap lai slang word (Nhan enter de bo qua): ");
        String newWord = sc.nextLine().toUpperCase();
        System.out.print("Nhap lai dinh nghia (Nhan enter de bo qua): ");
        String newDefinition = sc.nextLine();
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
        System.out.println("--------------Xoa tu--------------");
        System.out.print("Nhap slang word muon xoa: ");
        String word = sc.next().toUpperCase();
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
                System.out.println("Lua chon khong hop le, tro ve menu chinh");
        }
    }
    public static void randomSlangWord(MyDictionary dictionary){
        Menu.cls();
        System.out.println("Tu ngau nhien: ");
        dictionary.showWord(dictionary.randomWord());
    }
    public static void game(MyDictionary dictionary, int type){//Type 1 / 2
        Menu.cls();
        System.out.println("--------------Tro choi do vui--------------");
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listWords = new ArrayList<>();
        ArrayList<String> listDefinitions = new ArrayList<>();

        HashMap <String, String> question  = new HashMap<>();
        for( int i = 0;i<4;i++){
            listWords.add(dictionary.randomWord());
            listDefinitions.add(dictionary.getDefinition(listWords.get(i)));
            question.put(listWords.get(i),listDefinitions.get(i));
        }
        Collections.shuffle(listWords);
        if(type==1 ){
            System.out.println("Tu "+ listWords.get(1) + " co y nghia la: ");
            for(int i = 0;i<4;i++){
                System.out.println((i+1) + ". "+ listDefinitions.get(i));
            }
            System.out.println("-------------------------");
            System.out.print("Nhap cau tra loi cua ban: ");
            int ans = sc.nextInt();
            if(ans != 1 && ans != 2 && ans != 3 && ans != 4){
                System.out.println("Nhap dap an khong hop le");
                return;
            }
            ans-=1;
            if (dictionary.getDefinition(listWords.get(1)).equals(listDefinitions.get(ans))){
                System.out.println("Qua chinh xac");
            }
            else {
                System.out.println("Sai mat roi");
            }
        }
        else {
            System.out.println(listDefinitions.get(1) + " : ");
            for(int i = 0;i<4;i++){
                System.out.println((i+1) + ". "+ listWords.get(i));
            }
            System.out.println("-------------------------");
            System.out.print("Nhap cau tra loi cua ban: ");
            int ans = sc.nextInt();
            if(ans != 1 && ans != 2 && ans != 3 && ans != 4){
                System.out.println("Nhap dap an khong hop le");
                return;
            }
            ans-=1;
            if (dictionary.getDefinition(listWords.get(ans)).equals(listDefinitions.get(1))){
                System.out.println("Qua chinh xac");
            }
            else {
                System.out.println("Sai mat roi");
            }
        }


    }
}
