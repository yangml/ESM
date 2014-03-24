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
  		<tr><td colspan="2">资产名称&nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" name="assetName" id="assetName" value="" style="color:#ccc;width: 250px;height:30px;" />&nbsp;&nbsp;&nbsp;&nbsp;<font style="color: red" size="4px;">输入的设备名称为“，”分割。</font></td></tr>
  		<tr>
  			<td><a id="getAsset" class="btn btn-info">获取3D资产信息</a></td>
  			<td><a id="updateAsset" class="btn btn-success">更新3D资产信息</a></td>
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
  	
  </body>
  <script type="text/javascript">
  	$(function(){
  	  	$("#getAsset").click(function(){
  	  	  //	alert("==");
  	  	  	
  	  	
		var assetnames = $("#assetName").val();
		var src='http://10.0.0.120:8080/3d/assetinterface/asset!getAssetList?assetNames='+assetnames;
		//alert(assetnames)
		var tr = "";
		/*
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
*/
			$.ajax({
	            type: "get",
	            async: false,
	            url: src,
	            dataType: "jsonp",
	            jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
	            jsonpCallback:"flightHandler",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
	            success: function(data){
	            //alert(data.length);
	            $("#assetinfo tbody").html('');
	            for (var i = 0; i < data.length; i++) {
					var rackName = data[i].rackName;
					var rmName = data[i].rmName;
					var rmInner = data[i].rmInnum;
					var rmip = data[i].phomeip;
					var rmClass = data[i].rmClass;
					var rmType = data[i].rmType;
					var rnUser = data[i].rmUser;
					var rmHeight = data[i].rmHeight;
	                
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
	            $("#assetinfo tbody").append(tr);
	            },
	            error: function(){
	                alert('fail');
	            }
	        });
			
  	  	  	})
		
  	  	})
  </script>
</html>
