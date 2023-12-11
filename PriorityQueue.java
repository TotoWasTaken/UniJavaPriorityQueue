public class PriorityQueue {
    private City[] m_pq;
    private City currMin;
    private int m_size;
    private int N;

    private boolean moreThan(int i, int j) {
        return m_pq[i].compareTo(m_pq[j]) > 0;
    }

    private void exchange(int i, int j) {
        City temp = m_pq[i];
        m_pq[i] = m_pq[j];
        m_pq[j] = temp;
    }

    private void swim(int position) {
        while (position > 1 && moreThan(position/2, position)) {
            exchange(position, position/2);
            position = position/2;
        }
    }

    private void sink(int position, int N) {
        while(2 * position <= N) {
            int index = 2 * position;
            if (index < N && moreThan(index, index+1)) 
                index++;
            if (!moreThan(position, index)) 
                break;
            exchange(position, index);
            position = index;
        }
    }

    PriorityQueue(int Cap) {
        m_pq = new City[Cap + 1];
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

    City min(){
        return currMin;
    }

    City getmin() {
        exchange(1, N);
        sink(1, N-1);
        currMin = m_pq[N--];
        return currMin;
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
    