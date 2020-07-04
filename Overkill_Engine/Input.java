package Overkill_Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class contains all methods regarding input and interaction with the player
 *
 * @author BoltonB07
 * @version 0.0.0
 */
public class Input
{
    public static String textIn() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().trim();
    }
    public static double numIn() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(br.readLine().trim());
    }
}
