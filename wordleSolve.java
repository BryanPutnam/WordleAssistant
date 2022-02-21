package Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class wordleSolve { 

    public static void numLetter(ArrayList<String> arrlst) { 
        Scanner usrIn = new Scanner(System.in); 
        System.out.println("How many letters do you know are in the word?"); 
        String input1 = usrIn.nextLine(); 
        int x = Integer.parseInt(input1); 
        System.out.println("What letters do you know?");
        ArrayList<String> newWords = new ArrayList<>();
        switch(x) { 
            case 1: oneLetter(arrlst, newWords);      break; 
            case 2: twoLetter(arrlst, newWords);      break; 
            case 3: threeLetter(arrlst, newWords);    break; 
            case 4: fourLetter(arrlst, newWords);     break; 
        }
        usrIn.close(); 
    }

    public static void oneLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        Scanner scan = new Scanner(System.in); 
        String oneLet = scan.nextLine();  
        for(String s : arrlst) { 
            if(s.contains(oneLet)) { 
                newWords.add(s); 
            }
        }
        scan.close(); 
        System.out.println(newWords); 
    }

    public static void twoLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        Scanner scan = new Scanner(System.in); 
        String[] arr = new String[2]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]))) { 
                newWords.add(s); 
            }
        }
        scan.close(); 
        System.out.println(newWords);
    }

    public static void threeLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        Scanner scan = new Scanner(System.in); 
        String[] arr = new String[3]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]) && (s.contains(arr[2])))) { 
                newWords.add(s); 
            }
        }
        scan.close(); 
        System.out.println(newWords);
    }

    public static void fourLetter(ArrayList<String> arrlst, ArrayList<String> newWords) { 
        Scanner scan = new Scanner(System.in); 
        String[] arr = new String[4]; 
        for(int i = 0; i < arr.length; i++) { 
            arr[i] = scan.nextLine(); 
        }
        for(String s : arrlst) { 
            if(s.contains(arr[0]) && (s.contains(arr[1]) && (s.contains(arr[2]) && s.contains(arr[3])))) { 
                newWords.add(s); 
            }
        }
        scan.close(); 
        System.out.println(newWords);
    }

    public static void main(String[] args) throws FileNotFoundException { 
        Scanner scan = new Scanner(new File("/Users/bryanputnam/Desktop/School/VSC_Files/Java/wordle.txt"));  
        ArrayList<String> arrlst = new ArrayList<>(); 
        while (scan.hasNext()) { 
            arrlst.add(scan.next()); 
        }
        numLetter(arrlst);
    }
}