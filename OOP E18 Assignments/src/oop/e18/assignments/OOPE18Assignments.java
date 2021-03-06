/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.e18.assignments;

import java.util.ArrayList;
import java.util.Scanner;
import static oop.e18.assignments.Modul.print;
import oop.e18.assignments.modules.*;

/**
 *
 * @author Oliver
 */
public class OOPE18Assignments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Add modules in an array of the type Modul, which is the parent class of the modules - it takes in a boolean as an argument for whether the module is active
        Modul[] modules = {
           new Modul002(false),
           new Modul003(false),
           new Modul0XX(false), //XX is a placeholder class
           //Add any new assignments here - beware: the has to be a class made for the module - use Modul0XX as a template
       };

        

        String moduleNames[]
                = {
                    //Rembember to add any new module to this array, as this is the array that is used for the 'help' option further down
                    "002", "003", "0XX"                                 
                };
        //Running is a boolean that allows to end the following while-loop
        boolean running = true;
        
        //The while-loop allows you to select different modules after they are closed
        while (running) {
            //Introduction to program
            print("---------------"); //print is a costom method that replaces 'System.out.printf("");' - The method resides in the Modul class NB: IT'S RATHER USELESS
            print("Please write the name of an assignment:");
            print("---------------");

            //Listen for program names
            Scanner userInput = new Scanner(System.in);
            String assignmentName = userInput.nextLine();

            //Initialise program
            switch (assignmentName.toUpperCase()) {
                case "002":
                    //Sets the modul as active which allows a while-loop inside the Modul to run
                    modules[0].active = true;
                    //Runs the moduls assignments
                    Modul002.run();
                    break;
                    
                case "003":
                    modules[1].active = true;
                    Modul003.run();
                    break;
                    
                case "0XX":
                    //Remember to count the array up for each new module - fx. the next module would be 'modules[3].active = true;'
                    modules[2].active = true; 
                    Modul0XX.run();
                    break;
                
                //Stops the while-loop    
                case "EXIT":
                case "STOP":
                    running = false;
                    break;
                
                //Prints out all of the modules    
                case "HELP":
                    for (int i = 0; i < moduleNames.length; i++) {
                        print(moduleNames[i]);
                    }
                    break;
                
                //When a userInput is not recognized the following message appers    
                default:
                    print("Invalid program. Type 'help' to see availible programs.");
                    break;

            }
        }

    }

}
