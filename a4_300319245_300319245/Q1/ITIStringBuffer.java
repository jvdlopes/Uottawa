import javax.lang.model.element.Element;


public class ITIStringBuffer {
    
    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    public ITIStringBuffer() {
    }

    public ITIStringBuffer(String  firstString){
        list.addFirst(firstString);
    }

    public void append(String nextString){
        list.add(nextString);
    }

    public String toString(){
        //public String(char[] "");
        char[] ans;
        char[] temp;
        int length = 0;
        for(String x:list){
            length += x.length();
        }

        ans = new char[length];
        int prev =0;
        for(String x:list){
            temp = x.toCharArray();
            for(int i = 0; i< temp.length;i++){
                ans[i+prev] = temp[i];
            }
            prev +=temp.length;
        }
        return ans.toString();
    }

}
