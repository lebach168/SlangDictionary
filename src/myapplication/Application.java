package myapplication;

import java.util.Scanner;

public class Application {
    public final static String ORIGIN_FILE = "slang.txt";
    public final static String HISTORY_FILE="history.txt";
    public final static String EDITED_FILE = "edited.txt";
    public static void main (String[] args) {

        MyDictionary dictionary =  new MyDictionary();
        runMainMenu(dictionary);
    }
    public static void runMainMenu(MyDictionary dictionary){
        Menu menu = new Menu();
        menu.cls();
        menu.mainMenu();
        Scanner sc = new Scanner(System.in);
        String choice = null;
        System.out.print("Nhap lua chon: ");
        choice = sc.next();
        switch (choice){
            case "1":
                menu.search1(dictionary);
                break;
            case "2":
                menu.search2(dictionary);
                break;
            case "3":
                menu.manageHistory(dictionary);
                break;
            case "4":
                menu.addNewWord(dictionary);
                break;
            case "5":
                menu.editSlangWord(dictionary);
                break;
            case "6":
                menu.deleteWordFromDictionary(dictionary);
                break;
            case "7":
                dictionary.resetDictionary();
                break;
            case "8":

                break;
            case "9":
                break;
            case "10":
                break;
            case "11":
                System.exit(0);
            default:
                System.out.println("Khong hop le!");
                break;
        }
        Menu.pause();
        runMainMenu(dictionary);
    }



}
