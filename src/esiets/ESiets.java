package esiets;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class ESiets {
    
    private PriorityQueue rinda;
    private PriorityQueue prime_numbers;
    private int n;
    
    public ESiets (int n) {
        this.n = n;
        this.rinda = new PriorityQueue<Record>();
        this.prime_numbers = new PriorityQueue<Integer>();
        this.rinda.add(new Record(2,4));
        Search_prime_numbers();
    }
    
    public void Search_prime_numbers() {
        Record r;
        for (int i=3;i<n;i++) {
            r = (Record) this.rinda.peek();
            if (r.getValue()==i) {
                while(r.getValue()==i) {
                    this.rinda.poll();
                    this.rinda.add(
                            new Record(r.getKey(), r.getKey()+r.getValue()));
                    r = (Record) this.rinda.peek();
                }
            }
            else {
                this.rinda.add(new Record(i,i*2));
            }
        }
        
        while(true){
            r = (Record) this.rinda.poll();
            if (r == null) {
                break;
            }
            else {
                this.prime_numbers.add(r.getKey());
            }
        }
    }
    
    public PriorityQueue Get_prime_numbers() {
        return this.prime_numbers;
    }
    
    public void Print_prime_numbers() {
        PriorityQueue abc = new PriorityQueue<Integer>(this.prime_numbers);
        int a;
        while(true) {
            try {
                a = (Integer) abc.poll();
                System.out.println(a);
            } catch(Exception e) {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        ESiets e = new ESiets(1000);
        e.Print_prime_numbers();
        PriorityQueue result = new PriorityQueue<Integer>();
        result = e.Get_prime_numbers();
        System.out.println();
        System.out.println(result);
    }
    
}
