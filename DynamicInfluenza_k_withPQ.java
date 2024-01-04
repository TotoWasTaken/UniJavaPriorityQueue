import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DynamicInfluenza_k_withPQ {
    public static String line = "";
    public static String del = " ";

    public static int getMaxID(PQ pq){
        int n = pq.Size();
        City maxElement = pq.getCity(n/2);
        for(int i = 1 + n/2; i <= n; ++i){
            if(maxElement.compareTo(pq.getCity(i)) == -1)
                maxElement = pq.getCity(i);
        }
        return maxElement.getID();
    }

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
            PQ cityPQ = new PQ(2*k);
            
            while ((line = br.readLine()) != null) {
                String[] tempLine = line.split(del);
                City currCity = new City(tempLine[0], tempLine[1], tempLine[2], tempLine[3]);
                cityPQ.insert(currCity);
                
                if(cityPQ.Size() > k)
                    cityPQ.remove(getMaxID(cityPQ));
                System.out.println(cityPQ.Size());
                
                System.out.println("------------------------------------");
            }
            int n = cityPQ.Size();
            for(int i = 0; i < n; ++i)
                System.out.println(cityPQ.getmin());
        
            fr.close();
            br.close(); 
            scan.close();
        
        } catch(IOException e) {
            // e.printStackTrace();
            System.out.println("File doesn't exist!");
        }
    }    
}