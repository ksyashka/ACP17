package testtask.readandsort;

        import java.io.FileInputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

public class Config {

    private int frequency;

    public void setFrequency() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(prop.getProperty("PATH"));
            frequency = Integer.parseInt(prop.getProperty("FREQ"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
