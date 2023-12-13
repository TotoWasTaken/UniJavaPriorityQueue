import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
            PQ temp = new PQ(5);
            while ((line = br.readLine()) != null) {
                String[] tempLine = line.split(del);
                City tempCity = new City(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
                temp.insert(tempCity);
            }
            City[] CityArray = new City[k];
            if (k <= temp.Size()) {
                System.out.printf("The top %s cities are:\n",k);
                for(int i = 0;i < k;i++) {
                    CityArray[i] = temp.getmin();
                }
                for(int i = 0;i < k;i++) {
                    System.out.println(CityArray[i]);
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