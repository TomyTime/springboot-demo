package com.tt.op;

import com.tt.op.rserve.RserveClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RJavaServiceApplicationTests {

    public RConnection initRConnection() {
        RserveClient rserveClient = null;
        RConnection connection = null;
        try {
            rserveClient = new RserveClient("127.0.0.1", 6311);
            connection = rserveClient.getConnection();
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Test
    public void evilRCode() {
        RConnection connection = initRConnection();

        try {
            REXP rexp = connection.eval("R.version.string");
            System.out.println(rexp.asString());
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }

        connection.close();

    }

}
