package com.tt.op.rserve;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * Created by tty on 23/01/2018.
 */
public class RserveClient {
    private RConnection connection;

    /**
     * @param host ip/domain
     * @param port prot
     * @return
     * @throws RserveException
     * @throws REXPMismatchException
     */
    public RserveClient(String host, int port) throws RserveException, REXPMismatchException {
        connection = new RConnection(host, port);
        System.out.format("连接 %s:%s 成功", host, port);
    }

    public RserveClient() throws RserveException {
        connection = new RConnection();
    }

    /**
     * get connection
     * @return
     */
    public RConnection getConnection(){
        return connection;
    }

    /**
     * close connection
     */
    public void closeConnection(){
        if(null != connection){
            connection.close();
        }
    }
}
