public class AdjacencyList {
    public Edge[] adjacencyList;
    public boolean check;

    public AdjacencyList(int vertices, boolean check){
        this.check=check;
        adjacencyList = new Edge[vertices];
    }

    //Inspired By AIB sir;
    //Not a part of the assignmnet (Adjacency matrix -> Adjacency List);
    public AdjacencyList(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]!=0){
                    addEdge(i, j, matrix[i][j]);
                }
            }
        }
    }

    public void addEdge(int src, int des, int wght){
        //For Undirected-graph;
        if(!check){
            if(hasEdge(src, des)){
            Edge n = adjacencyList[src];
            while(n!=null){
                if(n.fromV==des){
                    n.weight = wght;
                    return; //Work done here so break the method;
                }
                n = n.next;
                }
            }
            else{
                Edge newEdge = new Edge(src, des, wght);
                if(adjacencyList[src]==null){
                    adjacencyList[src]=newEdge;
                }
                else{
                    //Append Linked List;
                    appendLL(adjacencyList[src], newEdge);
                }
            }
            //Vice-versa;
            if(hasEdge(des, src)){
            Edge n = adjacencyList[src];
            while(n!=null){
                if(n.fromV==src){
                    n.weight = wght;
                    return; //Work done here so break the method;
                }
                n = n.next;
                }
            }
            else{
                Edge newEdge = new Edge(des, src, wght);
                if(adjacencyList[des]==null){
                    adjacencyList[des]=newEdge;
                }
                else{
                    //Append Linked List
                    appendLL(adjacencyList[des], newEdge);
                }
            }
        }
        //for Directed-graph;
        else{
            if(hasEdge(src, des)){
            Edge n = adjacencyList[src];
            while(n!=null){
                if(n.fromV==des){
                    n.weight = wght;
                    return; //Work done here so break the method;
                }
                n = n.next;
                }
            }
            else{
                Edge newEdge = new Edge(src, des, wght);
                if(adjacencyList[src]==null){
                    adjacencyList[src]=newEdge;
                }
                else{
                    //Append Linked List;
                    appendLL(adjacencyList[src], newEdge);
                }
            }
        }
    }

    public void appendLL(Edge head, Edge nNode){
        Edge h = adjacencyList[head.fromV];
        if(nNode.toV<adjacencyList[head.fromV].toV){
            //destination node position is less than head position;
            //head will go next to the destination position;
            nNode.next = adjacencyList[head.fromV];
            adjacencyList[head.fromV] = nNode;
        }
        else{
            int idx=nNode.toV;
            while(h.next!=null && idx>h.next.toV){ 
                //checks where the node should enter;
                h = h.next;
            }
            if(h.next==null){ 
                //there is nothing next to head;
                h.next = nNode;
            }
            else{ 
                //The node occupies any position in the middle of a linked list;
                //any position means- want to insert '2' between '1' & '4';
                nNode.next = h.next;
                h.next = nNode;
            }
        }
    }
    
    public boolean hasEdge(int src, int des){
        Edge n = adjacencyList[src];
        while(n!=null){
            if(n.toV==des){
                return true;
            }
            n = n.next;
        }
        return false;
    }
    
    public void removeLL(int src, int des){
        //For Undirected-greph;
        if(!check){
            if(hasEdge(src, des)){
                Edge head = adjacencyList[src];
                while(head.next!=null && des>head.next.toV){
                    head=head.next;
                }
                if(head.toV==des){
                    //for removing head;
                    adjacencyList[src] = head.next;
                }
                else if(head.next==null){
                    //For removing last node;
                    head=null;
                }
                else{
                    //For removing any node from the middle;
                    head.next = head.next.next;
                }
            }
            //Vice-versa;
            if(hasEdge(des, src)){
                Edge head = adjacencyList[des];
                while(head.next!=null && src>head.next.toV){
                    head=head.next;
                }
                if(head.toV==src){
                    //for removing head;
                    adjacencyList[des] = head.next;
                }
                else if(head.next==null){
                    //For removing last node;
                    head=null;
                }
                else{
                    //For removing any node from the middle;
                    head.next = head.next.next;
                }
            }
        }
        //For Directed-graph;
        else{
            if(hasEdge(src, des)){
                Edge head = adjacencyList[src];
                while(head.next!=null && des>head.next.toV){
                    head=head.next;
                }
                if(head.toV==des){
                    //for removing head;
                    adjacencyList[src] = head.next;
                }
                else if(head.next==null){
                    //For removing last node;
                    head=null;
                }
                else{
                    //For removing any node from the middle;
                    head.next = head.next.next;
                }
            }
        }
    }

    public int[] findMaxVer(Edge[] adjacencyList){
        int max[] = new int[2];
        for(int i=0; i<adjacencyList.length; i++){
            int tempSum=0;
            Edge head = adjacencyList[i];
            while(head!=null){
                tempSum++;
                head = head.next;
            }
            if(i==0 || max[1]<tempSum){
                max[0] = i;
                max[1]=tempSum;
            }
        }
        return max;
    }

    public int[] findMaxWeight(Edge[] adjacencyList){
        int max[] = new int[2];
        for(int i=0; i<adjacencyList.length; i++){
            int tempSum=0;
            Edge head = adjacencyList[i];
            while(head!=null){
                tempSum+=head.weight;
                head = head.next;
            }
            if(i==0 || max[1]<tempSum){
                max[0] = i;
                max[1]=tempSum;
            }
        }
        return max;
    }

    public void convert(Edge[] adjacencyList){
        check = false;
        for(int i=0; i<adjacencyList.length; i++){
            Edge head = adjacencyList[i];
            while(head!=null){
                addEdge(head.toV,head.fromV,head.weight);
                head = head.next;
            }
        }
        printAdjacencyList(adjacencyList);
    }

    public void printAdjacencyList(Edge[] adjacencyList){
        for(int i=1; i<adjacencyList.length; i++){
            System.out.print(i+": ");
            printLL(adjacencyList[i]);
            System.out.println();
        }
    }

    private void printLL(Edge head){
        Edge h = head;
        while(h!=null){
            System.out.print("<"+h.fromV+"-"+h.toV+": "+h.weight+"> ");
            h=h.next;
        }
    }
}
