package jun.ObjectDecoderAndEncoder.client;/**
 * Created by JuN on 2017/5/17.
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * 预购请求的客户端实现
 *
 * @authorJuN
 * @create2017-05-17 12:53
 */
public class SubRequestClient {

    public void connect(int port,String host) throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new ObjectDecoder(
                                    1024,
                                    ClassResolvers.cacheDisabled(this.getClass().getClassLoader()))
                            );
                            socketChannel.pipeline().addLast(new ObjectEncoder());
                            socketChannel.pipeline().addLast(new SubRequestClientHandler());
                        }
                    });

            ChannelFuture future = bootstrap.connect(host,port).sync();

            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }


    }

    public static void main(String[] args) throws Exception{
        int port = 7878;
        String host = "127.0.0.1";
        if (args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        new SubRequestClient().connect(port,host);
    }

}
