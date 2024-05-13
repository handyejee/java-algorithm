package bfs_dfs;

import java.util.*;

public class B1260{

    static int n,m,v,s,e;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        A = new ArrayList[n+1];

        for (int i= 1; i<= n; i++){
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= m; i++){
            s = sc.nextInt();
            e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }

        for (int i = 1; i <= n; i++){
            Collections.sort(A[i]);
        }

        visited = new boolean[n+1];
        dfs(v);
        System.out.println();

        visited = new boolean[n+1];
        bfs(v);
        System.out.println();
    }

    public static void dfs(int node){
        System.out.print(node +" ");
        visited[node] = true;
        for (int i : A[node]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int now_node = q.poll();
            System.out.print(now_node + " ");
            for (int i:A[now_node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
