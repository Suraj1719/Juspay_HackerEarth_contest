Input : 
4
2
5
7
9
4
2 9
7 2
7 9
9 5
7
9
output: 2 7

Input : 4
1
2
3
4
4
1 4
2 3
3 4
1 3
1
4
output :1 3



code :

import java.util.LinkedList;
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
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,List<Integer>>from_to_time=new HashMap<>();  
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
            //from_to_time.get(from).add(to);
            from_to_time.get(to).add(from);
        }

        int src=sc.nextInt();
        int dest=sc.nextInt();

        Queue<Integer>q=new LinkedList<>();
        q.add(dest);
        List<Integer>ans=new ArrayList<>();
        Set<Integer>vis=new HashSet<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            vis.add(node);
            //Queue<Integer>temp=new LinkedList<>();
            List<Integer>cur=from_to_time.get(node);
            //boolean flag=false;
            for(int x:cur){
                //if(node==dest && x==src)ans.add(x);
                if(x==src){
                    //System.out.println(node);
                    if(node==dest)
                    ans.add(x);
                    else ans.add(node);
                    // flag=true;
                    // break;
                }else if(!vis.contains(x)) q.add(x);
            }
            //if(flag==false)

        }
        for(int x:ans){
            System.out.print(x+" ");
        }
        System.out.println();
    }
}
