public class Edge{
    public int fromV;
    public int toV;
    public int weight;
    public Edge next;
    public Edge(int fromV, int toV, int weight){
        this.fromV = fromV;
        this.toV = toV;
        this.weight = weight;
        this.next = null;
    }
}