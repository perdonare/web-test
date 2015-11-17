package com.lance.test.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

/**
 * Created by perdonare on 2015/11/8.
 */
public class ProtobufTest {
    @Test
    public void testProtoReq() throws InvalidProtocolBufferException {
        GoodsReq.GoodsRequest request = createRequest();
        System.out.println("before:"+request);
        GoodsReq.GoodsRequest req = decode(encode(request));
        System.out.println("after:"+request);

    }

    private byte[] encode(GoodsReq.GoodsRequest request) {
        return request.toByteArray();
    }

    private GoodsReq.GoodsRequest decode(byte[] body) throws InvalidProtocolBufferException {
        return GoodsReq.GoodsRequest.parseFrom(body);
    }

    private GoodsReq.GoodsRequest createRequest() {
        GoodsReq.GoodsRequest.Builder builder = GoodsReq.GoodsRequest.newBuilder();
        return builder.setId(1)
                .setName("lance")
                .setNum(100)
                .setRequestCode("aaaa")
                .build();
    }


}
