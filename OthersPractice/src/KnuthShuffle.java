import java.util.*;

public class KnuthShuffle {
    public static void main(String[] args){
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        list1.add(8);

        Random r = new Random();
        int last = list1.size() - 1;
        for (int i = last; i >= 0; --i)
        {
            //select a random index number to be swap
            int selection = r.nextInt(i + 1);

            // swap the position of two numbers
            int temp = list1.get(i);
            list1.set(i, list1.get(selection));
            list1.set(selection, temp);
        }
        System.out.println(list1.toString());
    }
}
