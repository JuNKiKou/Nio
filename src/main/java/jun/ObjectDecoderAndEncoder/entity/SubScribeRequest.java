package jun.ObjectDecoderAndEncoder.entity;/**
 * Created by JuN on 2017/5/16.
 */

import java.io.Serializable;

/**
 * 订购请求POJO类定义
 *
 * @authorJuN
 * @create2017-05-16 15:45
 */
public class SubScribeRequest implements Serializable{

    private static final long serialVersionUID = 1L;

    private int subRequestId;

    private String userName;

    private String productName;

    private String phoneNumber;

    private String address;

    public int getSubRequestId() {
        return subRequestId;
    }

    public void setSubRequestId(int subRequestId) {
        this.subRequestId = subRequestId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SubscribeRequest [subRequestId=" + subRequestId +
                ",userName=" + userName +
                ",productName=" + productName +
                ",phoneNumber=" + phoneNumber +
                ",address=" + address + "]";
    }
}
