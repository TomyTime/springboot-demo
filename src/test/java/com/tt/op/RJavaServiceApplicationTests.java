package com.tt.op;

import com.tt.op.service.RService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RJavaServiceApplicationTests {

    @Autowired
    private RService rService;

    @Test
    public void evilRCode() {

        try {
            System.out.println();
            System.out.println(rService.eval_cmd("R.version.string"));
        } catch (RserveException | REXPMismatchException e) {
            e.printStackTrace();
        }

    }

}
