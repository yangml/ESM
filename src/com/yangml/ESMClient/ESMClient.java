package com.yangml.ESMClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class ESMClient {
	private static final String CHARSET = "UTF-8";
	
	public String getPersons(String assetNames) throws ClientProtocolException, IOException{
		 // 创建HttpClient实例     
        HttpClient httpclient = new DefaultHttpClient();  
        httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
        // 创建Get方法实例     
        HttpGet httpgets = new HttpGet("http://10.0.0.120:8080/3d/assetinterface/asset!getAssetList?assetNames="+assetNames);    
        HttpResponse response = httpclient.execute(httpgets);    
        HttpEntity entity = response.getEntity();
        String str=null;
        if (entity != null) {    
            InputStream instreams = entity.getContent();    
            str = convertStreamToString(instreams);  
            System.out.println("Do something");   
            System.out.println("PersonClient:"+str);  
            // Do not need the rest    
            httpgets.abort();    
        } 
        return str;
	}
    public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {  
    	
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,CHARSET));      
        StringBuilder sb = new StringBuilder();      
       
        String line = null;      
        try { 
            while ((line = reader.readLine()) != null) {  
                sb.append(line + "\n");      
            }      
        } catch (IOException e) {      
            e.printStackTrace();      
        } finally {      
            try {      
                is.close();      
            } catch (IOException e) {      
               e.printStackTrace();      
            }      
        }      
        return sb.toString();      
    }  	
//    public static String convertStreamToString(InputStream is) {      
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
//        StringBuilder sb = new StringBuilder();      
//       
//        String line = null;      
//        try {      
//            while ((line = reader.readLine()) != null) {  
//                sb.append(line + "\n");      
//            }      
//        } catch (IOException e) {      
//            e.printStackTrace();      
//        } finally {      
//            try {      
//                is.close();      
//            } catch (IOException e) {      
//               e.printStackTrace();      
//            }      
//        }      
//        return sb.toString();      
//    }  
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String str = new ESMClient().getPersons("yyy");
		System.out.println("Client:"+str);
	}
}
