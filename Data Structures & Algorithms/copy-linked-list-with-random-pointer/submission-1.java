/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node copyHead = new Node(-1);
        Node cur = head;
        Node curCopy = copyHead;
        int idx = 0;

        Map<Node, Integer> nodeIdxMap = new HashMap<>();
        Map<Integer, Node> idxToNodeMap = new HashMap<>();
        while (cur != null) {
            Node copyNode = new Node(cur.val);

            idxToNodeMap.put(idx, copyNode);
            nodeIdxMap.put(cur, idx);

            curCopy.next = copyNode;
            curCopy = copyNode;
            
            cur = cur.next;
            idx ++;
        }

        // Build the random reference
        cur = head;
        curCopy = copyHead.next;

        while (cur != null) {
            Node random = cur.random;
            int randomIdx = nodeIdxMap.getOrDefault(random, -1);
            Node copyNode = idxToNodeMap.getOrDefault(randomIdx, null);

            curCopy.random = copyNode;
            cur = cur.next;
            curCopy = curCopy.next;
        }
        
        return copyHead.next;
    }
}
