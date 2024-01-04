public class PQ_f {
    private int m_capacity;
    private Float[] m_pq;
    private int m_size;
    private int N;
    
    PQ_f(int Capacity) {
        m_capacity = Capacity;
        m_pq = new Float[m_capacity + 1];
        m_size = 0;
        N = 0;
    }

    private boolean checkArray() {
        return (float)m_size / (float)m_capacity >= 0.75;
    }

    private boolean moreThan(int i, int j) {
        return m_pq[i].compareTo(m_pq[j]) > 0;
    }
    
    private void exchange(int i, int j) {
        float temp = m_pq[i];
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
    
    private void resize() {
        if(checkArray()) {
            Float[] tempArray = new Float[m_capacity];
            for(int i = 1;i <= m_size; i++) {
                tempArray[i] = m_pq[i];
            }
            m_capacity *= 2;
            m_pq = new Float[m_capacity];
            for(int i = 0;i <= m_size; i++) {
                m_pq[i] = tempArray[i];
            }
        }
    }

    private void Index_remove(int idx){
        --m_size;
        exchange(idx, N);
        sink(1, N-1);
    }

    public boolean isEmpty() {
        return N == 0;
    }
    
    public void insert(Float num) {
        m_size++;
        resize();
        m_pq[++N] = num;
        swim(N);
    }
    
    public void removeLast(){
        Index_remove(m_size);
    }

    public int Size() {
        return m_size;
    }

    public Float min(){
        return m_pq[1];
    }

    public Float getmin() {
        // --m_size;
        // exchange(1, N);
        // sink(1, N-1);
        Index_remove(1);
        return m_pq[N--];
    }
}
