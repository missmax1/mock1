<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>them</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="plugins/ckeditor/ckeditor.js"></script>
  <link rel="stylesheet" href="css/style1.css"/>
    <script src="sweetalert-master/dist/sweetalert.min.js"></script>
  <link rel="stylesheet" href="sweetalert-master/dist/sweetalert.css"/>
    
</head>
<body>

	<%@include file="blocks/header.jsp" %>
	
	
	<hr>
	
	<div class="container">
		<div class="col-md-3">
			<ul>
			<li><a href="ThemSP.do">Tạo phiên đấu giá</a></li>
			<li><a href="danh-sach-phien-dau-gia.do">Quản lý phiên đấu giá</a></li>
			<li><a href="#">Lịch sử đấu giá</a></li>
			<li><a href="capNhatThongTin.do">Cập nhật thông tin</a></li>
		</ul>
		</div>
		<div class="col-md-9">
		
		
		
		<div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          Thêm phiên đấu giá
	      <span class="pull-right">
			<a class="btn btn-default btn-sm" data-toggle="collapse" href="#phien-dau-gia" onclick="phien()">
	          	<i id="xx" class="glyphicon glyphicon-minus"></i>
	          </a>
	          	<html:form action="/them-phien-dau-gia" style="display:inline-block">
      				<html:submit property="huy" value="huy" styleClass="btn btn-primary btn-xs"></html:submit>
      			</html:form>
           </span>
        </h4>
      </div>
      <div id="phien-dau-gia" class="panel-collapse collapse in">
        <div class="panel-body">
        	<html:form action="/them-phien-dau-gia" styleClass="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Tên phiên đấu giá <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="tenpdg" id="tenpdg" placeholder="Nhập tên phiên đấu giá">
						<p style="color: red"><html:errors property="tenpdgError"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Giá khởi tạo <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<input type="number" class="form-control" name="giaDeNghi" id="giaDeNghi" placeholder="Nhập giá khởi tạo">
						<p style="color: red"><html:errors property="giaDeNghiError"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Bước giá <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<input type="number" class="form-control" name="buocGia" id="buocGia" placeholder="Nhập bước giá">
						<p style="color: red"><html:errors property="buocGiaError"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Thời gian bắt đầu <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<div class="input-group">
						  <span class="input-group-addon">Ngày</span>
						  <input type="date" class="form-control" name="thoiGianBatDau" id="thoiGianBatDau">
						  <span class="input-group-addon" style="border-left: 0; border-right: 0;">Giờ</span>
						  <input type="time" class="form-control" name="gioBatDau">
						</div>
						<p style="color: red"><html:errors property="thoiGianBatDauError"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Thời gian kết thúc <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<div class="input-group">
						  <span class="input-group-addon">Ngày</span>
						  <input type="date" class="form-control" name="thoiGianKetThuc" id="thoiGianKetThuc">
						  <span class="input-group-addon" style="border-left: 0; border-right: 0;">Giờ</span>
						  <input type="time" class="form-control" name="gioKetThuc">
						</div>
						<p style="color: red"><html:errors property="thoiGianKetThucError"/></p>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="">Loại phiên đấu giá <span style="color: red;">*</span></label>
					<div class="col-sm-9">
						<select name="loaiPhienDauGia" id="loaiPhienDauGia" class="form-control">
							<option value=""> - Chọn loại phiên đấu giá - </option>
							<option value="0">Sản phẩm mới</option>
							<option value="1">Sản phẩm cũ</option>
						</select>
						<p style="color: red"><html:errors property="loaiPhienDauGiaError"/></p>
					</div>
				</div>
	        	
				<p style="color: red"><html:errors property="sanPhamError"/></p>
	        	
	        	<div class="text-right">
	        		<html:submit property="submit" value="submit" styleClass="btn btn-primary"></html:submit>
	        	</div>
	        </html:form>
		</div>
      </div>
    </div>
			
        
        
        <hr>
        <div class="col-md-12">
        <h3>Danh sách các sản phẩm đã thêm: 
        	<div class="pull-right">
        		<button class="btn btn-default" id="showFormThemSanPham">Thêm sản phẩm</button>
        	</div>
	     </h3>
        	<div id="display"></div>
        
        </div>
        <hr>
	
	     <div class="row" id="form-them-san-pham">
		  <div class="col-md-12">
		   
		   <html:form action="/them-phien-dau-gia">
		   
		   	<legend>Thêm sản phẩm</legend>
		   
		   	<div class="form-group">
				<label for="">Tên sản phẩm <span style="color: red;">*</span></label>
				<input type="text" class="form-control" name="tenSanPham" id="tenSanPham" placeholder="Nhập tên sản phẩm">
				<p style="color: red"><html:errors property="tenSanPhamError"/></p>
			</div>
			<div class="form-group">
				<label for="">Loại sản phẩm</label>
				<html:select property="maLoaiSP" styleClass="form-control" styleId="loaiSanPham">
            		<html:optionsCollection name="spForm" property="listLoaiSanPham" label="tenLoaiSP" value="maLoaiSP" />
            	</html:select>
				<p style="color: red"><html:errors property="maLoaiSPError"/></p>
			</div>
			<div class="form-group">
				<label for="">Hãng sản xuất</label>
				<input type="text" class="form-control" name="hangSanXuat" id="hangSanXuat" placeholder="Nhập sản sản xuất">
			</div>
			<div class="form-group">
				<label for="">Thời gian bảo hành</label>
				<input type="number" class="form-control" name="thoiHanBaoHanh" id="thoiHanBaoHanh" min="0" max="100" placeholder="Nhập thời gian bảo hành">
				<p style="color: red"><html:errors property="thoiHanBaoHanhError"/></p>
			</div>
			<div class="form-group">
				<label for="">Mô tả sản phẩm</label>
				<textarea name="moTa" id="moTa"></textarea>
				<script>
				//	CKEDITOR.replace('moTa');
				</script>
			</div>
	        <div class="form-group">
				<label for="">Image</label>
				<span id="images"></span>
	        	<button id="themanh" class="btn btn-default" type="button" onclick="themhinhanh()">Thêm hình ảnh</button>
	        </div>
	        	<a href="#" class="btn btn-primary" onclick="themSanPham()">Hoàn tất</a>
	        	<a href="#" class="btn btn-primary" onclick="nhapLaiSanPham()">Nhập lại</a>
	        </html:form><!-- end form-->
	        
		 </div>
		</div><!-- end row-->
 		</div>
 	</div><!-- end container -->
 
 

<%@include file="blocks/footer.jsp" %>
        
   		
    <script>
    	$("#form-them-san-pham").hide();
    	
    	$("#showFormThemSanPham").click(function(){
    		$("#form-them-san-pham").show();
    	});
    	
		function phien() {
		    var i = document.getElementById("xx");
		    if(i.className === "glyphicon glyphicon-plus")
		    	i.className = "glyphicon glyphicon-minus";
		    else
		    	i.className = "glyphicon glyphicon-plus";
		};
		
		function xoaSanPham(sTT) {
			console.log(typeof sTT)
			$.ajax({
				url: 'xoa-san-pham.do',
				data: {"sTT":sTT},
				type: 'POST',
				success: function(response){
					var data = JSON.parse(response);
					if(data.length==0){
						$("#display").html("Chưa có sản phẩm nào được thêm trong phiên đấu giá!!!");
					} else {
						for(var i = 0; i < data.length; i++){
						    var hh = data[i].pathfile.length;
						    var j = 0;
							var dis = '<div class=\"row\">'+
						  	'<div class="panel-group">'+
						    '<div class="panel panel-default">'+
						    '  <div class="panel-heading">'+
						    '    <h4 class="panel-title">'+
						    '      Sản phẩm : '+ data[i].tenSanPham+ 
						    '		<span class="pull-right">'+
						   '         <a class="btn btn-default btn-sm" type="button" data-toggle="collapse" href="#'+data[i].sTT+'" onclick="myFunction('+data[i].sTT+')">'+
						   '         	<i id="icon'+data[i].sTT+'" class="glyphicon glyphicon-plus"></i>'+
						    '        </a>'+
						    '         <a class="btn btn-default btn-sm" type="button" href="#" onclick="xoaSanPham('+data[i].sTT+')">'+
							   '         	<i id="xoa'+data[i].sTT+'" class="glyphicon glyphicon-remove"></i>'+
							    '        </a>'+
						    '		</span>'+
						     '   </h4>'+
						    '  </div>'+
						    '  <div id="'+data[i].sTT+'" class="panel-collapse collapse">'+
						    '    <div class="panel-body">';
							for(j = 0; j < hh; j++){
								console.log(data[i].pathfile[j]);
								dis = dis +   '   	<div class="col-md-3 thumbnail">'+
							     '   				<img src="'+data[i].pathfile[j]+'" alt="" height="100" />'+
							     '   			</div>';
							}
						     
							dis = dis+	'	</div>'+
						   '   </div>'+
						  '  </div>'+
						'  </div>'+
						  
		        		'</div>';
						}
						var txt344 = document.createElement("p");
					    txt344.innerHTML = dis;
			       		$("#display").html(dis);
					}
					
					$("#tenSanPham").val("");
					$("#loaiSanPham").val("");
					$("#hangSanXuat").val("");
					$("#thoiHanBaoHanh").val("");
					$("#images").html("");
				}
			});
		};
		
		function themSanPham(){
			var tenSanPham = $("#tenSanPham").val();
			var loaiSanPham = $("#loaiSanPham").val();
			var hangSanXuat = $("#hangSanXuat").val();
			var thoiHanBaoHanh = $("#thoiHanBaoHanh").val();
			var moTa = $("textarea#moTa").val();
			
			formData = new FormData();
			formData.append('tenSanPham',tenSanPham);
			formData.append('loaiSanPham',loaiSanPham);
			formData.append('hangSanXuat',hangSanXuat);
			formData.append('thoiHanBaoHanh',thoiHanBaoHanh);
			formData.append('moTa',moTa);
			$('[name=fileBase64]').each(function(index) {
				var input = $(this);
				formData.append('fileBase64',input.val());
			});
			
			$('[name=pathfile]').each(function(index) {
				var input = $(this);
			  	formData.append('pathfile',input.val());
			});
			
			$.ajax({
				url: 'them-san-pham.do',
				data: formData,
				processData: false,
				contentType: false,
				type: 'POST',
				success: function(response){
					var data = JSON.parse(response);
					console.log(data);
					if(data.length==0){
						$("#display").html("Chưa có sản phẩm nào được thêm trong phiên đấu giá!!!");
					} else {
						for(var i = 0; i < data.length; i++){
							console.log(data[i].pathfile.length);
						    var hh = data[i].pathfile.length;
						    var j = 0;
							var dis = '<div class=\"row\">'+
						  	'<div class="panel-group">'+
						    '<div class="panel panel-default">'+
						    '  <div class="panel-heading">'+
						    '    <h4 class="panel-title">'+
						    '      Sản phẩm : '+ data[i].tenSanPham+ 
						    '		<span class="pull-right">'+
						   '         <a class="btn btn-default btn-sm" type="button" data-toggle="collapse" href="#'+data[i].sTT+'" onclick="myFunction('+data[i].sTT+')">'+
						   '         	<i id="icon'+data[i].sTT+'" class="glyphicon glyphicon-plus"></i>'+
						    '        </a>'+
						    '         <a class="btn btn-default btn-sm" type="button" href="#" onclick="xoaSanPham('+data[i].sTT+')">'+
							   '         	<i id="xoa'+data[i].sTT+'" class="glyphicon glyphicon-remove"></i>'+
							    '        </a>'+
						    '		</span>'+
						     '   </h4>'+
						    '  </div>'+
						    '  <div id="'+data[i].sTT+'" class="panel-collapse collapse">'+
						    '    <div class="panel-body">';
							for(j = 0; j < hh; j++){
								console.log(data[i].pathfile[j]);
								dis = dis +   '   	<div class="col-md-3 thumbnail">'+
							     '   				<img src="'+data[i].pathfile[j]+'" alt="" height="100" />'+
							     '   			</div>';
							}
						     
							dis = dis+	'	</div>'+
						   '   </div>'+
						  '  </div>'+
						'  </div>'+
						  
		        		'</div>';
						}
						
						var txt344 = document.createElement("p");
					    txt344.innerHTML = dis;
			       		$("#display").append(dis);
					}
					
					$("#tenSanPham").val("");
					$("#loaiSanPham").val("");
					$("#hangSanXuat").val("");
					$("#thoiHanBaoHanh").val("");
					$("#images").html("");
				}
			});
		};
		function nhapLaiSanPham(){
			$("#tenSanPham").val("");
			$("#loaiSanPham").val("");
			$("#hangSanXuat").val("");
			$("#thoiHanBaoHanh").val("");
			$("#images").html("");
		};
		function myFunction(i) {
			var i = document.getElementById("icon"+i);
			if(i.className === "glyphicon glyphicon-minus")
				i.className = "glyphicon glyphicon-plus";
			else
				i.className = "glyphicon glyphicon-minus";
		};
		themSanPham();
	</script>
	
	<script type="text/javascript">
       	var index = 1;
       	function xx(i){
	       	$('#file'+i).change( function(event) {
				var path = (window.URL || window.webkitURL).createObjectURL(event.target.files[0]);
		  		$("#pathfile"+i).val(path); 
		 		$("#img"+i).fadeIn("fast").attr("src",path); 
		 		
		 		loadImageFileAsURL(i);
	       	});
       	};
       	
       	function loadImageFileAsURL(i) {
       	    var filesSelected = document.getElementById("file"+i).files;
       	    if (filesSelected.length > 0) {
       	        var fileToLoad = filesSelected[0];
       	        var fileReader = new FileReader();
       	        fileReader.onload = function(fileLoadedEvent)  {
       	        	document.getElementById("fileBase64"+i).value = fileLoadedEvent.target.result;
       	        };
       	        fileReader.readAsDataURL(fileToLoad);
       	    }
       	}
       	
       	function themhinhanh(){
       		var ss = '<div class="col-md-6"><input type="file" name="files" id="file'+index+'" />'+
			'<input type="hidden" id="pathfile'+index+'" name="pathfile" value="" /></div>'+
			'<input type="hidden" id="fileBase64'+index+'" name="fileBase64" value="" /></div>'+
			'<div class="col-md-6"><img src="" name="img" class="thumbnail" height="75" alt="Hình ảnh sản phẩm" id="img'+index+'" /></div>'+
			'<script type="text/javascript">'+
			'    xx('+index+')'
			;
			
			var txt3 = document.createElement("p");
		    txt3.innerHTML = ss;
       		$("#images").append(txt3);
       		index++;
       	}
       	
	</script>
         
    </body>
	</html>
