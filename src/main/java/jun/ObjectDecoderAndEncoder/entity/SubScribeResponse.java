package jun.ObjectDecoderAndEncoder.entity;/**
 * Created by JuN on 2017/5/16.
 */

import java.io.Serializable;

/**
 * 订购应答POJO类
 *
 * @authorJuN
 * @create2017-05-16 15:53
 */
public class SubScribeResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private int subRequestId;

    private int responseCode;

    private String desc;

    public int getSubRequestId() {
        return subRequestId;
    }

    public void setSubRequestId(int subRequestId) {
        this.subRequestId = subRequestId;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SubscribeResponse [subRequestId=" + subRequestId +
                ",responseCode=" + responseCode +
                ",desc=" + desc + "]";
    }
}
