package lombokTest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
public class Test1 {
    private int id;
    private String name;
    private int age;


    public void getLog(){
        log.info("呵呵呵呵呵呵");
    }

    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.getLog();
    }
}
