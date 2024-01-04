public class test {
    public static void main(String[] args) {
        PQ temp = new PQ(4);
        temp.insert(new City(12, "Filippos", 100000, 100));
        temp.insert(new City(22, "Giannis", 2500000, 200));
        temp.insert(new City(32, "Nikos", 504332, 10));
        temp.insert(new City(89, "Stamos", 42043, 43));

        // temp.remove(22);

        // for(int i = 1; i <= temp.Size();i++) {
        //     System.out.println(temp.getCity(i));
        // }
    }
}