public class PQ {
    private City[] m_pq;
    private int m_size;
    private int m_capacity;
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
    
    PQ(int Capacity) {
        m_capacity = Capacity;
        m_pq = new City[m_capacity + 1];
        m_size = 0;
        N = 0;
    }
    
    boolean isEmpty() {
        return N == 0;
    }
    
    private void resize() {
        if((float)m_size / (float)m_capacity >= 0.75) {
            City[] tempArray = new City[m_size + 1];
            for(int i = 1;i <= m_size; i++) {
                tempArray[i] = m_pq[i];
            }
            m_capacity *= 2;
            m_pq = new City[m_capacity];
            for(int i = 1;i <= m_size; i++) {
                m_pq[i] = tempArray[i];
            }
        }
    }
    
    void insert(City _city) {
        resize();
        m_size++;
        m_pq[++N] = _city;
        swim(N);
    }
    
    void remove(int ID) {
        int target = 0;
        boolean flag = false;
        for(int i = 0;i <= m_size;i++) {
            if (ID == m_pq[i].getID()) {
                target = i;
                flag = true;
                break;
            } 
        }
        if (flag) {
            exchange(target, N);
            sink(1, N-1);
        }
    } 
    
    int Size() {
        return m_size;
    }

    City min(){
        return m_pq[1];
    }

    City getmin() {
        exchange(1, N);
        sink(1, N-1);
        return m_pq[N--];
    }

    public int getCapacity() {
        return m_capacity;
    }
}
