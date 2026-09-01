/*
895.
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MaxFreqStack {

    Node head;
    Map<Integer,Integer> freqMap;
    public MaxFreqStack() {
        this.head = null;
        this.freqMap = new HashMap<>();
    }

    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
    }

    public int pop() {
        // keep the frequency of elements into a hashmap
        Node tempNode = this.head;
        while(tempNode != null){
            if(freqMap.containsKey(tempNode.val)){
                int freq = freqMap.get(tempNode.val);
                freqMap.put(tempNode.val,freq+1);
            }else{
                freqMap.put(tempNode.val, 1);
            }
            tempNode = tempNode.next;
        }
        // Iterate over the hashmap
        Set<Integer> keySet = freqMap.keySet();
        int maxFreq = -1;
        for(int key:keySet){
            int val = freqMap.get(key);
            if(val > maxFreq){
               maxFreq = val;
            }
        }

        return -1;
    }
}
class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
