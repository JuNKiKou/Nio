package jun.ObjectDecoderAndEncoder.client;/**
 * Created by JuN on 2017/5/17.
 */

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import jun.ObjectDecoderAndEncoder.entity.SubScribeRequest;
import jun.ObjectDecoderAndEncoder.entity.SubScribeResponse;

/**
 * @authorJuN
 * @create2017-05-17 12:59
 */
public class SubRequestClientHandler extends ChannelHandlerAdapter {
    public SubRequestClientHandler() {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++){
            ctx.write(submitRequest(i));
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("------");
        SubScribeResponse response = (SubScribeResponse) msg;
        System.out.println("收到服务端的响应 : [" + response.toString() + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    private SubScribeRequest submitRequest(int i){
        SubScribeRequest request = new SubScribeRequest();
        request.setAddress("杭州电子科技大学");
        request.setPhoneNumber("17764591485");
        request.setProductName("Netty 权威指南");
        request.setSubRequestId(i);
        request.setUserName("JuN");
        return request;
    }
}
