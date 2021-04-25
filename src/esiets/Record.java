package esiets;

public class Record implements Comparable<Record>{
    int key;
    int value;
    
    public Record(int k, int v) {
        key=k;
        value=v;
    }
    
    public int getKey() {
        return key;
    }
    
    public int getValue() {
        return value;
    }
    
    @Override
    public int compareTo(Record record) {
        return this.value - record.value;
    }
}
