package com.tt.op.rserve;

import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tty on 23/01/2018.
 */
@Component
public class RServeClient {
    @Value("${rserve.host}")
    private String host;
    @Value("${rserve.port}")
    private Integer port;

    /**
     * @return
     * @throws RserveException
     */
    public RServeClient() throws RserveException {}

    /**
     * get connection
     * @return
     */
    public RConnection getConnection() throws RserveException {
        return new RConnection(host, port);
    }

}
