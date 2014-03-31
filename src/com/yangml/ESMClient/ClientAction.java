package com.yangml.ESMClient;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.http.client.ClientProtocolException;

public class ClientAction extends BaseAction{
	private String assetNames;
	

	public String getAssetNames() {
		return assetNames;
	}


	public void setAssetNames(String assetNames) {
		this.assetNames = assetNames;
	}


	/**
	 * 从客户端返回perosn信息岛jsp页面去
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String getPersonClient() throws ClientProtocolException, IOException{
		//开始时间
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS"); 
		TimeZone t = sdf.getTimeZone(); 
		t.setRawOffset(0); 
		sdf.setTimeZone(t); 
		Long startTime = System.currentTimeMillis(); 
		String str = new ESMClient().getPersons(assetNames);
		//System.out.println("action="+str.toString());
		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().getWriter().print(str);
		//结束时间
		Long endTime = System.currentTimeMillis(); 
		System.out.println("需要的时间" + sdf.format(new Date(endTime - startTime))); 
		return null;
	}
	/**
	 * 返回所有的设备监控信息
	 * @return
	 */
	public String updateAsset(){
		//开始时间
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS"); 
		TimeZone t = sdf.getTimeZone(); 
		t.setRawOffset(0); 
		sdf.setTimeZone(t); 
		Long startTime = System.currentTimeMillis(); 
		String str = new ESMClient().getUpdateAssetInfo();
		//System.out.println("action="+str.toString());
		getResponse().setContentType("text/html;charset=UTF-8");
		try {
			getResponse().getWriter().print(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//结束时间
		Long endTime = System.currentTimeMillis(); 
		//System.out.println("up需要的时间" + sdf.format(new Date(endTime - startTime))); 
		return null;
	}
	/**
	 * 发送数据源到3D系统中，完成更新后返回success
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String sendUpdateData() throws ClientProtocolException, IOException{
		ESMClient ec = new ESMClient();
		String url = "http://10.0.0.120:8080/3d/assetinterface/asset!getUpdateAssetInfo";
		List<RackMount> list =new ESMDao().getAssetList("");
		JSONArray json = JSONArray.fromObject(list);
		
		//String json = ec.getUpdateAssetInfo();
		
		String res = ec.sendData(url, json.toString());
		System.out.println("esm return:"+res);
		getResponse().setContentType("text/html;charset=utf-8");
		getResponse().getWriter().print(res);
		return null;
	}
	/**
	 * 获取3d中的日志信息
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public String getOptLogData() throws ClientProtocolException, IOException{
		ESMClient ec = new ESMClient();
		String url = "http://10.0.0.120:8080/3d/assetinterface/asset!findOptLogInfo";
		//开始时间
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SS"); 
		TimeZone t = sdf.getTimeZone(); 
		t.setRawOffset(0); 
		sdf.setTimeZone(t); 
		Long startTime = System.currentTimeMillis(); 
		String str = new ESMClient().getoptLog(url);
		//System.out.println("action="+str.toString());
		getResponse().setContentType("text/html;charset=UTF-8");
		getResponse().getWriter().print(str);
		//结束时间
		Long endTime = System.currentTimeMillis(); 
		System.out.println("需要的时间" + sdf.format(new Date(endTime - startTime))); 
		return null;
	}
	
	public static void main(String[] args) {
		try {
			new ClientAction().sendUpdateData();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
