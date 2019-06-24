package cn.itcast.user.service;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author G.J.
 **/
public class UploadPic {
    private static final String URL = "https://ocr.piaoyoubang.com/api/uploadPic/billupload";

    private static final String TOKENVALUE = "dkADpfyhCsxpgn0g3vR";

    private static  String picid = "1";

    public static void main(String[] args) {
        try {
            //获取票据图片的流
            FileBody image = new FileBody(new File("/Users/olivia/Documents/bill.png"));
            StringBody tokenValue = new StringBody(TOKENVALUE, ContentType.create("text/plain", Consts.UTF_8));
            //StringBody noteType = new StringBody(notetype, ContentType.create("text/plain", Consts.UTF_8));
            StringBody picId = new StringBody(picid, ContentType.create("text/plain", Consts.UTF_8));

            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("image", image)
                    .addPart("tokenValue", tokenValue).addPart("picId", picId).build();
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(URL);
            httpPost.setEntity(reqEntity);

            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(httpPost);
                if (response.getStatusLine().getStatusCode() == 200) {
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println(content);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (response != null) {
                    response.close();
                }
                httpclient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
