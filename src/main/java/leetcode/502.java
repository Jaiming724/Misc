class Pair implements Comparable<Pair> {
    Integer c;
    int p;

    public Pair(int c, int p) {
        this.c = c;
        this.p = p;
    }

    @Override
    public int compareTo(Pair o) {
        return this.c.compareTo(o.c);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", p=" + p +
                '}';
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> capitalPQ = new PriorityQueue<>();
        
        
        PriorityQueue<Integer> profitPQ = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<capital.length;i++){
            capitalPQ.add(new Pair(capital[i], profits[i]));
        }
        for(int i=0;i<k;i++){

            while(capitalPQ.size()>0 && capitalPQ.peek().c<=w){
                
                profitPQ.add(capitalPQ.poll().p);
            }
            if(profitPQ.size()<=0){
                return w;
            }
            int p = profitPQ.poll();
            w+=p;

        }
        return w;
    }
}