package com.yangml.ESMClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;


public class ESMClient {
	private static final String CHARSET = "UTF-8";
    private long startTime = 0L;
    private long endTime = 0L;
	
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
            //System.out.println("Do something");   
            //System.out.println("PersonClient:"+str);  
            // Do not need the rest    
            httpgets.abort();    
        } 
        return str;
	}
	public String getoptLog(String url) throws ClientProtocolException, IOException{
		 // 创建HttpClient实例     
       HttpClient httpclient = new DefaultHttpClient();  
       httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
       // 创建Get方法实例     
       HttpGet httpgets = new HttpGet(url);    
       HttpResponse response = httpclient.execute(httpgets);    
       HttpEntity entity = response.getEntity();
       String str=null;
       if (entity != null) {    
           InputStream instreams = entity.getContent();    
           str = convertStreamToString(instreams);  
           //System.out.println("Do something");   
           //System.out.println("PersonClient:"+str);  
           // Do not need the rest    
           httpgets.abort();    
       } 
       return str;
	}
    public static String convertStreamToString(InputStream is) throws UnsupportedEncodingException {  
    	
		//开始时间
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS"); 
		TimeZone t = sdf.getTimeZone(); 
		t.setRawOffset(0); 
		sdf.setTimeZone(t); 
		Long startTime = System.currentTimeMillis(); 
    	
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
		//结束时间
		Long endTime = System.currentTimeMillis(); 
		System.out.println("IO需要的时间" + sdf.format(new Date(endTime - startTime))); 
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
	public String  getUpdateAssetInfo(){
		String rm = "[{\"phomeip\":\"93.201.131.200\","+
		"\"rackId\":\"3FE980B9239A4D5885EF73E0A7FB3A25\","+
		"\"rmId\":\"14A6065095E14B489BE860EE736FCD43\","+
		"\"rmClass\":\"Storage-Tape\","+
		"\"rmCpuCore\":\"40\","+
		"\"rmCpuHz\":\"3.4\","+
		"\"rmCpuNumber\":\"4\","+
		"\"rmCpuType\":\"cputype01\","+
		"\"rmIsCD\":\"0\","+
		"\"rmLocation\":33,"+
		"\"rmMEslotNm\":0,"+
		"\"rmMemory\":\"4\","+
		"\"rmMemoryType\":\"m4\","+
		"\"rmPortNum\":\"20\","+
		"\"rmPortSpeed\":\"10\","+
		"\"rmPower\":\"220\","+
		"\"rmPowerInput\":\"220\","+
		"\"rmPowerNumber\":\"4\","+
		"\"rmPowerOutput\":\"320\","+
		"\"rmStandard\":\"1*2*3\","+
		"\"rmStatus\":\"在用\","+
		"\"rmStorage\":\"100\","+
		"\"rmSystem\":\"ubuntu\","+
		"\"rmType\":\"7212-103\","+
		"\"rmWorkhumidity\":\"20\","+
		"\"rmWorktemps\":\"30\","+
		"\"rmnetworknum\":\"2\","+
		"\"rmsbladeio\":\"0\",},{\"phomeip\":\"93.201.131.200\","+
		"\"rackId\":\"3FE980B9239A4D5885EF73E0A7FB3A25\","+
		"\"rmId\":\"1\","+
		"\"rmClass\":\"Storage-Tape\","+
		"\"rmCpuCore\":\"40\","+
		"\"rmCpuHz\":\"3.4\","+
		"\"rmCpuNumber\":\"4\","+
		"\"rmCpuType\":\"cputype01\","+
		"\"rmIsCD\":\"0\","+
		"\"rmLocation\":33,"+
		"\"rmMEslotNm\":0,"+
		"\"rmMemory\":\"4\","+
		"\"rmMemoryType\":\"m4\","+
		"\"rmPortNum\":\"20\","+
		"\"rmPortSpeed\":\"10\","+
		"\"rmPower\":\"220\","+
		"\"rmPowerInput\":\"220\","+
		"\"rmPowerNumber\":\"4\","+
		"\"rmPowerOutput\":\"320\","+
		"\"rmStandard\":\"1*2*3\","+
		"\"rmStatus\":\"在用\","+
		"\"rmStorage\":\"100\","+
		"\"rmSystem\":\"ubuntu\","+
		"\"rmType\":\"7212-103\","+
		"\"rmWorkhumidity\":\"20\","+
		"\"rmWorktemps\":\"30\","+
		"\"rmnetworknum\":\"2\","+
		"\"rmsbladeio\":\"0\",},{\"phomeip\":\"93.201.131.200\","+
		"\"rackId\":\"3FE980B9239A4D5885EF73E0A7FB3A25\","+
		"\"rmId\":\"2\","+
		"\"rmClass\":\"Storage-Tape\","+
		"\"rmCpuCore\":\"40\","+
		"\"rmCpuHz\":\"3.4\","+
		"\"rmCpuNumber\":\"4\","+
		"\"rmCpuType\":\"cputype01\","+
		"\"rmIsCD\":\"0\","+
		"\"rmLocation\":33,"+
		"\"rmMEslotNm\":0,"+
		"\"rmMemory\":\"4\","+
		"\"rmMemoryType\":\"m4\","+
		"\"rmPortNum\":\"20\","+
		"\"rmPortSpeed\":\"10\","+
		"\"rmPower\":\"220\","+
		"\"rmPowerInput\":\"220\","+
		"\"rmPowerNumber\":\"4\","+
		"\"rmPowerOutput\":\"320\","+
		"\"rmStandard\":\"1*2*3\","+
		"\"rmStatus\":\"在用\","+
		"\"rmStorage\":\"100\","+
		"\"rmSystem\":\"ubuntu\","+
		"\"rmType\":\"7212-103\","+
		"\"rmWorkhumidity\":\"20\","+
		"\"rmWorktemps\":\"30\","+
		"\"rmnetworknum\":\"2\","+
		"\"rmsbladeio\":\"0\",}]";
		
		return rm;
	}
    
	/**
	 * 请求并发送数据到3D系统
	 * @param url
	 * @param json
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @return 返回服务器段的响应
	 */
	public String sendData(String url,String json) throws ClientProtocolException, IOException{
		//SingleClientConnManager sccm =new SingleClientConnManager();
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		//建立一个NameValuePair数组，用于存储欲传送的参数
		params.add(new BasicNameValuePair("data", json));
		StringBuilder sb=new StringBuilder();
		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			startTime = System.currentTimeMillis();
			HttpResponse response = httpclient.execute(httppost);
			endTime = System.currentTimeMillis();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("调用API 花费时间(单位：毫秒)：" + (endTime - startTime));
			HttpEntity resEntity = response.getEntity(); 
			InputStreamReader reader = new InputStreamReader(resEntity.getContent(), "utf-8");
			char[] buff = new char[1024]; 
            int length = 0; 
            while ((length = reader.read(buff)) != -1) { 
            		sb.append(new String(buff, 0, length));
                    System.out.println("esm:"+new String(buff, 0, length)); 
                    httpclient.getConnectionManager().shutdown(); 
            } 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
		
	}
	
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//String str = new ESMClient().getPersons("yyy");
		//System.out.println("Client:"+str);
		System.out.println(new ESMClient().getUpdateAssetInfo());
	}
}
