//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.launchcode.techjobs.console;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TechJobs {
    private static Scanner in;

    public TechJobs() {
    }

    public static void main(String[] args) {
        HashMap<String, String> columnChoices = new HashMap();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");
        HashMap<String, String> actionChoices = new HashMap();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
        System.out.println("Welcome to LaunchCode's TechJobs App!");

        while(true) {
            while(true) {
                while(true) {
                    String actionChoice = getUserSelection("View jobs by:", actionChoices);
                    String searchField;
                    if (actionChoice.equals("list")) {
                        searchField = getUserSelection("List", columnChoices);
                        if (searchField.equals("all")) {
                            printJobs(JobData.findAll());
                        } else {
                            ArrayList<String> results = JobData.findAll(searchField);
                            System.out.println((String)columnChoices.get(searchField));
                            Iterator var6 = results.iterator();

                            while(var6.hasNext()) {
                                String item = (String)var6.next();
                                System.out.println(item);
                            }
                        }
                    } else {
                        searchField = getUserSelection("Search by:", columnChoices);
                        System.out.println("\nSearch term: ");
                        String searchTerm = in.nextLine();
                        if (searchField.equals("all")) {
                            System.out.println("Search all fields not yet implemented.");
                        } else {
                            printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                        }
                    }
                }
            }
        }
    }

    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];
        Integer i = 0;

        for(Iterator var6 = choices.keySet().iterator(); var6.hasNext(); i = i + 1) {
            String choiceKey = (String)var6.next();
            choiceKeys[i] = choiceKey;
        }

        Integer choiceIdx;
        do {
            System.out.println(menuHeader);

            for(Integer j = 0; j < choiceKeys.length; j = j + 1) {
                PrintStream var10000 = System.out;
                j.println((String)choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();
            if (choiceIdx >= 0 && choiceIdx < choiceKeys.length) {
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }

    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {
        Iterator var1 = someJobs.iterator();

        while(var1.hasNext()) {
            HashMap job = (HashMap)var1.next();
            System.out.println("**************************");
            Iterator var3 = job.keySet().iterator();

            while(var3.hasNext()) {
                Object k = var3.next();
                PrintStream var10000 = System.out;
                ((PrintStream)k).println((String)job.get(k));
            }

            System.out.println("**************************");
            System.out.println(" ");
        }

    }

    static {
        in = new Scanner(System.in);
    }
}
