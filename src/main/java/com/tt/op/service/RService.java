package com.tt.op.service;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * Created by tty on 24/01/2018.
 */
public interface RService {
    String eval_cmd(String RCmd) throws RserveException, REXPMismatchException;
}
