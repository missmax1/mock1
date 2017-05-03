<%@page import="common.StringProcess"%>
<%@page import="model.bean.LanguageScore"%>
<%@page import="model.bean.Department"%>
<%@page import="model.bean.Status"%>
<%@page import="model.bean.Account"%>
<%@page import="model.bean.Language"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Language Score</title>
    <link href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet">
	<link href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css" rel="stylesheet">
  	<script src="js/jquery-1.12.3.js"></script>
	<script	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script	src="http://cdn.datatables.net/responsive/1.0.1/js/dataTables.responsive.min.js"></script>
	<script	src="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<link rel="stylesheet" href="css/style.css"/>
	<link rel="stylesheet" href="fonts/glyphicons-halflings-regular.eot"/>
	<link rel="stylesheet" href="fonts/glyphicons-halflings-regular"/>
	<link rel="stylesheet" href="fonts/glyphicons-halflings-regular.woff"/>

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
	    <ul class="nav navbar-nav" style="float:right;">
			<li ><a href="#">Trần Nhật Linh</a></li>
		</ul>
	  </div>
		
	</nav> 

	<div class="">
		<div class="col-md-2">
			<div class="lang">
				Language Score	
			</div>
			<ul class="nav nav-pills nav-stacked">
			  <li class="active"><a href="#">|- All</a></li>
			  <li><a href="#">|- TOEFL</a></li>
			  <li><a href="#">|- TOIEC</a></li>
			  <li><a href="#">|- JPN</a></li>
			  <li><a href="#">|- FRAN</a></li>
			</ul>
		</div>
		<div class="col-md-10" style="border-left-style: ridge;
    border-left-color: #f5f5f5;">
			<h3>View Language Score</h3>
			<hr>
			
				
			<div class="thongtintimkiem">
			<div class="container-fluid">
			
				
				<html:form action="/danh-sach" styleClass="form-group" method="post">

					<div>
					
					<div class="col-md-6">
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Selection Seach</label>
							    <div class="col-sm-8">
								    <label class="radio-inline">
									  <input type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1"> Final Score
									</label>
									<label class="radio-inline">
									  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2" checked="checked"> All
									</label>
									</div>
							  </div>
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Score</label>
							    	<div class="col-sm-8">
								    
								    <html:text property="score" styleClass="form-control" ></html:text>
								    </div>
							</div>
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Status</label>
							   		 <div class="col-sm-8">

										<html:select property="statusAccountId" styleClass="form-control">
											<option value="">All</option>
											<html:optionsCollection name="languageScoreForm" property="listStatus" 
												label="statusName" value="statusAccountId" />
										</html:select>
										
									 </div> 
							</div>
						
					</div>
					<div class="col-md-6 form-horizontal">
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Acount</label>
							    <div class="col-sm-8">
								    <html:text property="account" styleClass="form-control" ></html:text>
								  </div>
							</div>
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Full name</label>
							    <div class="col-sm-8">
								   <html:text property="fullName" styleClass="form-control" ></html:text>
								</div>
							</div>
							<div class="form-inline">
							    <label class="col-sm-4 control-label">Department</label>
							   		 <div class="col-sm-8">
									  
										<html:select property="departmentId" style="width: 196px !important" styleClass="form-control control-label">
											<option value="">All</option>
											<html:optionsCollection name="languageScoreForm" property="listDeparment" 
												label="departmentName" value="departmentId" />
										</html:select>
									 </div> 
							</div>
							
					</div>
						
					</div>
					<hr>
					<div id="duoi">
					<hr>
						<a href=""><strong>Table Configuration</strong></a>
						
						<span style="float: right;"><button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"> Seach</span> </button></span> 
					</div>

				 </html:form>
			</div>	
			</div>
		

				<div>
				<table id="example" class="table table-striped table-bordered">
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
							<logic:iterate name="languageScoreForm" property="listLanguageScore" id="ls">
							<tr>
								<td>
									<bean:write name="ls" property="accountName"/>
								</td>
								<td>
									<bean:write name="ls" property="fullName"/>
								</td>
								<td>
									<bean:write name="ls" property="departmentName"/>
								</td>
								<td>
									<bean:write name="ls" property="languageName"/>
								</td>
								<td>
									<bean:write name="ls" property="score"/>
								</td>
								<td>
									<bean:write name="ls" property="date"/>
								</td>
								<td>
									<bean:write name="ls" property="note"/>
								</td>
								
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
		$('#example').DataTable( {
			"bPaginate" : false,
			"bFilter" : false,
			"bInfo" : true,
			"paging" : true,
			"bLengthChange" : false,
			"pagingType" : "full_numbers"
		});

	});
</script>