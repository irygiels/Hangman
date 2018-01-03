import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int wrongGuesses;
    private static boolean notFinished;
    public static void main(String[] args) throws FileNotFoundException, NullPointerException, StringIndexOutOfBoundsException {
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        int linesNumber = 0;
        wrongGuesses = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            linesNumber++;
        }
        scanner.close();
        scanner = new Scanner(file);
        int line = (int) (Math.random() * (linesNumber - 1) + 1);
        int i = 0;
        String movie = null;
        while (i < line) {
            movie = scanner.nextLine();
            i++;
        }
        movie = movie.toLowerCase().replace(" ","");
        ArrayList<Character> arrayList = new ArrayList();
        int len = movie.length();
        notFinished = true;
        while(notFinished) {
            System.out.println("\nYou are guessing " + movie.length() + " letters");
            System.out.println("You guessed " + wrongGuesses + " letters wrong");
            Scanner scan = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
            String letter = scan.nextLine();
            arrayList.add(letter.charAt(0));
            checkGuess(movie, arrayList, len, letter.charAt(0));
        }
        System.out.println("\nYou won! It's " + movie);

    }

    private static void checkGuess(String movie, ArrayList arrayList, int len, char ch){
        boolean guessed = false;
        notFinished = false;
        for(int k = 0; k < len; k++) {
            if (arrayList.contains(movie.charAt(k))) {
                System.out.print(movie.charAt(k));
                if(ch == movie.charAt(k)) {
                    guessed = true;
                }
            } else {
                System.out.print("_");
                notFinished = true;
            }
        }
        if(!guessed){
            wrongGuesses++;
        }
    }


}

