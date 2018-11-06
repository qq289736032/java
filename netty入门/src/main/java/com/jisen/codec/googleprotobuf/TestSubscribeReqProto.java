package com.jisen.codec.googleprotobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by jisen on 2018/11/5.
 * SubscribeReqProto
 * SubscribeReq
 */
public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req){
        return req.toByteArray();
    }
    private static SubscribeReqProto.SubscribeReq decode(byte[] body) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(body);
    }
    private static SubscribeReqProto.SubscribeReq createSubscribeReq(){
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqID(1);
        builder.setUserName("jisen");
        builder.setProductName("netty book");
        builder.setAddress("address1");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("Before encode:"+req.toString());
        SubscribeReqProto.SubscribeReq req2 = decode(encode(req));
        System.out.println("After decode:"+req.toString());
        System.out.println("Assert equal:-->"+req2.equals(req));
    }
}
