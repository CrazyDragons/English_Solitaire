package com.project.hzwlcd.english_solitaire;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Project EnglishSolitaire/com.project.hzwlcd.english_solitaire/Utils
 * Created by HZW
 * Data 2017/10/19
 * Time 13:55
 */

public class Utils {

    private static String http_address = "http://192.168.23.102:8080";

    public static String Get_Http_address(){
        return http_address;
    }

    public static void setHttp_address(String http_address) {
        http_address = http_address;
    }

    static void SendToServer(final int user_id, final String word, final String msg_type){
        new Thread(){
            @Override
            public void run() {
                try {
//                    String path = Get_Http_address()+"/MyServer/Login";
                    String path = "http://192.168.24.113:8080/MyServer/login";
                    String data = "user_id="+user_id+"&word="+word+"&msg_type="+msg_type+"";

                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    System.out.println(connection);
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    connection.setRequestProperty("Content-Length", data.length()+"");
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(data.getBytes());

                    int code = connection.getResponseCode();

                    if (code == 200){
                        // TODO: 2017/10/19 你在这里写成功访问服务器时的操作，这里的方法可能只需要返回响应码就行，操作在activity里写
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                super.run();
            }
        }.start();
    }
}
