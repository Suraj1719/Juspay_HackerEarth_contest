

code : shortest time using Dijkstra's algorithm using Priority Queue

Input :
n=4
2
5
7
9
e=4
2 9 2
7 2 3
7 9 7
9 5 1
src=7
dest=9

    output : min time = 5

import java.util.HashMap;
import java.util.*;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    static class Pair{
        int node,distance;
        Pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,List<int[]>>from_to_time=new HashMap<>();  
        int max_node_val=0;           
        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            max_node_val=Math.max(max_node_val,x);
            from_to_time.put(x,new ArrayList<>());
        }
        int edge=sc.nextInt();
        for(int i=0;i<edge;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            int time=sc.nextInt();
            from_to_time.get(from).add(new int[]{to,time});
            from_to_time.get(to).add(new int[]{from,time});
        }

        int src=sc.nextInt();
        int dest=sc.nextInt();
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.distance - b.distance);
        q.add(new Pair(0,src));
        int dist[]=new int[max_node_val+5];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        while(q.size()!=0){
            Pair cur=q.peek();
            int dis=cur.distance;
            int node=cur.node;
            q.remove();
            
            List<int[]>neighbors=from_to_time.get(node);
            for(int list[]:neighbors){
                int adjNode=list[0];
                int edge_wt=list[1];
                if(dist[adjNode]>dist[node]+edge_wt){
                    dist[adjNode]=dist[node]+edge_wt;
                    q.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }
        System.out.println(dist[dest]);
    }
}
