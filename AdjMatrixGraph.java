// AdjMatrixGraph.java
//
// Implementation of an adjacency matrix representation of a graph
//
public class AdjMatrixGraph {
    private boolean[][] adjMatrix; // adjMatrix[i][j] is true iff there is an edge directed from i to j
    private int numVertices; // number of vertices in the graph, also number of rows/cols in adjMatrix[][]
    
    // Constructs a graph of V vertices and 0 edges. 
    // @param v number of vertices in the graph
    public AdjMatrixGraph( int v ) {
        adjMatrix = new boolean[v][v]; // this array is automatically initialized to all false values 
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
        adjMatrix[s][d] = true;
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
            for(int j = 0; j < numVertices; j++)
            {
                if (adjMatrix[i][j] == true)
                {
                    count++;
                }
            }
        }
        return count / 2; 
    }
    
    /**
     *  Returns the number of (undirected) edges adjacent to 
     *  vertex v.  If v is not a valid vertex number, returns -1.
     *  @return number of (undirected) edges adjacent to vertex v 
     */
    public int degree( int v ) {
        int count = 0;
        for(int i = 0; i < numVertices; i++)
        {
            if( adjMatrix[v][i] == true)
            {
                count++;
            }
        }
        return count;
    }
    
}