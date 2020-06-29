package Overkill_Engine;
/**
 * This class contains all methods regarding printing and outputting simple single line text and patterns.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Print
{
    public static void text(String text){
        System.out.print(text);
    }

    public static void textln(String text){
        System.out.println(text);
    }

    public static void error(String errorStatement){
        System.out.println("Error: "+errorStatement);
    }

    public static void systemError(int error_code, String error_message){
        System.out.println("Error "+error_code+": "+error_message);
    }

    public static void line(String line, int length){
        int numberOfTimesToPrintFull=length/line.length();
        for(int i=1;i<=numberOfTimesToPrintFull;i++){
            text(line);
        }
        int numberOfTimesToPrintOne=length%line.length();
        for(int j=0; j<=numberOfTimesToPrintOne-1;j++){
            text(Character.toString(line.charAt(j)));
        }
    }
    public static void lineln(String line, int length){
        int numberOfTimesToPrintFull=length/line.length();
        for(int i=1;i<=numberOfTimesToPrintFull;i++){
            text(line);
        }
        int numberOfTimesToPrintOne=length%line.length();
        for(int j=0; j<=numberOfTimesToPrintOne-1;j++){
            text(Character.toString(line.charAt(j)));
        }
        textln("");
    }

    public static void lineAndText(String line, int length, String text){
        if(length>text.length()){
            int effectiveLength=length-text.length();  //a="--",length=6,text="abc",effectLengt=3
            boolean ifOdd=false;
            if(effectiveLength%2==1){   //ifOdd=true
                ifOdd=true;
            }
            if(ifOdd){
                line(line, (effectiveLength/2)+1);//works correctly HERE
            }
            else{
                line(line, effectiveLength/2);
            }
            text(text);//works correctly
            line(line, effectiveLength/2);//Fucks up shit,
        }
        else if(length<text.length()){
            line(text,length);
        }
        else{
            text(text);
        }
    }
    public static void lineAndTextln(String line, int length, String text){
        if(length>text.length()){
            int effectiveLength=length-text.length();  //a="--",length=6,text="abc",effectLengt=3
            boolean ifOdd=false;
            if(effectiveLength%2==1){   //ifOdd=true
                ifOdd=true;
            }
            if(ifOdd){
                line(line, (effectiveLength/2)+1);//works correctly HERE
            }
            else{
                line(line, effectiveLength/2);
            }
            text(text);//works correctly
            line(line, effectiveLength/2);//Fucks up shit,
        }
        else if(length<text.length()){
            line(text,length);
        }
        else{
            text(text);
        }
        textln("");
    }
}
