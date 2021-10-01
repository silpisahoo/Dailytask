import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Dup_String {
    public static void main(String args[]){
        System.out.println("Please enter the String:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        if(input.equals("")){
            System.out.println("user did not give any data");
            System.exit(0);

        }
        else{
            for(int index=0;index<=input.length()-1;index++){
                char ch=input.charAt(index);
                if(map.containsKey(ch)){
                    int value=map.get(ch)+1;
                    map.put(ch,value);
                }else{
                    map.put(ch,1);
                }
            }

        }
        Dup_String obj=new Dup_String();
        obj.printDuplicate(map);
    }
    public void printDuplicate(HashMap<Character,Integer> map){
        Set<Character> set=map.keySet();
        Iterator<Character> it=set.iterator();
        int max=Integer.MIN_VALUE;
        Character maxRepeatedCharacter=null;
        Character key=null;
        while(it.hasNext()){
            key=it.next();
            if(map.get(key)>1){
                System.out.println(key+"---------"+map.get(key));
            }
            if(max<map.get(key)){
                max=map.get(key);
                maxRepeatedCharacter=key;
            }
        }
        System.out.println("Maximum occurring of that duplicate character- "+maxRepeatedCharacter+" in a given String is "+max);
    }
}
