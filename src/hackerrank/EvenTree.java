package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class EvenTree {

    private static Node[] tree;
    private static int totalCuts = 0;
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inps = br.readLine().split(" ");
        
        int n = Integer.parseInt(inps[0]), e = Integer.parseInt(inps[1]);
        
        tree = new Node[n+1];
        for(int i=1 ;i<=n; i++) {
            tree[i] = new Node(i);
        }
        
        for(int i=1; i<=e; i++) {
            inps = br.readLine().split(" ");
            int from = Integer.parseInt(inps[0]), to = Integer.parseInt(inps[1]);
            
            tree[from].children.add(to);
            tree[to].root = false;
        }
        
        for(int i=1 ;i<=n; i++) {
            Node node = tree[i];
            System.out.println(node.idx + " " + node.root);
        }
        
        Node root = null;
        for(Node node: tree) {
            if(node.root) {
                root = node;
                break;
            }
        }
        
        getCuts(root);
        
        System.out.println(totalCuts);
    }
    
    private static int getCuts(Node node) {
        int childCount = node.children.size();
        
        if(childCount == 0) {
            return node.childCount;
        }
        
        //System.out.println("getCuts with node id = " + node.idx);
        
        node.children.stream().map((idx) -> tree[idx]).map((nodeChild) -> getCuts(nodeChild)).forEachOrdered((subChild) -> {
            //System.out.println("calling child with id = " + nodeChild.idx);
            node.childCount += subChild;
        });
        
        if(node.childCount % 2 == 0) {
            ++totalCuts;
            return 0;
        }
        
        return node.childCount;
    }

    private static class Node {
        
        int childCount;
        int idx;
        HashSet<Integer> children = new HashSet<>();
        boolean root;
        
        public Node(int idx) {
            
            childCount = 1;
            this.idx = idx;
            root= true;
        }
    }
}