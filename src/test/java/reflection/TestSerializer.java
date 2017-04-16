package reflection;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class TestSerializer {

    Serializer serializer = new Serializer();


    private static Robot robot;
    private static String robotSimpleJson;
    private static String robotJson;

    private static RobotSimple robotSimple;

    @BeforeClass
    public static void beforeClass() {
        String[] commands = {"sing", "dance", "clean"};
        Cat cat = new Cat("Vasia");
        robot = new Robot(1, "DDRW2", 10000.0, commands, cat);
        robotJson = GsonSerializer.convertObjectToJson(robot);
        robotSimple = new RobotSimple(2, "DDRW2", 2000.20);
        robotSimpleJson = GsonSerializer.convertObjectToJson(robotSimple);
    }

    @Test
    public void _01testObjectToJSON() {
        String res = serializer.convertObjectToJSON(robot);
        Assert.assertEquals(robotJson, res);
    }

    @Test
    public void _02testJSONTOObject() {
        Object obj = serializer.convertJSONToObject(robotSimpleJson, RobotSimple.class);
        Assert.assertEquals(robotSimple, obj);
    }


}
