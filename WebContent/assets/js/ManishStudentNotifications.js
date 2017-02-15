/**
 * @author Manish
 */


	//	var userId=1;
	
		$(document).ready(function(){
			var obj ={
					url:path+"/StudentNotificationAction",
					//data:{"userId":userId},
					success:function(data){
					
						$('#count-noti').html(data.length);
						$('#main-count-noti').html(data.length);
						for(var assess=0; assess<data.length; assess++){
							if(data[assess].course=="Core java" && data[assess].assessment_type_name=="Course wise assessment" )
							{
						var img="<img src='"+path+"/assets/images/nacre/cj1.png' class='msg-photo' alt='java assessment' />";
							}
						
						else if(data[assess].course=="Advance java" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='"+path+"/assets/images/nacre/ajava.png' class='msg-photo' alt='Advance java assessment' />";
								}
						
						else if(data[assess].course=="c#" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='"+path+"/assets/images/nacre/c1.png' class='msg-photo' alt='c# assessment' />";
								}
						
						else if(data[assess].course=="sql" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='"+path+"/assets/images/nacre/sql.png' class='msg-photo' alt='sql assessment' />";
								}
						
						else if(data[assess].course=="Html" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='"+path+"/assets/images/nacre/php.png' class='msg-photo' alt='Html assessment' />";
								}
						
						else if(data[assess].course=="CSS" && data[assess].assessment_type_name=="Course wise assessment" )
						{
							var img="<img src='"+path+"/assets/images/nacre/php.png' class='msg-photo' alt='CSS assessment' />";
								}
						
						else 
						{
							var img="<img src='"+path+"/assets/images/nacre/nacre.png' class='msg-photo' alt='company assessment' />";
								}
							$("#asd").append(
											"<li>" +
														"<a href='"+path+"/jsp/student/ViewDetails.jsp?assesId="+data[assess].assessment_id+"' class='clearfix' style='text-decoration:none; color:#000;'>"+ 
													"<div>"+img+"</div>" +
													" <span class='msg-body'>" + 
													"<span class='msg-title'>" + 
														"<span class='blue'>"
															+/*  data[assess].assessment_id + ': ' + */
															data[assess].assessment_name + 
														"</span>"+
														'Assessment type:='+data[assess].assessment_type_name+'; '+
														'Course:= '+data[assess].course+ '; '+
														'Date of test:= '+data[assess].date+ '; ' +
														'Total Marks:= '+ data[assess].total_marks+ '; '+ 
														'Duration (Minute):= '+ data[assess].duration_in_min +';' +
														
													"</span> </span>" +
												"</a></li>");
								}
					},
					error:function(){}
			}
			
			$.ajax(obj);
			
		});
		
		
