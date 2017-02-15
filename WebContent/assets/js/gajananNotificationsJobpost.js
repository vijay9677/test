/**
 *@author Gajanan 
 */				
		$(document).ready(function(){
			//alert("gaj");
							var notiCountCall={
									url:path+"/getJobDetailsToShowNotification",
									
									success : function(jobNotification){
										
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											$("#notificationDetails").append(
													"<li>" +
														"<a href='"+path+"/jsp/student/jobdescription.jsp?JobpostId="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
															"<img src='"+jobNotification[ind].companyLogo+"' class='msg-photo' />" +
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																	+ jobNotification[ind].jobPostingID + ':' +
																	jobNotification[ind].jobDescription + 
																"</span>" 
															        +
															"</span> </span>" +
														"</a></li>");
						
										}
										
									},
									//data:{"jpID":jobNotification.jobPostingID},
									error : function(){}
							}
							$.ajax(notiCountCall);
							
		});
				