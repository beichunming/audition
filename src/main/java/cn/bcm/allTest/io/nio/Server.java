package cn.bcm.allTest.io.nio;

/**
 * @ClassName Server
 * @Author beichunming
 * @Date 2018/11/20 下午8:08
 */
public class Server {

    private static int DEFAULT_PORT = 12345;
    private static ServerHandle serverHandle;
    public static void start(){
        start(DEFAULT_PORT);
    }
    public static synchronized void start(int port){
        if(serverHandle!=null)
            serverHandle.stop();
        serverHandle = new ServerHandle(port);
        new Thread(serverHandle,"Server").start();
    }
    public static void main(String[] args){
        start();
    }
}
