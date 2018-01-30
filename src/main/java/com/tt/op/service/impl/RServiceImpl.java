package com.tt.op.service.impl;

import com.tt.op.rserve.RServeClient;
import com.tt.op.service.RService;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by TomyTime on 24/01/2018.
 */
@Service
public class RServiceImpl implements RService {

    @Autowired
    private RServeClient rServeClient;

    @Override
    public String eval_cmd(String RCmd) throws RserveException, REXPMismatchException {

        RConnection connection = rServeClient.getConnection();
        REXP rexp = connection.eval(RCmd);
        connection.close();

        return rexp.asString();
    }
}
