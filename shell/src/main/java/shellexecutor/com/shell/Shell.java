package shellexecutor.com.shell;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

    public static String execute(String cmd) {

        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
                process.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
            output.append(e.getLocalizedMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
            output.append(e.getLocalizedMessage());
        }

        return output.toString();

    }

}
