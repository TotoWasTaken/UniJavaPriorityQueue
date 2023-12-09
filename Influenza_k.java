import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

class Influenza_k {
    public static String line = "";
    public static String del = " ";

    public static void main(String[] args) {   
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Insert File name:");
            String file_name = scan.nextLine();
            File fn = new File(file_name);
            FileReader fr = new FileReader(fn);
            BufferedReader br = new BufferedReader(fr); 
            System.out.println("Insert a value for k:");
            int k = scan.nextInt();
            PriorityQueue temp = new PriorityQueue((int)fn.length());
            while ((line = br.readLine()) != null) {
                String[] tempLine = line.split(del);
                City tempCity = new City(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
                temp.insert(tempCity);
            }
            ArrayList<City> temporaryArraylist = new ArrayList<>();
            for(int i = 0; i < temp.Size(); i++) {
                temporaryArraylist.add(temp.getMin());
            }
            if (k <= temp.Size()) {
                System.out.println("The top " + k + " cities are:");
                for(int i = 0; i < k; i++) {
                    System.out.println(temporaryArraylist.get(i));
                }
            } else {
                System.out.println("The value of k cannot exceed the number of cities on a file!");
            }
            fr.close();
            br.close(); 
            scan.close();
        } catch(IOException e) {
            // e.printStackTrace();
            System.out.println("File doesn't exist!");
        }
    }
}