package Leetcode;

import java.util.*;

/**
 * Created by apple on 1/5/19.
 */
public class stockAnalysis {
    static LinkedHashMap<String, String> map;
    public static void stockAna(List<List<String>> datas){
        for (List<String> data : datas) {
            map.put(data.get(0), data.get(1));
        }

    }


    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
        int size = 2;
        map = new LinkedHashMap<>();
        List<List<String>> datas1 = new ArrayList<>();
        datas1.add(Arrays.asList("1", "2"));
        datas1.add(Arrays.asList("3", "1"));
        datas1.add(Arrays.asList("2", "4"));

        List<List<String>> datas2 = new ArrayList<>();
        datas2.add(Arrays.asList("1", "8"));
        datas2.add(Arrays.asList("2", "9"));
        datas2.add(Arrays.asList("4", "4"));
        List<List<String>> datas3 = new ArrayList<>();
        datas3.add(Arrays.asList("1", "9"));
        datas3.add(Arrays.asList("2", "8"));
        datas3.add(Arrays.asList("5", "10"));
//        List<String> res = new ArrayList<String>();
        stockAna(datas1);
        stockAna(datas2);
        stockAna(datas3);
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();

        while(it.hasNext())
        {
            String key = it.next();
            String value = map.get(key);
            //System.out.println(key + "=" + value);
            System.out.println(value);
        }


    }
}
