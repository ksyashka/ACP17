package reflection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

public class TestSerializer {

    Serializer serializer = new Serializer();


    private static Robot robot;
    private static String robotStr;

    @BeforeClass
    public static void beforeClass() {
        String[] commands = {"sing","dance","clean"};
        robot = new Robot(1, "DDRW2", 10000.0, commands, new Cat());

        robotStr = String.format("{\"id\":%s,\"model\":\"%s\",\"price\":%s,\"commands\":%s}",
                robot.getId(),
                robot.getModel(),
                robot.getPrice(),
                Arrays.toString(robot.getCommands()));
    }

    @Test
    public void _01testObjectToJSON() {
        String res = serializer.convertObjectToJSON(robot);
        Assert.assertEquals(robotStr, res);
    }

    @Test
    public void _02testJSONTOObject() {
        Object obj = serializer.convertJSONToObject(robotStr);
        Assert.assertEquals(robot, obj);
    }


}
