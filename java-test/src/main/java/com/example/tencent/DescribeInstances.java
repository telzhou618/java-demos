package com.example.tencent;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeInstancesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeInstancesResponse;

public class DescribeInstances {
    public static void main(String[] args) {
        try {
            Credential cred = new Credential("secretId", "secretKey");
            CvmClient client = new CvmClient(cred, "ap-shanghai");

//            VodClient vodClient = new VodClient(cred,"");
//            vodClient.ProcessMedia();

            DescribeInstancesRequest req = new DescribeInstancesRequest();
            DescribeInstancesResponse resp = client.DescribeInstances(req);

            System.out.println(DescribeInstancesResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
