package com.yangml.ESMClient;
/**
 * IT设备表(服务器、存储、刀箱、网络设备)
 * 表名：t_rackmount
 * 用途：用于记录设备的通有属性的信息
 * @author yangml
 *
 */
public class RackMount {
	private String rmId ;	//设备编号（唯一）
	private String rmInnum;	//设备的内部编号，命名规则
	//private	String roomsId ;	//机房编号（唯一）
	private String roomsName ;	//	机房名称
//	private String zoneId ; 	//区域编号
//	private String zoneName ;	//区域名称
	private String rmSerialno;	//设备序列号
	private String rmName ;	//设备名称
	private String rmClass;	//所属类别，比如服务器、存储、网络设备
	private String rmType;	//设备型号
	private String rackId ;	//机柜编号（唯一）
	private String rackName;	//机柜名称
	private int rmLocation;		//所在机柜的位置
	private String rmVendor;	//生产厂商
	private String rmSuppliers;	//供应商
	private String rmSP;	//服务提供商
	private String rmServicetype;	//服务类型
	private String rmServicecon;	//服务合同
	private String rmSvStarttime;	//当前服务开始时间
	private String rmSvEndtime;	//当前服务结束时间
	private String rmInstalltime;	//安装/启用时间
	private String rmDurability;	//质保期
	private String rmUse;	//用途
	private String rmStatus;	//状态
	private String rmUser;	//使用用户
	private String rmDepartment;	//使用部门
	private String rmOrg;	//单位机构
	private double rmWeight;	//重量
	private int rmHeight;	//高度，U高
	private String rmSystem;	//系统
	private String rmPowerInput;	//	输入电压
	private String rmPowerOutput;	//输出电压
	private int rmPowerNumber;	//	电源数量
	private String rmPower;	//电源功率
	private String rmStandard;	//规格，长*宽*高
	private int rmCpuNumber;	//	CPU数量
	private String rmCpuType;	//CPU型号
	private String rmCpuCore;	//CPU（核）
	private String rmCpuHz;	//CPU频率
	private String rmMemory;	//内存容量
	private String rmMemoryType;	//内存类型
	private int rmMEslotNm;	//内存扩展槽数量
	private int rmPortNum;	//端口数量
	private int rmnetworknum;
	private double rmPortSpeed;	//端口速率
	private int rmIsCD;	//是否有光驱
	private double rmStorage;	//存储容量
	private String rmWorktemps;	//工作温度
	private String rmWorkhumidity;	//工作湿度
	private int rmsbladeio;  //刀箱中可放置刀片的数量
	
//	private String rmsPic;
//	private String file3dpath;
//	private String createDate;
	private String phomeip;
//	
//	private String p_total; //总计
//	private String p_used; //已用插口
//	private double p_use; //可用插口
	
	
	public String getPhomeip() {
		return phomeip;
	}
	public void setPhomeip(String phomeip) {
		this.phomeip = phomeip;
	}
	
	public int getRmnetworknum() {
		return rmnetworknum;
	}
	public void setRmnetworknum(int rmnetworknum) {
		this.rmnetworknum = rmnetworknum;
	}
	
	public String getRoomsName() {
		return roomsName;
	}
	public void setRoomsName(String roomsName) {
		this.roomsName = roomsName;
	}
	
	public int getRmsbladeio() {
		return rmsbladeio;
	}
	public void setRmsbladeio(int rmsbladeio) {
		this.rmsbladeio = rmsbladeio;
	}
	private String rmComments;	//设备的详细信息
	
	public String getRmId() {
		return rmId;
	}
	public void setRmId(String rmId) {
		this.rmId = rmId;
	}
	public String getRmInnum() {
		return rmInnum;
	}
	public void setRmInnum(String rmInnum) {
		this.rmInnum = rmInnum;
	}
	public String getRmSerialno() {
		return rmSerialno;
	}
	public void setRmSerialno(String rmSerialno) {
		this.rmSerialno = rmSerialno;
	}
	public String getRmName() {
		return rmName;
	}
	public void setRmName(String rmName) {
		this.rmName = rmName;
	}
	public String getRmClass() {
		return rmClass;
	}
	public void setRmClass(String rmClass) {
		this.rmClass = rmClass;
	}
	public String getRmType() {
		return rmType;
	}
	public void setRmType(String rmType) {
		this.rmType = rmType;
	}
	public String getRackId() {
		return rackId;
	}
	public void setRackId(String rackId) {
		this.rackId = rackId;
	}
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public int getRmLocation() {
		return rmLocation;
	}
	public void setRmLocation(int rmLocation) {
		this.rmLocation = rmLocation;
	}
	public String getRmVendor() {
		return rmVendor;
	}
	public void setRmVendor(String rmVendor) {
		this.rmVendor = rmVendor;
	}
	public String getRmSuppliers() {
		return rmSuppliers;
	}
	public void setRmSuppliers(String rmSuppliers) {
		this.rmSuppliers = rmSuppliers;
	}
	public String getRmSP() {
		return rmSP;
	}
	public void setRmSP(String rmSP) {
		this.rmSP = rmSP;
	}
	public String getRmServicetype() {
		return rmServicetype;
	}
	public void setRmServicetype(String rmServicetype) {
		this.rmServicetype = rmServicetype;
	}
	public String getRmServicecon() {
		return rmServicecon;
	}
	public void setRmServicecon(String rmServicecon) {
		this.rmServicecon = rmServicecon;
	}
	public String getRmSvStarttime() {
		return rmSvStarttime;
	}
	public void setRmSvStarttime(String rmSvStarttime) {
		this.rmSvStarttime = rmSvStarttime;
	}
	public String getRmSvEndtime() {
		return rmSvEndtime;
	}
	public void setRmSvEndtime(String rmSvEndtime) {
		this.rmSvEndtime = rmSvEndtime;
	}
	public String getRmInstalltime() {
		return rmInstalltime;
	}
	public void setRmInstalltime(String rmInstalltime) {
		this.rmInstalltime = rmInstalltime;
	}
	public String getRmDurability() {
		return rmDurability;
	}
	public void setRmDurability(String rmDurability) {
		this.rmDurability = rmDurability;
	}
	public String getRmUse() {
		return rmUse;
	}
	public void setRmUse(String rmUse) {
		this.rmUse = rmUse;
	}
	public String getRmStatus() {
		return rmStatus;
	}
	public void setRmStatus(String rmStatus) {
		this.rmStatus = rmStatus;
	}
	public String getRmUser() {
		return rmUser;
	}
	public void setRmUser(String rmUser) {
		this.rmUser = rmUser;
	}
	public String getRmDepartment() {
		return rmDepartment;
	}
	public void setRmDepartment(String rmDepartment) {
		this.rmDepartment = rmDepartment;
	}
	public String getRmOrg() {
		return rmOrg;
	}
	public void setRmOrg(String rmOrg) {
		this.rmOrg = rmOrg;
	}
	public double getRmWeight() {
		return rmWeight;
	}
	public void setRmWeight(double rmWeight) {
		this.rmWeight = rmWeight;
	}
	public int getRmHeight() {
		return rmHeight;
	}
	public void setRmHeight(int rmHeight) {
		this.rmHeight = rmHeight;
	}
	public String getRmSystem() {
		return rmSystem;
	}
	public void setRmSystem(String rmSystem) {
		this.rmSystem = rmSystem;
	}
	public String getRmPowerInput() {
		return rmPowerInput;
	}
	public void setRmPowerInput(String rmPowerInput) {
		this.rmPowerInput = rmPowerInput;
	}
	public String getRmPowerOutput() {
		return rmPowerOutput;
	}
	public void setRmPowerOutput(String rmPowerOutput) {
		this.rmPowerOutput = rmPowerOutput;
	}
	public int getRmPowerNumber() {
		return rmPowerNumber;
	}
	public void setRmPowerNumber(int rmPowerNumber) {
		this.rmPowerNumber = rmPowerNumber;
	}
	public String getRmPower() {
		return rmPower;
	}
	public void setRmPower(String rmPower) {
		this.rmPower = rmPower;
	}
	public String getRmStandard() {
		return rmStandard;
	}
	public void setRmStandard(String rmStandard) {
		this.rmStandard = rmStandard;
	}
	public int getRmCpuNumber() {
		return rmCpuNumber;
	}
	public void setRmCpuNumber(int rmCpuNumber) {
		this.rmCpuNumber = rmCpuNumber;
	}
	public String getRmCpuType() {
		return rmCpuType;
	}
	public void setRmCpuType(String rmCpuType) {
		this.rmCpuType = rmCpuType;
	}
	public String getRmCpuCore() {
		return rmCpuCore;
	}
	public void setRmCpuCore(String rmCpuCore) {
		this.rmCpuCore = rmCpuCore;
	}
	public String getRmCpuHz() {
		return rmCpuHz;
	}
	public void setRmCpuHz(String rmCpuHz) {
		this.rmCpuHz = rmCpuHz;
	}
	public String getRmMemory() {
		return rmMemory;
	}
	public void setRmMemory(String rmMemory) {
		this.rmMemory = rmMemory;
	}
	public String getRmMemoryType() {
		return rmMemoryType;
	}
	public void setRmMemoryType(String rmMemoryType) {
		this.rmMemoryType = rmMemoryType;
	}
	public int getRmMEslotNm() {
		return rmMEslotNm;
	}
	public void setRmMEslotNm(int rmMEslotNm) {
		this.rmMEslotNm = rmMEslotNm;
	}
	public int getRmPortNum() {
		return rmPortNum;
	}
	public void setRmPortNum(int rmPortNum) {
		this.rmPortNum = rmPortNum;
	}
	public double getRmPortSpeed() {
		return rmPortSpeed;
	}
	public void setRmPortSpeed(double rmPortSpeed) {
		this.rmPortSpeed = rmPortSpeed;
	}
	public int getRmIsCD() {
		return rmIsCD;
	}
	public void setRmIsCD(int rmIsCD) {
		this.rmIsCD = rmIsCD;
	}
	public double getRmStorage() {
		return rmStorage;
	}
	public void setRmStorage(double rmStorage) {
		this.rmStorage = rmStorage;
	}
	public String getRmWorktemps() {
		return rmWorktemps;
	}
	public void setRmWorktemps(String rmWorktemps) {
		this.rmWorktemps = rmWorktemps;
	}
	public String getRmWorkhumidity() {
		return rmWorkhumidity;
	}
	public void setRmWorkhumidity(String rmWorkhumidity) {
		this.rmWorkhumidity = rmWorkhumidity;
	}
	public String getRmComments() {
		return rmComments;
	}
	public void setRmComments(String rmComments) {
		this.rmComments = rmComments;
	}
	@Override
	public String toString() {
		return "RackMount [rackId=" + rackId + ", rackName=" + rackName
				+ ", rmClass=" + rmClass + ", rmComments=" + rmComments
				+ ", rmCpuCore=" + rmCpuCore + ", rmCpuHz=" + rmCpuHz
				+ ", rmCpuNumber=" + rmCpuNumber + ", rmCpuType=" + rmCpuType
				+ ", rmDepartment=" + rmDepartment + ", rmDurability="
				+ rmDurability + ", rmHeight=" + rmHeight + ", rmId=" + rmId
				+ ", rmInnum=" + rmInnum + ", rmInstalltime=" + rmInstalltime
				+ ", rmIsCD=" + rmIsCD + ", rmLocation=" + rmLocation
				+ ", rmMEslotNm=" + rmMEslotNm + ", rmMemory=" + rmMemory
				+ ", rmMemoryType=" + rmMemoryType + ", rmName=" + rmName
				+ ", rmOrg=" + rmOrg + ", rmPortNum=" + rmPortNum
				+ ", rmPortSpeed=" + rmPortSpeed + ", rmPower=" + rmPower
				+ ", rmPowerInput=" + rmPowerInput + ", rmPowerNumber="
				+ rmPowerNumber + ", rmPowerOutput=" + rmPowerOutput
				+ ", rmSP=" + rmSP + ", rmSerialno=" + rmSerialno
				+ ", rmServicecon=" + rmServicecon + ", rmServicetype="
				+ rmServicetype + ", rmStandard=" + rmStandard + ", rmStatus="
				+ rmStatus + ", rmStorage=" + rmStorage + ", rmSuppliers="
				+ rmSuppliers + ", rmSvEndtime=" + rmSvEndtime
				+ ", rmSvStarttime=" + rmSvStarttime + ", rmSystem=" + rmSystem
				+ ", rmType=" + rmType + ", rmUse=" + rmUse + ", rmUser="
				+ rmUser + ", rmVendor=" + rmVendor + ", rmWeight=" + rmWeight
				+ ", rmWorkhumidity=" + rmWorkhumidity + ", rmWorktemps="
				+ rmWorktemps + ", rmsbladeio=" + rmsbladeio + ", roomsId="
				+  "]";
	}
	
}
