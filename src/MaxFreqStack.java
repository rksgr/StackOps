/*
895.
Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.

Implement the FreqStack class:

FreqStack() constructs an empty frequency stack.
void push(int val) pushes an integer val onto the top of the stack.
int pop() removes and returns the most frequent element in the stack.
If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

 */
// last line logic yet to be understood
import java.util.*;
class LinkedListPractice{
    static void main() {
        LinkedList<Integer> llInt = new LinkedList<>();
        llInt.add(10);
        llInt.add(20);
        llInt.add(30);
        llInt.addFirst(40);
        System.out.println(llInt);
    }
}

class MaxFreqStack {

    Map<Integer,LinkedList<Integer>> st;
    Map<Integer,Integer> map;
    int maxFreq;

    public MaxFreqStack(){
        st = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    public void push(int val) {
        int currFreq = map.getOrDefault(val,0);
        currFreq++;
        map.put(val,currFreq);
        if(st.containsKey(currFreq)==false){
            st.put(currFreq, new LinkedList<Integer>());
        }
        // addFirst since linked list to behave as stack,
        st.get(currFreq).addFirst(val);
        maxFreq = Math.max(maxFreq,currFreq);
    }


    public int pop() {
        // remove first since linked list to behave as stack
            int ans = st.get(maxFreq).removeFirst();
            int currFreq = map.get(ans);
            currFreq--;
            map.put(ans,currFreq);
            if(st.get(maxFreq).size() == 0){
                maxFreq--;
            }
            return ans;
         }

    static void main() {

    }
}


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
