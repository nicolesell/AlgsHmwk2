// AdjListsGraph.java
//
// Implementation of an adjacency lists representation of a graph
//
public class AdjListsGraph {
    private ENode[] adjList;  // Entry adjList[i] either stores null or a reference to an ENode object,                               
    // which is the first node in vertex i's list of outgoing edges.
    private int numVertices;  // number of vertices

    public class ENode {
        private int dest;   // edge's destination vertex 
        private ENode next; // link to next node in adjacency list
        // constructor
        public ENode( int d, ENode n ) { dest = d; next = n; }
    }

    // Constructs a graph of V vertices and 0 edges. 
    // @param v number of vertices in the graph
    public AdjListsGraph( int v ) {
        adjList = new ENode[v]; // this array is automatically initialized to nulls 
        numVertices = v;
    }

    /**
     *  Adds a directed edge from vertex s to vertex d
     *  @param s source vertex of edge
     *  @param d destination vertex of edge
     */
    private void addDirectedEdge( int s, int d ) {
        // if parameters are invalid, just return
        if ( (s < 0) || (d < 0) || (s >= numVertices) || (d >= numVertices)) {
            System.out.println( "Invalid parameter to addEdge" );
            return;
        }

        // insert a new ENode at the beginning of the list
        adjList[s] = new ENode(d,adjList[s]);
    }

    /**
     *  Adds an udirected edge between vertex v1 and v2
     *  @param v1 one vertex of the edge
     *  @param v2 the other vertex of the edge
     */
    public void addEdge( int v1, int v2 ) {
        addDirectedEdge( v1, v2 );
        addDirectedEdge( v2, v1 );
    }

    /**
     *  Returns the number of (undirected) edges in the graph
     *  @return number of (undirected) edges in the graph 
     */
    public int numEdges() {
        int count = 0;
        for(int i = 0; i < numVertices; i++)
        {
            ENode cur = adjList[i];           
            while(cur != null)
            {
                count++;
                cur = cur.next;
            }           
        }
        return count/2;
    }

    /**
     *  Returns the number of (undirected) edges adjacent to 
     *  vertex v.  If v is not a valid vertex number, returns -1.
     *  @return number of (undirected) edges adjacent to vertex v 
     */
    public int degree( int v ) {
        ENode cur = adjList[v];
        int count = 0;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     *  This method determines if the graph contains an Euler circuit. 
     *  You may assume that the graph calling the method is a connected graph.
     *  @return true if the graph contains an Euler circuit, and false otherwise
     */
    public boolean hasEulerCircuit() {
        int count = 0;
        boolean hasEuler = true;
        for(int i = 0; i < numVertices; i++)
        {
            if(degree(i) % 2 != 0)
            {
                hasEuler = false;
            }
        }
        return hasEuler;
    }

    /**
     *  A ring graph is an undirected graph in which the edges connect the vertices 
        *  into a single cycle, or a ring. In such a graph, each vertex has degree two, 
     *  and the total number of (undirected) edges is |V|.
     *  This method returns true if the graph is a ring graph, and false otherwise.
     *  @return true if the graph is a ring graph, and false otherwise
     */
    public boolean isRingGraph() {
        boolean isRingGraph = true;
        for(int i = 0; i < numVertices; i++)
        {
            if(degree(i) != 2)
            {
                isRingGraph = false;
            }
        }
        
        int count = 1;
        ENode start = adjList[0];
        ENode cur = adjList[start.dest];     
        while(cur != start)
        {
            cur = adjList[cur.dest];
            count++;
        }
        
        if(count != numEdges())
        {
            isRingGraph = false;
        }
        
        if(numEdges() != numVertices)
        {
            isRingGraph = false;
        }

        return isRingGraph;        
    }
}
