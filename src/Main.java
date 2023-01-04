import java.util.ArrayList;
import java.util.Scanner;

/***
 * created by gp
 */
public class Main {
    public static void main(String[] args) {

        int[] table = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 40, 40, 40, 40, 40};

        System.out.println("Please insert a number you wont to find in the table");

        boolean hasNum = false;

        int num = 0;

        do {
            try {

                Scanner scanner = new Scanner(System.in);

                num = scanner.nextInt();

                hasNum = true;

                scanner.close();

            } catch (Exception e) {

                System.out.println("This is not a number please try again");
            }
        } while (!hasNum);

        ArrayList<Integer> places = binary(table, num);

        if (places.isEmpty()) {

            System.out.println("The number " + num + " does not exist in the table");

        } else {

            System.out.println("and it is in places: ");

            for (Integer place : places) {

                System.out.print(place + "th ");
            }

        }
    }

    /***
     * Finds the place/places that the num exists in the table
     * @param table the table to be searched
     * @param num the number to find in the table
     * @return an ArrayList of the places the num exists in the table
     */
    public static ArrayList<Integer> binary(int[] table, int num) {

        int count = 0;

        int s = 0;

        int e = table.length - 1;

        int m = (s + e) / 2;

        ArrayList<Integer> places = new ArrayList<>();

        if (num < table[0] || num > table[e]) {
            return places;
        }

        do {
            count++;

            int front = m;

            int back = m;

            boolean backBool = false;

            boolean frontBool = false;

            if (table[m] == num) {

                do {

                    if ((back - 1 >= 0) && (table[back - 1] == num)) {

                        back--;
                    } else {
                        backBool = true;
                    }

                    if ((front + 1 <= table.length - 1) && (table[front + 1] == num)) {

                        front++;
                    } else {

                        frontBool = true;
                    }
                } while (!backBool || !frontBool);

                System.out.println("The number was found within " + count + " iterations");

                for (int i = back; i <= front; i++) {

                    places.add(i);
                }

                return places;

            } else if (num > table[m]) {

                s = m + 1;
                m = (s + e) / 2;

            } else {

                e = m - 1;
                m = (s + e) / 2;

            }
        } while (e >= s);

        return places;
    }
}