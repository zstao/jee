import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZSt on 2016/2/10.
 */
public class TestProp {

    @Test
    public void testJdbcProp(){

        try {
            Properties properties = new Properties();
            properties.load(TestProp.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            String username = properties.getProperty("driver");
            System.out.println(username);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
