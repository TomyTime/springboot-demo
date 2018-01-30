package com.tt.op.web;

import com.tt.op.service.RService;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TomyTime on 24/01/2018.
 */

@RestController
public class TestController {

    @Autowired
    private RService rService;

    @RequestMapping(value = "api/alive", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> index() {
        Map<String, String> retMap = new HashMap<>();
        retMap.put("status", "ok");

        return retMap;
    }

    @RequestMapping(value = "rserve/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> rserve_test(String cmd) {
        Map<String, String> retMap = new HashMap<>();

        try {
            retMap.put("info", rService.eval_cmd(cmd));
        } catch (RserveException | REXPMismatchException e) {
            retMap.put("info", cmd + " 命令执行异常");
            e.printStackTrace();
        }

        return retMap;
    }
}
