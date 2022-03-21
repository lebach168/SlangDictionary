package myapplication;
import java.io.*;
public class Dictionary {
    public static void main(String[] args){
        runMainMenu();
    }
    public static void mainMenu(){
        System.out.println("--------------------------Slang Dictionary--------------------------");
        System.out.println("--1.Tim kiem slang - dedfinintion                                 --");
        System.out.println("--2.Tim kiem definition - slang                                   --");
        System.out.println("--3.Lich su tim kiem                                              --");
        System.out.println("--4.Them tu moi                                                   --");
        System.out.println("--5.Chinh sua                                                     --");
        System.out.println("--6.Xoa tu                                                        --");
        System.out.println("--7.Reset tu dien                                                 --");
        System.out.println("--8.Random slang word                                             --");
        System.out.println("--9.Tro choi do vui 1                                             --");
        System.out.println("--10.Tro choi do vui 2                                            --");
        System.out.println("--11. Thoat                                                       --");
        System.out.println("--------------------------------------------------------------------");
    }
    public static void runMainMenu(){
        mainMenu();
        cls();
        mainMenu();

    }
    public static void cls()
    {
//        try {
//
//        if (System.getProperty("os.name").contains("Windows"))
//
//            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//
//        else
//
//            Runtime.getRuntime().exec("clear");
//
//    } catch (IOException | InterruptedException ex) {}
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
    }
}
