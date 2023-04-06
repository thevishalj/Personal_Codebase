import java.util.HashMap;
import java.util.Map;

public class Map_Java {
    public static void main (String a[]){
        Map<String, Integer> Emp = new HashMap<>();

        Emp.put("Vishal", 10);
        Emp.put("Himasree", 45);
        Emp.put("Vivek", 46);
        Emp.put("Savio", 48);
        Emp.put("Vishal", 50);         //Key is unique, there can't be 2 keys.

        System.out.println(Emp);

        for(String key: Emp.keySet()){
            System.out.println(key + ":" + Emp.get(key));
        }
    }
}
