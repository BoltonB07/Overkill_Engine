package Overkill_Engine;
/**
 * This class contains methods regarding scenes and quickly generates scenes and options
 *
 * @author BoltonB07
 * @version 0.0.0
 */
public class Scene
{
    public static void clear(){
        System.out.println('\u000C');
    }

    public static void make(String currentLoc, String describeLoc, String choicePrompt, double money, boolean showMoney, double HP, boolean ShowHP){
        currentLoc.trim(); describeLoc.trim(); choicePrompt.trim();
        if(currentLoc!=null){
            Print.textln();
            Print.lineln("*",currentLoc.length());
            Print.textln(currentLoc.toUpperCase());
            Print.lineln("*",currentLoc.length());
        }
        if(describeLoc!=null){
            Print.textln(describeLoc);
            Print.textln();
        }
        if(choicePrompt!=null){
            Print.textln(choicePrompt);
            Print.textln();
        }
        if(showMoney){
            Print.textln("You have $"+money);
            Print.textln();
        }
        if(ShowHP){
            Print.textln("Your HP: "+HP);
        }
    }

    public static void choice(String[] choices){
        Print.textln();
        for(int k=0;k<=choices.length-1;k++){
            choices[k].trim();
        }
        int longest=0, longestIndex=0;
        String longestOptionNumber;
        for(int j=0;j<=choices.length-1;j++){
            if(choices[j].length()>longest){
                longest=choices[j].length();
                longestIndex=j;
            }
        }
        longestOptionNumber=String.valueOf(longestIndex+1);
        Print.lineln("-",longest+longestOptionNumber.length()+2);
        for(int i=0;i<=choices.length-1;i++){
            Print.textln((i+1)+": "+choices[i]);
        }
        Print.lineln("-",longest+longestOptionNumber.length()+2);
        Print.textln();
    }
}
