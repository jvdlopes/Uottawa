import javax.lang.model.element.Element;


public class ITIStringBuffer {
    
    SinglyLinkedList<String> list = new SinglyLinkedList<String>();

    boolean call = false;
    String last = "";
    public ITIStringBuffer() {
    }

    public ITIStringBuffer(String  firstString){
        call = false;
        last = firstString;
    }

    public void append(String nextString){
        list.add(nextString);
        call = true;
    }

    public String toString(){
        if(call){
            char[] temp;
            char[] ans;
            int length = 0;

            for (String x: list) {
                length += x.length();
            }
            length += last.length();
            
            ans = new char[length];
            for (int i = 0; i < last.length(); i++)
            {
                ans[i] = last.charAt(i);
            }
            int i = last.length();

            for (String x: list) {
                temp = x.toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    ans[i+j] = temp[j];
                } 
                i += temp.length;
            }

            last = new String(ans);
            list = new SinglyLinkedList<>();
            call = false;
        }

        return last;
    }
}
