/**
 * Methods for testing lab practical code.
 * 
 */
public class TestGraphMethods
{

    public static void testAdjListsGraphMethods( ) {

        System.out.println("------------------------------------------------------------");
        System.out.println( "Testing AdjListsGraph method numEdges...." );
        int score = 0;
        try {
            int c;
            AdjListsGraph g1 = new AdjListsGraph(6);
            g1.addEdge( 0, 1 ); g1.addEdge( 0, 2 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 3); 
            c = g1.numEdges( );
            if ( c == 4 ) score++;

            g1.addEdge( 2, 4 ); g1.addEdge( 2, 5 ); g1.addEdge( 4,5);  
            c = g1.numEdges( );
            if ( c == 7 ) score++;
        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/2 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/2 points" );

        System.out.println( "Testing AdjListsGraph method degree(v)...." );
        score = 0;
        try {
            int c;
            AdjListsGraph g1 = new AdjListsGraph(6);
            g1.addEdge( 0, 1 ); g1.addEdge( 0, 2 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 3); 
            c = g1.degree( 0 );
            if ( c == 2 ) score++;
            c = g1.degree( 4 );
            if ( c == 0 ) score++;

            g1.addEdge( 2, 4 ); g1.addEdge( 2, 5 ); g1.addEdge( 4,5);  
            c = g1.degree( 2 );
            if ( c == 5 ) score++;
            c = g1.degree( 4 );
            if ( c == 2 ) score++;
        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/4 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/4 points" );

        
        
        System.out.println( "Testing AdjListsGraph method hasEulerCircuit...." );
        score = 0;
        try {
            boolean r;
            AdjListsGraph g1 = new AdjListsGraph(3);            
            g1.addEdge( 0, 1 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 0 ); 
            r = g1.hasEulerCircuit( );
            if ( r == true ) score++;

            AdjListsGraph g2 = new AdjListsGraph(6);
            g2.addEdge( 0, 1 ); g2.addEdge( 1, 2 ); g2.addEdge( 2, 3 ); g2.addEdge( 3, 4 ); 
            g2.addEdge( 4, 5 );  
            r = g2.hasEulerCircuit( );
            if ( r == false ) score++;

            AdjListsGraph g3 = new AdjListsGraph(6);
            g3.addEdge( 0, 1 ); g3.addEdge( 1, 2 ); g3.addEdge( 0, 4 ); g3.addEdge( 4, 5 ); 
            g3.addEdge( 3, 4 ); g3.addEdge( 1, 4 ); g3.addEdge( 3, 1 ); g3.addEdge( 5, 2 );
            r = g3.hasEulerCircuit( );
            if ( r == true ) score++;

            AdjListsGraph g4 = new AdjListsGraph(6);
            g4.addEdge( 0, 1 ); g4.addEdge( 1, 2 ); g4.addEdge( 2, 0 ); 
            g4.addEdge( 3, 4 ); g4.addEdge( 4, 5 ); g4.addEdge( 5, 3 ); g4.addEdge( 2, 3 );
            r = g4.hasEulerCircuit( );
            if ( r == false ) score++;
            
            AdjListsGraph g5 = new AdjListsGraph(6);
            g5.addEdge( 0, 1 ); g5.addEdge( 1, 2 ); g5.addEdge( 2, 3 ); g5.addEdge( 3, 4); 
            g5.addEdge( 4,5); g5.addEdge( 5,0); g5.addEdge( 0, 3 ); g5.addEdge( 2, 4 ); 
            g5.addEdge( 1, 5 );
            r = g5.hasEulerCircuit( );
            if ( r == false ) score++;

        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/5 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/5 points" );

        
        
        System.out.println( "Testing AdjListsGraph method ringGraph...." );
        score = 0;
        try {
            boolean r;
            AdjListsGraph g1 = new AdjListsGraph(3);
            // this is a ring graph
            g1.addEdge( 0, 1 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 0 );  
            r = g1.isRingGraph( );
            if ( r == true ) score++;

            AdjListsGraph g2 = new AdjListsGraph(6);
            // this is not a ring graph
            g2.addEdge( 0, 1 ); g2.addEdge( 1, 2 ); g2.addEdge( 2, 3 );
            g2.addEdge( 3, 4 ); g2.addEdge( 4, 2 ); g2.addEdge( 0, 5 );
            r = g2.isRingGraph( );
            if ( r == false ) score++;

            AdjListsGraph g3 = new AdjListsGraph(6);
            // this is a ring graph
            g3.addEdge( 5, 0 ); g3.addEdge( 0, 1 ); g3.addEdge( 1, 2 ); 
            g3.addEdge( 3, 4 ); g3.addEdge( 4, 5 ); g3.addEdge( 2, 3 );
            r = g3.isRingGraph( );
            if ( r == true ) score++;

            AdjListsGraph g4 = new AdjListsGraph(6);
            // this is not a ring graph
            g4.addEdge( 0, 1 ); g4.addEdge( 1, 2 ); g4.addEdge( 2, 0 ); 
            g4.addEdge( 3, 4 ); g4.addEdge( 4, 5 ); g4.addEdge( 5, 3 );
            r = g4.isRingGraph( );
            if ( r == false ) score++;
            
            AdjListsGraph g5 = new AdjListsGraph(6);
            // this is a ring graph
            g5.addEdge( 0, 2 ); g5.addEdge( 2, 4 ); g5.addEdge( 4, 5 ); 
            g5.addEdge( 5, 1 ); g5.addEdge( 1, 3 ); g5.addEdge( 3, 0 );
            r = g5.isRingGraph( );
            if ( r == true ) score++;

        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/5 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/5 points" );

    }

    public static void testAdjMatrixGraphMethods( ) {

        System.out.println("------------------------------------------------------------");
        System.out.println( "Testing AdjMatrixGraph method numEdges...." );
        int score = 0;
        try {
            int c;
            AdjMatrixGraph g1 = new AdjMatrixGraph(6);
             g1.addEdge( 0, 1 ); g1.addEdge( 0, 2 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 3); 
            c = g1.numEdges( );
            if ( c == 4 ) score++;

            g1.addEdge( 2, 4 ); g1.addEdge( 2, 5 ); g1.addEdge( 4,5);  
            c = g1.numEdges( );
            if ( c == 7 ) score++;
        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/2 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/2 points" );
        
        
        System.out.println( "Testing AdjMatrixGraph method degree(v)...." );
        score = 0;
        try {
            int c;
            AdjMatrixGraph g1 = new AdjMatrixGraph(6);
            g1.addEdge( 0, 1 ); g1.addEdge( 0, 2 ); g1.addEdge( 1, 2 ); g1.addEdge( 2, 3); 
            c = g1.degree( 0 );
            if ( c == 2 ) score++;
            c = g1.degree( 4 );
            if ( c == 0 ) score++;

            g1.addEdge( 2, 4 ); g1.addEdge( 2, 5 ); g1.addEdge( 4,5);  
            c = g1.degree( 2 );
            if ( c == 5 ) score++;
            c = g1.degree( 4 );
            if ( c == 2 ) score++;
        }
        catch ( Exception e ) {
            System.out.println( "    Exception thrown:" + e.getMessage() );
            System.out.println( "    Your implementation scored " + score + "/4 points" );

        }
        System.out.println( "    Your implementation scored " + score + "/4 points" );

    }

    public static void testAll( ) {
        testAdjMatrixGraphMethods();
        testAdjListsGraphMethods();
    }
}