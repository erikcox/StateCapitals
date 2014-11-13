/*
 Author: Erik Cox
 Date  : 11/04/14
 Homework Assignment: US State Capital Game
 File Name: parseStates.java
 Objective: This is a quiz game for U.S. state capitals.
            This class parses the U.S. states and puts them into SQLite
*/

package fall.cs211d.statecapitals;

import java.util.*;
import java.io.*;

public class parseStates
{
    private static final String FILENAME = "US_states";

    //****************************parseUSStates()*****************************
    private static void parseUSStates(String states[], String capitals[])
    {
        try
        {
            Scanner sc = new Scanner(new File(FILENAME));
            String line;
            int i = 0;

            sc.nextLine(); sc.nextLine(); // skip over couple of headers

            while(sc.hasNext())
            {
                line = sc.nextLine();
                String temp[] = line.split("\\s\\s+");
                if(temp.length >= 2)
                {
                    if(temp.length == 2)
                    {
                        states[i]     = temp[0];
                        capitals[i++] = temp[1];
                    }
                    else
                    {
                        states[i]     = temp[0] + " " + temp[1];
                        capitals[i++] = temp[2];
                    }
                }
            }

        }catch(FileNotFoundException e){System.err.println(e);}
    }
    //*********************************main()*********************************
    public static void main(String  args[])
    {
        String states[]   = new String[50];
        String capitals[] = new String[50];

        parseUSStates(states, capitals);

        for(int i = 0; i < states.length; i++)
        {
            System.out.print(states[i] + ">>");
            System.out.println(capitals[i]);
        }
    }
}
