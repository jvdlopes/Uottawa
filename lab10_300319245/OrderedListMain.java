public class OrderedListMain {
    
    public static void main(String[] args){
        OrderedList List = new OrderedList();
        OrderedList List2 = new OrderedList();

        List2.add(1);
        List.add(5);
        List.add(3);
        List.add(6);
        List.add(7);
        List.add(2);

        //List.remove(0);
        System.out.println(List.size());
        for(int i = 0; i<5;i++){
            System.out.println(List.get(i));
        }

        // List.merge(List2);

        // for(int i = 0; i<List.size();i++){
        //     System.out.println(List.get(i));
        // }
    }
}
