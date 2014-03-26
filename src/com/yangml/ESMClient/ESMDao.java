package com.yangml.ESMClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.jdbc.driver.OracleCallableStatement;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.yangml.db.DBUtil;

public class ESMDao {
	Connection connection = DBUtil.getConn();
	Connection connection1 = DBUtil.getConn();
	PreparedStatement psStatement = null;
	PreparedStatement psStatement1 = null;
	PreparedStatement ps = null;
	ResultSet rSet = null;
	ResultSet rSet1 = null;
	OracleCallableStatement cal = null;
	/**
	 * 设备组合查询
	 * @param assetCols[] 需要查询的列的数组
	 * @param assetNames [] 插叙的设备名称 
	 * @return List<RackMount>
	 * @throws UnsupportedEncodingException 
	 */
//	public List<RackMount> getAssetList(String [] assetCols,String[] assetNames) throws UnsupportedEncodingException {
	public List<RackMount> getAssetList(String assetNames) throws UnsupportedEncodingException {
			List<RackMount> list = new ArrayList<RackMount>();
			String assetsNames = "";
			String sql="select rm_id,rm_innum,rm_serialno,rm_name,rm_class,rm_type,rack_id,rack_name,rm_location,rm_vendor,rm_suppliers," +
						"rm_SP,rm_servicetype,rm_servicecon,rm_sv_starttime,rm_sv_endtime,rm_installtime,rm_durability,rm_use,rm_status,rm_user," +
						"rm_department,rm_org,rm_weight,rm_height,rm_system,rm_power_input,rm_power_output,rm_power_number,rm_power,rm_standard," +
						"rm_cpu_number,rm_cpu_type,rm_cpu_core,rm_cpu_hz,rm_memory,rm_memory_type,rm_MEslotNm,rm_port_num,rm_newwork_num," +
						"rm_port_speed,rms_pic,rm_isCD,rm_storage,rm_worktemps,rm_workhumidity,rm_createdate,rms_blade_io,p_homeip" +
						" from v_assetinfo rm where 1=1";
		try {
			System.out.println("dao="+assetNames);
			/**
			 * 获取查询资产的条件，如果为空时，默认查询多有数据
			 */
			String [] assetsNamesList=null;
			if(assetNames.equals("")||assetNames==null){
				
			}else{
				System.out.println("else");
				assetsNamesList =assetNames.split(",");
			}
			
			for(int i=0;assetsNamesList!=null&&i<assetsNamesList.length;i++){
				if(i==0){
					assetsNames = "'"+assetsNamesList[i]+"'";
				}else{
					assetsNames += ",'"+assetsNamesList[i]+"'";
				}
			}
			//System.out.println(assetNames+"ll="+assetNames.length);
			if(!assetNames.equals("")&&assetNames!=null){
				sql += " and rm.rm_name in ("+assetsNames+")";
			}else{
				
			}
			System.out.println("sql="+sql); 
			psStatement = connection.prepareStatement(sql);
			rSet = psStatement.executeQuery();
			while(rSet.next()){
					RackMount temp = new RackMount();
//					temp.setRoomsId(rSet.getString("R_ID"));
//					temp.setZoneId(rSet.getString("Z_ID"));
					temp.setRmId(rSet.getString("rm_id"));
					temp.setRmInnum(rSet.getString("rm_innum"));
					temp.setRmSerialno(rSet.getString("rm_serialno"));
					temp.setRmName(rSet.getString("rm_name"));
					temp.setRmClass(rSet.getString("rm_class"));
					temp.setRmType(rSet.getString("rm_type"));
					temp.setRackId(rSet.getString("rack_id"));
					temp.setRackName(rSet.getString("rack_name"));
					temp.setRmLocation(rSet.getInt("rm_location"));
					temp.setRmVendor(rSet.getString("rm_vendor"));
					temp.setRmSuppliers(rSet.getString("rm_suppliers"));
					temp.setRmSP(rSet.getString("rm_sp"));
					temp.setRmServicetype(rSet.getString("RM_SERVICETYPE"));
					temp.setRmServicecon(rSet.getString("RM_SERVICECON"));
					if(rSet.getDate("RM_INSTALLTIME")==null){
						String installtime="";
						temp.setRmInstalltime(installtime);
					}else{
					temp.setRmInstalltime(rSet.getDate("RM_INSTALLTIME")+"");
					}
					if(rSet.getDate("RM_SV_STARTTIME")==null){
						String starttime="";
						temp.setRmSvStarttime(starttime);
					}else{
						temp.setRmSvStarttime(rSet.getDate("RM_SV_STARTTIME")+"");
					}
					if(rSet.getDate("RM_SV_ENDTIME")==null){
						String endtime="";
						temp.setRmSvEndtime(endtime);
					}else{
						temp.setRmSvEndtime(rSet.getDate("RM_SV_ENDTIME")+"");
					}
					if(rSet.getDate("RM_DURABILITY")==null){
						String durability="";
						temp.setRmDurability(durability);
					}else{
						temp.setRmDurability(rSet.getDate("RM_DURABILITY")+"");
					}
					temp.setRmUse(rSet.getString("RM_USE"));
					temp.setRmStatus(rSet.getString("RM_STATUS"));
					temp.setRmUser(rSet.getString("RM_USER"));
					temp.setRmDepartment(rSet.getString("RM_DEPARTMENT"));
					temp.setRmOrg(rSet.getString("RM_ORG"));
					temp.setRmWeight(rSet.getDouble("RM_WEIGHT"));
					temp.setRmHeight(rSet.getInt("RM_HEIGHT"));
					temp.setRmSystem("Linux");
					temp.setRmPowerInput(rSet.getString("RM_POWER_INPUT"));
					temp.setRmPowerOutput(rSet.getString("RM_POWER_OUTPUT"));
					temp.setRmPowerNumber(rSet.getInt("RM_POWER_NUMBER"));
					temp.setRmPower(rSet.getString("RM_POWER"));
					temp.setRmStandard(rSet.getString("RM_STANDARD"));
					temp.setRmCpuNumber(rSet.getInt("RM_CPU_NUMBER"));
					temp.setRmCpuType(rSet.getString("RM_CPU_TYPE"));
					temp.setRmCpuCore(rSet.getString("RM_CPU_CORE"));
					temp.setRmCpuHz(rSet.getString("RM_CPU_HZ"));
					temp.setRmMemory(rSet.getString("RM_MEMORY"));
					temp.setRmMemoryType(rSet.getString("RM_MEMORY_TYPE"));
					temp.setRmMEslotNm(rSet.getInt("RM_MESLOTNM"));
					temp.setRmPortNum(rSet.getInt("RM_PORT_NUM"));
					temp.setRmPortSpeed(rSet.getDouble("RM_PORT_SPEED"));
					temp.setRmIsCD(rSet.getInt("RM_ISCD"));
					temp.setRmStorage(rSet.getDouble("RM_STORAGE"));
					temp.setRmWorktemps(rSet.getString("RM_WORKTEMPS"));
					temp.setRmWorkhumidity(rSet.getString("RM_WORKHUMIDITY"));
					temp.setRmsbladeio(rSet.getInt("rms_blade_io"));
					temp.setPhomeip(rSet.getString("p_homeip"));
				
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rSet);
			DBUtil.close(psStatement);
			DBUtil.close(connection);
		}
		
		return list;
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		List<RackMount> list =new ESMDao().getAssetList("");
		System.out.println("number="+list.size());
	}
}
