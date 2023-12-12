public class City implements CityInterface, Comparable<City> {
    private int m_ID;
    private String m_Name;
    private int m_population;
    private int m_InfluenzaCases;
    
    City(int ID, String Name, int population, int InfluenzaCases){
        m_ID = ID;
        m_Name = Name;
        m_population = population;
        m_InfluenzaCases = InfluenzaCases;
    }

    City(String ID, String Name, String population, String InfluenzaCases){
        m_ID = Integer.parseInt(ID);
        m_Name = Name;
        m_population = Integer.parseInt(population);
        m_InfluenzaCases = Integer.parseInt(InfluenzaCases);
    }
    
    public int getID() {
        return m_ID;
    }
    
    public String getName() {
        return m_Name;
    }
    
    public int getPopulation() {
        return m_population;
    }
    
    public int getInfluenzaCases() {
        return m_InfluenzaCases;
    }
    
    public void setID(int ID) {
        m_ID = ID;
    }
    
    public void setName(String name) {
        m_Name = name;
    }
    
    public void setPopulation(int population) {
        m_population = population;
    }
    
    public void setInfluenzaCases(int InfluenzaCases) {
        m_InfluenzaCases = InfluenzaCases;
    }

    public float calculateDensity() {
        return (float)m_InfluenzaCases / (float)m_population;
    }

    public int compareTo(City o) {
        if (Float.compare(calculateDensity(), o.calculateDensity()) != 0) 
            return Float.compare(calculateDensity(), o.calculateDensity());
        if (m_Name.compareTo(o.getName()) != 0) 
            return m_Name.compareTo(o.getName());
        return Integer.compare(m_ID, o.getID()); 
    }

    public String toString() {
        return m_Name;
    }
}