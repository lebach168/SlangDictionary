package myapplication;
import java.io.*;
import java.util.*;

public class IOFile {
    public static final String COMMA = "`";
    public static final String END_LINE = "\n";
    public static final String FILE_HEADER = "Slang`Meaning";
    public static HashMap<String,String> readDataFromFile(String filepath)  {
        HashMap<String, String> data = new HashMap<>();
        BufferedReader br = null;
        String line = "";
        try{
            br = new BufferedReader(new FileReader(filepath));
            while((line = br.readLine()) != null || !line.equals("")){
                String[] newWord = line.split(COMMA);
                if(newWord[0].equals("Slang")){
                    continue;
                }
                data.put(newWord[0],newWord[1]);
            }
        }catch (Exception e){
            System.out.println("Read file error: "+ e);
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
    public static void writeFile(HashMap<String,String> listWords, String filepath){
        BufferedWriter  bw = null;
        try{
            bw = new BufferedWriter(new FileWriter(filepath));
            bw.write(FILE_HEADER);
            bw.write(END_LINE);
            Set<String> keySet = listWords.keySet();
            for(String key:keySet){
                bw.write(key);
                bw.write(COMMA);
                bw.write(listWords.get(key));
                bw.write(END_LINE);
            }
        }catch (Exception e){
            System.out.println("Write file error: "+e );
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
