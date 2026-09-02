import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapContainingLinkedList {
    static void demo(){
        LinkedList<Integer> llInt1 = new LinkedList<>();
        llInt1.add(11);
        llInt1.add(12);
        llInt1.add(13);

        LinkedList<Integer> llInt2 = new LinkedList<>();
        llInt2.add(21);
        llInt2.add(22);
        llInt2.add(23);

        LinkedList<Integer> llInt3 = new LinkedList<>();
        llInt3.add(31);
        llInt3.add(32);
        llInt3.add(33);


        Map<Integer,LinkedList<Integer>> st = new HashMap<>();
        st.put(100,llInt1);
        st.put(200,llInt2);
        st.put(300,llInt3);
        st.get(100).removeFirst();
        System.out.println(st);
    }
    static void main() {
        demo();
    }
}
