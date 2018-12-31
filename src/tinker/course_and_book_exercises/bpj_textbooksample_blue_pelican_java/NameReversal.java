package tinker.course_and_book_exercises.bpj_textbooksample_blue_pelican_java;

import java.util.Scanner;

public class NameReversal {

    public static void main(String[] args) {

        Scanner nameScanner = new Scanner(System.in);
        String name;

        System.out.print("Please enter your name. ");
        name = nameScanner.nextLine();

        for (int i = (name.length()-1); i >= 0; i--) {

            System.out.print(name.substring(i,i+1).toLowerCase());

        }

    } // end main(String[])

} // end NameReversal class