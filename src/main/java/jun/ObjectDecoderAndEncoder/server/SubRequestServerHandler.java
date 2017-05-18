package jun.ObjectDecoderAndEncoder.server;/**
 * Created by JuN on 2017/5/17.
 */


import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import jun.ObjectDecoderAndEncoder.entity.SubScribeRequest;
import jun.ObjectDecoderAndEncoder.entity.SubScribeResponse;

/**
 * @authorJuN
 * @create2017-05-17 12:37
 */
public class SubRequestServerHandler extends ChannelHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        SubScribeRequest request = (SubScribeRequest) msg;
        if ("JuN".equalsIgnoreCase(request.getUserName())){
            System.out.println("服务端收到请求为 : [" + request.toString() + "]");
            ctx.writeAndFlush(toResponse(request.getSubRequestId()));
        }
    }

    private SubScribeResponse toResponse(int subScribeRequestId){
        SubScribeResponse response = new SubScribeResponse();
        response.setSubRequestId(subScribeRequestId);
        response.setResponseCode(0);
        response.setDesc("预定请求成功，3天后，发送到指定地方");
        return response;
    }
}
