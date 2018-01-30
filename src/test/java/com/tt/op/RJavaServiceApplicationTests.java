package com.tt.op;

import com.tt.op.service.RService;
import org.junit.Test;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RJavaServiceApplicationTests extends BaseTest {

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

    @Test
    public void testApiAlive(){
        RequestBuilder request = get("/api/alive");
        try {
            mvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("status").value("ok"))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
