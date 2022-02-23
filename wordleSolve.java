package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class wordleSolve {  

    static final String breaker = "**********************************************************"; 
    public static Scanner scan = new Scanner(System.in); 

    public static void numLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        System.out.println(breaker + "\nHow many letters do you know are in the word?"); 
        String input1 = scan.nextLine(); 
        int x = Integer.parseInt(input1); 
        System.out.println(breaker + "\nWhat letters do you know?");
        switch(x) { 
            case 1: oneLetter(arrlst, newWords);      break; 
            case 2: twoLetter(arrlst, newWords);      break; 
            case 3: threeLetter(arrlst, newWords);    break; 
            case 4: fourLetter(arrlst, newWords);     break; 
        }
        removeLetter(arrlst, newWords);
    }

    public static void removeLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        System.out.println(breaker + "\nHow many letters will not work?");
        String num = scan.nextLine(); 
        int n = Integer.parseInt(num); 
        System.out.println(breaker + "\nWhat letters will not work?"); 
        String[] arrNot = new String[n]; 
        ArrayList<String> toRemove = new ArrayList<>(); 
        for(int i = 0; i < arrNot.length; i++) { 
            arrNot[i] = scan.nextLine(); 
        }
        for(String i : newWords) { 
            for(String j : arrNot) { 
                if(i.contains(j)) { 
                    toRemove.add(i); 
                }
            }
        }
        newWords.removeAll(toRemove); 
        System.out.println(breaker + "\nYour list of possible words: \n"); 
        System.out.println(newWords + "\n"); 
        System.out.println("Do you need more hints? (Type 'Y' for Yes or 'N' for No)"); 
        String choice = scan.nextLine(); 
        if (choice.toLowerCase().equals("y")){ 
            numLetter(arrlst, newWords);
        }
    }

    public static void oneLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        String oneLet = scan.nextLine();  
        for(String s : arrlst) { 
            if(s.contains(oneLet)) { 
                newWords.add(s); 
            }
        }
    }

    public static void twoLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        String[] arr = new String[2]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]))) { 
                newWords.add(s);  
            }
        }
    }

    public static void threeLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        String[] arr = new String[3]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]) && (s.contains(arr[2])))) { 
                newWords.add(s); 
            }
        }
    }

    public static void fourLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        String[] arr = new String[4]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]) && (s.contains(arr[2]) && s.contains(arr[3])))) { 
                newWords.add(s); 
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException { 
        //Scanner fileScan = new Scanner(new File("/Users/bryanputnam/Desktop/School/VSC_Files/Java/wordle.txt"));  // Wordle Official List 

        Scanner fileScan = new Scanner(new File("/Users/bryanputnam/Desktop/School/VSC_Files/Java/allWords.txt"));
        ArrayList<String> arrlst = new ArrayList<>();
        ArrayList<String> newWords = new ArrayList<>(); 
        while (fileScan.hasNext()) { 
            arrlst.add(fileScan.next()); 
        }
        Collections.sort(arrlst); 
        numLetter(arrlst, newWords);
    }
}