<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html class="no-js">
    
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查询/修改课程</title>
        <!-- Bootstrap -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
         <link href="assets/styles.css" rel="stylesheet" media="screen">
      <script src="vendors/jquery-1.11.2.min.js"></script>
       <script src="bootstrap/js/bootstrap.min.js"></script>
       
       		<script type='text/javascript'>
    (function () {
        var s = document.createElement('script');
        s.type = 'text/javascript';
        s.async = true;
        s.src = (location.protocol == 'https:' ? 'https://ssl.' : 'http://static.') + 'gridsumdissector.com/js/Clients/GWD-002498-0C1485/gs.js';
        var    firstScript = document.getElementsByTagName('script')[0];
        firstScript.parentNode.insertBefore(s, firstScript);
    })();
</script>
       
		<script type="text/javascript">
         jQuery(document).ready(function( $ ) {
        	 $.ajax({
		   	  	   type: "post",  //以post方式与后台沟通 
		   	       url : "getAllCourseList.action", 
		   	       async:false,
		   	       data : {		   	       		
		   	    	},
		    	   error : function(data){
		    		   //alert("project running error.");
		    	   },
		   	       success : function(data){
		   	    	//alert("project running error.");
		    	   }  	
		    });
         });
         
     	function onclick_Submit(dom){

   		 var $a= $(dom).parent().prev().find("input");
   		 var updateNewContent = $a.val(); 

   		 var $b = $(dom).parent().prev().prev().prev().find("input");
   		 var updateResendIntervals  = $b.val(); 
   		 
   		 var $c = $(dom).parent().prev().prev().prev().prev().find("input");
   		 var updateResendTimes = $c.val(); 
   		 
   		 var $d = $(dom).parent().prev().prev().prev().prev().prev();
   		 var updateChannel = $d.html();
   		 
   		 var $e = $(dom).parent().prev().prev().prev().prev().prev().prev();
   		 var updateTemplateId = $e.html();
  
   		 if(!(/^\d+(\.\d{2})?$/.test(updateResendTimes))){
           		alert("重发次数必须为数字！");
                   return;
           	}
         
        	if(!(/^\d+(\.\d{2})?$/.test(updateResendIntervals))){
           		alert("重发间隔必须为数字！");
                   return;
           	}

   		 
   		 
     	 $.ajax({
	   	  	   type: "post",  //以post方式与后台沟通 
	   	       url : "updateCourse.action", 
	   	       async:false,
	   	       data : {		  
	   	    	updateTemplateId:updateTemplateId,	   	 	
	   	 		updateChannel:updateChannel, 	 	
	   	 	 	updateResendTimes:updateResendTimes,	   	 	
	   	 		updateResendIntervals:updateResendIntervals,	
	   	 		updateNewContent:updateNewContent
	   	    	},
	    	   error : function(data){
	    		   alert("update fail.");
	    	   },
	   	       success : function(data){
	   	    	alert("update success.");
	    	   }  	
	    });
   		
     	  //错误提示信息
     	 var msg=""+'${request.tipMessage}'; 
     	  if(msg!=""){ 
     	     alert(msg); 
     	  } 
     	 
     	  
     	  
          function validateResendTimes(){
              var resendTimes= $("#resendTimes").val();
           	if(!(/^\d+(\.\d{2})?$/.test(resendTimes))){
           		alert("重发次数必须为数字！");
                   return false;
           	}
          }
           	
            function validateResendInterval(){
                var resendInterval= $("#resendInterval").val();
             	if(!(/^\d+(\.\d{2})?$/.test(resendInterval))){
             		alert("重发间隔必须为数字！");
                     return false;
             	}
            }
   	}
         
         
		 </script>
    </head>
    
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Admin Panel</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> SoulYoga Admin <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="adminChangePassword.jsp">Change password</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a tabindex="-1" href="userLoginOut.action">Logout</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">Dashboard</a>
                            </li>
							
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        
                        <li class="active">
                            <a href="./getAllCourseList.action"><i class="icon-chevron-right"></i> 课程查询</a>
                        </li>
						
                    </ul>
                </div>
                <!--/span-->
                <div class="span9" id="content">
				
					<div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">选择课程查询条件</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal"  action="getAllCourseList.action" method="post">
                                      <fieldset>

                                        <div class="control-group">
                                          <label class="control-label" for="select01">课程种类</label>
                                          <div class="controls">
                                            <select id="select01" class="chzn-select" name="templateIdValue">
                                            <option value="All">All</option>
                                            
                                            <!-- 
                                            <s:iterator value="#session.templateId_list" var="templateIdObject" >
                                              <option value="<s:property value="templateIdObject" />"><s:property value="templateIdObject" /></option>
											</s:iterator>
											 -->
															  						
                                            </select>
                                          </div>
                                        </div>
										<div class="control-group">
                                          <label class="control-label" for="select01">所属会所</label>
                                          <div class="controls">
                                            <select id="select02" class="chzn-select" name="channel">
                                            	<option value="All">All</option>
                                            </select>
                                          </div>
                                        </div>
                                        <div class="form-actions">
                                          <button type="submit" class="btn btn-primary">Select</button>
                                          <button type="reset" class="btn">Cancel</button>
                                        </div>
                                      </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span12">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">课程列表</div>
                                    <!--<div class="pull-right"><span class="badge  badge-info">1,234</span>
									
                                    </div>-->
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                               
                                                <th>课程 ID</th>
                                                <th>课程名称</th>
												<th>课程种类ID</th>
												<th>所属会所ID</th>
												<th>课程介绍</th>
												<th>点数</th>
												<th>创建时间</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
                                         <s:iterator value="#session.course_list" var="template" >
                                            <tr>
                                                <td><s:property value="#template.iD"/></td>
                                                <td><input class="input-small focused" id="resendTimes" type="text" value="<s:property value="#template.name" />"></input></td>
												<td><input class="input-small focused" id="resendTimes" type="text" value="<s:property value="#template.courseCategoryID" />"></input></td>
												<td><input class="input-small focused" id="resendInterval" type="text" value="<s:property value="#template.yogaClubID" />"></input></td>
                                                <td><input class="input-xlarge focused" id="focusedInput" type="textarea" value="<s:property value="#template.introduction" />"></input></td>
                                                <td><input class="input-small focused" id="resendInterval" type="text" value="<s:property value="#template.point" />"></input></td>
                                                <td><s:property value="#template.createdTime" /></td>
                                                <td><button onClick="onclick_Submit(this)">更 新</button></td>
                                            </tr>
                                          </s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
						
                    </div>
					
            </div>
            <hr>

        </div>
        <!--/.fluid-container-->


    </body>

</html>