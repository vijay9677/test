/**
 *@author mounika b35 
 */


							var notiCountCall={
									url:path+"/GetAssessmentDetailsToTechTeam.techTeam",
									success : function(assesmentNotification){
										$("#mainAssesmentCount").html(assesmentNotification.length);
										$("#assesmentCount").html(assesmentNotification.length);
										if(assesmentNotification.length==0){
											$("#assesmentDetails").append(
													"NO NOTIFICATIONS ARE AVAILABLE");
										}
										for (var ind = 0; ind < assesmentNotification.length; ind++){
											

										if(assesmentNotification[ind].course.course=="core Java" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
											{
											var img="<img src='"+path+"/assets/images/nacre/cj1.png' class='msg-photo' alt='java assessment' />";
											}
										
										else if(assesmentNotification[ind].course.course=="Adv Java" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='"+path+"/assets/images/nacre/ajava.png' class='msg-photo' alt='java assessment' />";
												}
										
										else if((assesmentNotification[ind].course.course=="c#"||assesmentNotification[ind].course.course=="asp.net") && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='"+path+"/assets/images/nacre/c1.png' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="Sql" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='"+path+"/assets/images/nacre/sql.png' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="Html" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='"+path+"/assets/images/nacre/php.png' class='msg-photo' alt='java assessment' />";
												}
										
										else if(assesmentNotification[ind].course.course=="CSS" && assesmentNotification[ind].assesmentType.assesmentTypeName=="Course Wise Assessment" )
										{
											var img="<img src='"+path+"/assets/images/nacre/php.png' class='msg-photo' alt='java assessment' />";
												}
										
										else 
										{
											var img="<img src='"+path+"/assets/images/nacre/nacre.png' class='msg-photo' alt='java assessment' />";
												}
										var assessmentId, assessmentName,durationTime,date,course,assesmentType,level,totalMarks;
										if(assesmentNotification[ind].assesmentId == 0){
											 assessmentId= "NA";
											}else{
												assessmentId= assesmentNotification[ind].assesmentId;
											}
										
										if(assesmentNotification[ind].assesment== null){
											assessmentName = "NA";
											}else{
												assessmentName=assesmentNotification[ind].assesment;
											}
										
										if(assesmentNotification[ind].date==null){
											date = "NA";
											}else{
												date=assesmentNotification[ind].date;
											}
										if(assesmentNotification[ind].course.course==null){
											course= "NA";
											}else{
												course=assesmentNotification[ind].course.course;
											}
										
												
											$("#assesmentDetails").append(
													"<li>" +
														"<a href='"+path+"/jsp/technical_team/techTeamNotiDetails.jsp?assesId="+ assesmentNotification[ind].assesmentId+"' class='clearfix'>"+
														"<div>"+img+"</div>"+ 
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																	+ assessmentId + ':' +
																	  assessmentName +'  :  '+
																"</span>" 
																	  +course+ ' Test '+ 
															'On  :  '+date + '.'+ 
															"</span> </span>" +
														"</a></li>");
										}

									},
									error : function(){}
							}
							$.ajax(notiCountCall);
	