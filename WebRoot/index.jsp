<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ESM系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="CSS/bootstrap.min.css">
	<script type="text/javascript" src="JS/jquery-1.10.2.js"></script>
  </head>
  
  <body>
  	<table id='assetcon' class='table table-hover'>
  		<tr><td colspan="3">资产名称&nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" name="assetName" id="assetName" value="" style="color:#ccc;width: 250px;height:30px;" />&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: red" size="4px;">输入的设备名称为“，”分割。</font></td></tr>
  		<tr>
  			<td><a id="getAsset" class="btn btn-info">获取3D资产信息</a></td>
  			<td><a id="updateAsset" class="btn btn-success">更新3D资产信息</a></td>
  			<td><a id="getLog" class="btn btn-success">获取3D日志信息</a></td>
  		</tr>
  	</table>
  	<table id='assetinfo' class='table table-bordered'>
  		<thead>
	  			<tr>
					<th>机柜名称</th>
					<th>设备名称</th>
					<th>设备编号</th>
					<th>设备IP</th>
					<th>设备类型</th>
					<th>设备型号</th>
					<th>使用用户</th>
					<th>设备高度</th>
	  			</tr>
		</thead>
		<tbody>
		</tbody>
  	</table>
  	  	<table id='loginfo' class='table table-bordered'>
  		<thead>
	  			<tr>
					<th>日志编号</th>
					<th>ip</th>
					<th>操作用户</th>
					<th>时间</th>
					<th>详情</th>
	  			</tr>
		</thead>
		<tbody>
		</tbody>
  	</table>
  </body>
  <script type="text/javascript">
  	$(function(){
  	  	$("#getAsset").click(function(){
  	  	  //	alert("==");
  	  	  	
  	  	
		var assetnames = $("#assetName").val();
		var src='esm/esm!getPersonClient';
		//alert(assetnames)
		var tr = "";
		
		$.post(src,{assetNames:assetnames},function(data){
			var jsonObj = eval("(" + data + ")");  
			$("#assetinfo tbody").html('');
            for (var i = 0; i < jsonObj.length; i++) {  
				//获取返回的数据
				var rackName = jsonObj[i].rackName;
				var rmName = jsonObj[i].rmName;
				var rmInner = jsonObj[i].rmInnum;
				var rmip = jsonObj[i].phomeip;
				var rmClass = jsonObj[i].rmClass;
				var rmType = jsonObj[i].rmType;
				var rnUser = jsonObj[i].rmUser;
				var rmHeight = jsonObj[i].rmHeight;
				//alert(rackName);
            	//处理数据
            	tr+='<tr><td>'+rackName+'</td>'
				+'<td>'+rmName+'</td>'
				+'<td>'+rmInner+'</td>'
				+'<td>'+rmip+'</td>'
				+'<td>'+rmClass+'</td>'
				+'<td>'+rmType+'</td>'
				+'<td>'+rnUser+'</td>'
				+'<td>'+rmHeight+'</td>'
				+'</tr>'
				} 
				//alert(tr)
				$("#assetinfo tbody").append(tr);
			})
  	  	  	})
			//发送数据到资产库（3d）中进行更新数据
  	  	  	$("#updateAsset").click(function(){
  	  	  	  	var src = "esm/esm!sendUpdateData";
				$.post(src,function(data){
						alert(data);
					})
  	  	  	  })
  	  $("#getLog").click(function(){
  	  	  	//alert("==");
  	  	  	
  	  	
		var src='esm/esm!getOptLogData';
		//alert(assetnames)
		var tr = "";
		
		$.post(src,function(data){
			var jsonObj = eval("(" + data + ")");  
			$("#loginfo tbody").html('');
            for (var i = 0; i < jsonObj.length; i++) {  
				//获取返回的数据
				var logID = jsonObj[i].logID;
				var ipAddress = jsonObj[i].ipAddress;
				var opeName = jsonObj[i].opeName;
				var opeTime = jsonObj[i].opeTime;
				var details = jsonObj[i].details;
				//alert(rackName);
            	//处理数据
            	tr+='<tr><td>'+logID+'</td>'
				+'<td>'+ipAddress+'</td>'
				+'<td>'+opeName+'</td>'
				+'<td>'+opeTime+'</td>'
				+'<td>'+details+'</td>'
				+'</tr>'
				} 
				//alert(tr)
				$("#loginfo tbody").append(tr);
			})
  	  	  	})
  	  	})
  </script>
</html>
