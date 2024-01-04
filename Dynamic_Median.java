import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Dynamic_Median {

    PQ_f m_minHeap, m_maxHeap;
    int m_currChunkIdx = -1;

    Dynamic_Median() {
        m_minHeap = new PQ_f(6);
        m_maxHeap = new PQ_f(6);
    }

    public float calcMedian() {

        float minDensity = m_minHeap.min();
        float maxDensity = -m_maxHeap.min();

        if (m_minHeap.Size() != m_maxHeap.Size())
            return minDensity;
        return (minDensity < maxDensity) ? minDensity : maxDensity;
    }

    public void insert(Float n) {
        m_minHeap.insert(n);
        Float tempN = m_minHeap.getmin();

        m_maxHeap.insert(-tempN);

        if (m_maxHeap.Size() > m_minHeap.Size())
            m_minHeap.insert(-m_maxHeap.getmin());
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1)
            System.out.println("Argument length should be 1");
        String file_name = args[0];

        File fn = new File(file_name);
        FileReader fr = new FileReader(fn);
        BufferedReader br = new BufferedReader(fr);

        Dynamic_Median dynMed = new Dynamic_Median();

        String line;
        int currLineNum = 1;
        while ((line = br.readLine()) != null) {
            String[] currLine = line.split(" ");
            City curCity = new City(currLine[0], currLine[1], currLine[2], currLine[3]);

            float calculateMedianDensity = curCity.calculateMedianDensity();
            System.out.println(calculateMedianDensity);

            dynMed.insert(calculateMedianDensity);

            if(currLineNum == 5){
                System.out.printf("Median: %.1f\n", dynMed.calcMedian());
                currLineNum = 0;
            }
            ++currLineNum;    
        }
    }
}
