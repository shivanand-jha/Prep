import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {
        private int node;
        private LinkedList<Integer> adj[];
        private Queue<Integer> que;
        BFS_Traversal(int v)
        {
            node = v;
            adj = new LinkedList[node];
            for (int i=0; i<v; i++)
            {
                adj[i] = new LinkedList<>();
            }
            que = new LinkedList<Integer>();
        }
        void insertEdge(int v,int w)
        {
            adj[v].add(w);      /* adding an edge to the adjacency list (edges are bidirectional in this example) */
        }
        void BFS(int n)
        {
            boolean nodes[] = new boolean[node];       /* initialize boolean array for holding the data */
            int a = 0;
            nodes[n]=true;
            que.add(n);       /* root node is added to the top of the queue */
            while (que.size() != 0)
            {
                n = que.poll();        /* remove the top element of the queue */
                System.out.print(n+" ");    /* print the top element of the queue */
                for (int i = 0; i < adj[n].size(); i++)  /* iterate through the linked list and push all neighbors into queue */
                {
                    a = adj[n].get(i);
                    if (!nodes[a])      /* only insert nodes into queue if they have not been explored already */
                    {
                        nodes[a] = true;
                        que.add(a);
                    }
                }
            }
        }
        public static void main(String args[])
        {
            BFS_Traversal GPH = new BFS_Traversal(6);
            GPH.insertEdge(0, 1);
            GPH.insertEdge(0, 3);
            GPH.insertEdge(0, 4);
            GPH.insertEdge(4, 5);
            GPH.insertEdge(3, 5);
            GPH.insertEdge(1, 2);
            GPH.insertEdge(1, 0);
            GPH.insertEdge(2, 1);
            GPH.insertEdge(4, 1);
            GPH.insertEdge(3, 1);
            GPH.insertEdge(5, 4);
            GPH.insertEdge(5, 3);
            System.out.println("Breadth First Traversal for the graph is:");
            GPH.BFS(0);
        }
}