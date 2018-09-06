package lombokTest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Test1 {
    private int id;
    private String name;
    private int age;

//    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.setName("nnn");
        System.out.println(t1.getName());

        log

    }
}
