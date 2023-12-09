public class PriorityQueue {
    private City[] m_pq;
    private int m_size;
    private int N;

    private boolean more(int i, int j) {
        return m_pq[i].compareTo(m_pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        City temp = m_pq[i];
        m_pq[i] = m_pq[j];
        m_pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && more(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k, int N) {
        while(2 * k <= N) {
            int j = 2 * k;
            if (j < N && more(j, j+1)) j++;
            if (!more(k,j)) break;
            exchange(k,j);
            k = j;
        }
    }

    PriorityQueue(int maxN) {
        m_pq = new City[maxN + 1];
        N = 0;
    }

    boolean empty() {
        return N == 0;
    }

    void insert(City _city) {
        m_size++;
        m_pq[++N] = _city;
        swim(N);
    }

    int Size() {
        return m_size;
    }
    City getMax() {
        exchange(1, N);
        sink(1, N-1);
        return m_pq[N--];
    }
    

    void printQueue(int del) {
        int count = 0;
        while (count <= del) {
            if (m_pq[count] != null) {
                System.out.println(m_pq[count].calculateDensity());
            }
            count++;
        }
    }
}
    