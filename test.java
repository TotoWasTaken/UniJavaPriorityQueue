public class test {
    public static void main(String[] args) {
        PQ temp = new PQ(5);
        temp.insert(new City(12, "Filippos", 100000, 100));
        temp.insert(new City(22, "Giannis", 2500000, 200));
        temp.insert(new City(32, "Nikos", 504332, 10));
        temp.insert(new City(89, "Stamos", 42043, 43));
         
        System.out.println(temp.Size());
        temp.remove(12);    
        System.out.println(temp.Size());
        
         for(int i = 1;i <= temp.Size() ;i++) {
             System.out.println(temp.getCity(i));
        }
        // System.out.println(temp.getCapacity());
        // System.out.println((float)temp.Size()/(float)temp.getCapacity() > 0.75);
        
    }

}