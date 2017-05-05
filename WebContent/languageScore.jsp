<%@page import="common.StringProcess"%>
<%@page import="model.bean.LanguageScore"%>
<%@page import="model.bean.Department"%>
<%@page import="model.bean.Status"%>
<%@page import="model.bean.Account"%>
<%@page import="model.bean.Language"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>Language Score</title>
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<script src="js/jquery-1.12.3.js"></script>
<script
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script
	src="http://cdn.datatables.net/responsive/1.0.1/js/dataTables.responsive.min.js"></script>
<script
	src="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="fonts/glyphicons-halflings-regular.eot" />
<link rel="stylesheet" href="fonts/glyphicons-halflings-regular" />
<link rel="stylesheet" href="fonts/glyphicons-halflings-regular.woff" />
<script src="sweetalert-master/dist/sweetalert.min.js"></script>
<link rel="stylesheet" href="sweetalert-master/dist/sweetalert.css" />
<!-- //tables -->
</head>


<body style="background-color: #eac19e">

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><a href="#">MY PROFILE</a></li>
				<li><a href="#">ACOUNT COURSE</a></li>
				<li><a href="#">ACOUNT</a></li>
				<li><a href="#">COURSE</a></li>
				<li><a href="#">ACOUNT CERTIFICATE</a></li>
				<li class="active"><a href="#">LANGUAGE SCORE</a></li>
				<li><a href="#">REPORT</a></li>
				<li><a href="#">SERCURITY</a></li>


			</ul>
			<ul class="nav navbar-nav" style="float: right;">
				<li><a href="#">Trần Nhật Linh</a></li>
			</ul>
		</div>

	</nav>
	<!-- thông báo kết quả tìm kiếm -->



	<div class="">
		<div class="col-md-2">
			<div class="lang">Language Score</div>
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#">|- All</a></li>
				<li><a href="#">|- TOEFL</a></li>
				<li><a href="#">|- TOIEC</a></li>
				<li><a href="#">|- JPN</a></li>
				<li><a href="#">|- FRAN</a></li>
			</ul>
		</div>
		<div class="col-md-10"
			style="border-left-style: ridge; border-left-color: #f5f5f5;">
			<h3>View Language Score</h3>
			<hr>


			<div class="thongtintimkiem">
				<div class="container-fluid">


					<html:form action="/danh-sach" styleClass="form-group"
						method="post">

						<div>

							<div class="col-md-6">
								<div class="form-inline">
									<label class="col-sm-4 control-label">Selection Seach</label>
									<div class="col-sm-8">
										<label class="radio-inline"> <html:radio
												property="selectSeach" value="1">Final Score</html:radio>

										</label> <label class="radio-inline"> <html:radio
												property="selectSeach" value="2">All</html:radio>

										</label>
									</div>
								</div>
								<div class="form-inline">
									<label class="col-sm-4 control-label">Score</label>
									<div class="col-sm-8">

										<html:text property="score" styleClass="form-control"></html:text>
									</div>
								</div>
								<div class="form-inline">
									<label class="col-sm-4 control-label">Status</label>
									<div class="col-sm-8">

										<html:select property="statusAccountId"
											styleClass="form-control">
											<option value="">All</option>
											<html:optionsCollection name="languageScoreForm"
												property="listStatus" label="statusName"
												value="statusAccountId" />
										</html:select>

									</div>
								</div>

							</div>
							<div class="col-md-6 form-horizontal">
								<div class="form-inline">
									<label class="col-sm-4 control-label">Acount</label>
									<div class="col-sm-8">
										<html:text property="account" styleClass="form-control"></html:text>
									</div>
								</div>
								<div class="form-inline">
									<label class="col-sm-4 control-label">Full name</label>
									<div class="col-sm-8">
										<html:text property="fullName" styleClass="form-control"></html:text>
									</div>
								</div>
								<div class="form-inline">
									<label class="col-sm-4 control-label">Department</label>
									<div class="col-sm-8">

										<html:select property="departmentId"
											style="width: 196px !important"
											styleClass="form-control control-label">
											<option value="">All</option>
											<html:optionsCollection name="languageScoreForm"
												property="listDeparment" label="departmentName"
												value="departmentId" />
										</html:select>
									</div>
								</div>

							</div>

						</div>
						<hr>
						<div id="duoi">
							<hr>
							<a href="#popup1"><strong>Table Configuration</strong></a> <span
								style="float: right;"><button type="submit"
									class="btn btn-info">
									<span class="glyphicon glyphicon-search"> Seach</span>
								</button></span>
						</div>

					</html:form>
				</div>
			</div>

			<!-- popup -->
			<div id="popup1" class="overlay">
				<div class="col-md-7 col-md-offset-3">
					<div class="panel panel-primary">
						<div class="panel-heading">Select Fields</div>
						<div class="panel-body" style="background-color: #eac19e">
							<div class="form-inline">
								<div class="col-md-3 checkbox">
									<label class="toggle-vis"><input type="checkbox"
										id="select_all" checked="checked"> Seclet all</label>
								</div>
							</div>
							<div class="form-inline">
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="0"><input
										type="checkbox" class="hide_show" data-column="0"
										checked="checked"> Acount</label>
								</div>
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="1"><input
										type="checkbox" class="hide_show" data-column="1"
										checked="checked"> Full name</label>
								</div>
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="2"><input
										type="checkbox" class="hide_show" data-column="2"
										checked="checked"> Department Name</label>
								</div>
							</div>
							<div class="form-inline">
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="3"><input
										type="checkbox" class="hide_show" data-column="3"
										checked="checked"> Language Name</label>
								</div>
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="4"><input
										type="checkbox" class="hide_show" data-column="4"
										checked="checked"> Score</label>
								</div>
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="5"><input
										type="checkbox" class="hide_show" data-column="5"
										checked="checked"> Date</label>
								</div>
								<div class="col-md-3 checkbox">
									<label class="toggle-vis" data-column="6"><input
										type="checkbox" class="hide_show" data-column="6">
										Note</label>
								</div>
							</div>

							<hr>

							<div style="float: right;">
								<button type="button" class="btn btn-info">
									<a class="close" href="#">Accept</a>
								</button>
								<button type="button" class="btn btn-info">
									<a class="close" href="#">Cannel </a>
								</button>

							</div>

						</div>
					</div>
				</div>
			</div>
			<!-- close popup -->
			<div>
				<table id="mine" class="table table-striped table-bordered">
					<thead class="headerTable">
						<tr>
							<td>Acount</td>
							<td>Full name</td>
							<td>Department Name</td>
							<td>Language Name</td>
							<td>Score</td>
							<td>Date</td>
							<td>Note</td>

						</tr>
					</thead>
					<tbody>
						<logic:iterate name="languageScoreForm"
							property="listLanguageScore" id="ls">
							<tr>
								<td><bean:write name="ls" property="accountName" /></td>
								<td><bean:write name="ls" property="fullName" /></td>
								<td><bean:write name="ls" property="departmentName" /></td>
								<td><bean:write name="ls" property="languageName" /></td>
								<td><bean:write name="ls" property="score" /></td>
								<td><bean:write name="ls" property="date" /></td>
								<td><bean:write name="ls" property="note" /></td>

							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</div>



		</div>

	</div>

</body>
</html>
<script type="text/javascript">
	$(document).ready(function() {
		var table =  $('#mine').DataTable({
	    	"bPaginate" : false,
				"bFilter" : false,
				"bInfo" : true,
				"paging" : true,
				"bLengthChange" : false,
				"bInfo" : false,
				
					
					
				
				"pagingType" : "simple_numbers",
				"language": {
					
					"sEmptyTable": "Không tìm thấy kết quả tìm kiếm!",
				    "paginate": {
					      "previous": "<< Previous Page",
					      "next": "Next Page >>",
				    }
			  }
			
	    });
		table.column( 6 ).visible( false );
		  $("#select_all").click(function(){
		   
			    $('input:checkbox').not(this).prop('checked', this.checked);
			    column.visible(  column.visible() );
			});
		 
		    $('.toggle-vis').on( 'change', function (e) {
		        e.preventDefault();
		        $(this).is(":checked");
		        // Get the column API object
		        var column = table.column( $(this).attr('data-column') );
		 
		        // Toggle the visibility
		        column.visible( ! column.visible() );
		    } );
		    $("#huy").click(function(){
		    	//column.visible(  column.visible() );  
		    	window.history.go(-1);	
			    
			});
		
	});
</script>