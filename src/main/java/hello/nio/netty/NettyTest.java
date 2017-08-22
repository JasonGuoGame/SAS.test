package hello.nio.netty;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by scnyig on 8/21/2017.
 */
public class NettyTest {
    public static void main(String[] args) {
        Selector selector = null;
        ServerSocketChannel server = null;
        try {
            selector = Selector.open(); // 打开 Selector
            server = ServerSocketChannel.open(); // 打开 ServerSocketChannel
            server.socket().bind(new InetSocketAddress(80)); // 绑定端口
            server.configureBlocking(false); // 设置为非阻塞模式
            server.register(selector, SelectionKey.OP_ACCEPT); // 将 ServerSocketChannel 注册到 Selector 上
            while (true) {
                selector.select();
                for (Iterator<SelectionKey> i = selector.selectedKeys().iterator(); i.hasNext(); ) {
                    SelectionKey key = i.next();
                    i.remove();
                    if (key.isConnectable()) {
                        ((SocketChannel) key.channel()).finishConnect();
                    }
                    if (key.isAcceptable()) {
                        // accept connection
                        SocketChannel client = server.accept(); // 接受 TCP 连接
                        client.configureBlocking(false);
                        client.socket().setTcpNoDelay(true);
                        client.register(selector, SelectionKey.OP_READ); // 将 SocketChannel 注册到 Selector 上
                    }
                    if (key.isReadable()) {
                        // ...read messages...
                    }
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Server failure: " + e.getMessage());
        } finally {
            try {
                selector.close();
                server.socket().close();
                server.close();
//                stopped();
//            } catch (Exception e) {
                // do nothing - server failed
            }catch (Exception e) {

            }
        }
    }
}
