Input : n=4
2
5
7
9
e 4
2 9
7 2
7 9
9 5
src=7
dest=9

Output: 1
  
Example -2 
  
Input : 4
1
2
3
4
3
1 2
3 4
2 1
1 
4
output 2: 0



  code : 
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,List<Integer>>from_to_time=new HashMap<>();     

        for(int i=0;i<n;i++){
            int x=sc.nextInt();
            from_to_time.put(x,new ArrayList<>());
        }

        int edge=sc.nextInt();
        for(int i=0;i<edge;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            from_to_time.get(from).add(to);
        }

        int src=sc.nextInt();
        int dest=sc.nextInt();
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        boolean flag=false;
        Set<Integer>vis=new HashSet<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            
            List<Integer>cur=from_to_time.get(node);
            vis.add(node);
            for(int x:cur){
                //if(x==node)continue;
                if(x==dest){
                    flag=true;
                    break;
                }else {
                    if(!vis.contains(x))
                    q.add(x);
                }
            }
        }
    if(flag==true)System.out.println(1);
    else System.out.println(0);

    }
}
