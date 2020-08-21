package Overkill_Engine;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Format:
 * [name]
 * [HP]
 * [money]
 * [weapon]
 *
 * [labels...]
 */
public class Save {
    public static void make() throws IOException {
        PrintWriter file = new PrintWriter("SaveFile.txt", StandardCharsets.UTF_8);
        FileWriter fileWriter = new FileWriter("SaveFile.txt",true);
        BufferedWriter br=new BufferedWriter(fileWriter);
        br.write("null\n100.0\n0.0\nnoweapon");
        br.close();
        file.close();
    }
     static String[] read() throws IOException {
         String[] saveData = new String[5];
         BufferedReader br= new BufferedReader(new FileReader("SaveFile.txt"));
         Scanner sc=new Scanner(br.readLine());
         saveData[0]= sc.next();
         sc=new Scanner(br.readLine());
         saveData[1]= sc.next();
         sc=new Scanner(br.readLine());
         saveData[2]= sc.next();
         sc=new Scanner(br.readLine());
         saveData[3]= sc.next();
        String labelLines;
        String labels="";
        while((labelLines= br.readLine())!=null){
            sc=new Scanner(labelLines);
            while(sc.hasNext()) {
                labels = labels.concat("\n" + sc.next());
            }
        }
        saveData[4]=labels;
        sc.close();
        br.close();
        return saveData;
     }
     public static String getName() throws IOException {
        String[] name = read();
        return name[0];
     }
    public static String getLabels() throws IOException {
        String[] name = read();
        return name[4];
    }
    public static double getMoney() throws IOException {
        String[] name = read();
        return Double.parseDouble(name[2]);
    }
    public static String getWeapon() throws IOException {
        String[] name = read();
        return name[3];
    }
    public static double getHP() throws IOException {
        String[] name = read();
        return Double.parseDouble(name[1]);
    }
    public static boolean ifSaveExists(){
        File file=new File("SaveFile.txt");
        return file.exists();
    }
    public static void setName(String newName) throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file = new PrintWriter("SaveFile.txt");
        file.println(newName);
        for(int i = 1;i<=oldSave.length-1;i++)
            file.println(oldSave[i]);
        file.close();
    }
    public static void setHP(double newHP) throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file = new PrintWriter("SaveFile.txt");
        file.println(oldSave[0]);
        newHP=Num.round(newHP,2);
        file.println(newHP);
        for(int i = 2;i<=oldSave.length-1;i++)
            file.println(oldSave[i]);
        file.close();
    }
    public static void setMoney(double newMoney) throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file = new PrintWriter("SaveFile.txt");
        file.println(oldSave[0]);
        file.println(oldSave[1]);
        newMoney=Num.round(newMoney,2);
        file.println(newMoney);
        for(int i = 3;i<=oldSave.length-1;i++)
            file.println(oldSave[i]);
        file.close();
    }
    public static void setWeapon(String newWeapon) throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file = new PrintWriter("SaveFile.txt");
        file.println(oldSave[0]);
        file.println(oldSave[1]);
        file.println(oldSave[2]);
        file.println(newWeapon);
        for(int i = 4;i<=oldSave.length-1;i++)
            file.println(oldSave[i]);
        file.close();
    }
    public static void addLabel(String label) throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file=new PrintWriter("SaveFile.txt");
        for(int i = 0;i<=4;i++)
            file.println(oldSave[i]);
        file.println(label);
        file.close();
    }
    public static void removeAllLabels() throws IOException {
        String[] oldSave=Save.read();
        PrintWriter file=new PrintWriter("SaveFile.txt");
        for(int i = 0;i<=3;i++)
            file.println(oldSave[i]);
        file.close();
    }
    public static void removeLabel(String labelToRemove)  throws IOException{
        String[] oldSave=Save.read();
        PrintWriter file = new PrintWriter("SaveFile.txt");
        Scanner sc=new Scanner(oldSave[3]);
        for(int i=0;i<=3;i++){
            file.println(oldSave[i]);
        }
        String line;
        while (sc.hasNext()) {
            if (!((line= sc.nextLine()).contains(labelToRemove))) {
                file.println(line);
            }
        }
        file.close();
        sc.close();
    }

    public static void main(String[] args) throws IOException {
        Save.make();
        Save.setName("haha");
        Save.setHP(100);
        Save.setMoney(200);
        Save.setWeapon("Knife");
        Save.addLabel("buckyhouse");
        Print.textln(getWeapon());
        Print.textln(getLabels());
    }
}
