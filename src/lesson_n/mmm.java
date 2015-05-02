package lesson_n;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by odogryk on 26.04.2015.
 */
public class mmm {
    public static void main(String[] args) {
        Map<Long, String> files = new HashMap<>();
        files.put(98273873L, "I:\\1.txt");
        files.put(976575697L, "I:\\2.txt");
        files.put(98273L, "I:\\3.txt");

        Object st;
//        st.

        Set<Long> fileKeys = files.keySet();

        for ( Long f : fileKeys)
            System.out.println(files.get(f));

        for ( Map.Entry<Long, String> f : files.entrySet())
            System.out.println(f.toString());
    }

}
