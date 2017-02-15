/**
 * @author vijay
 */
						$(document).ready(function(){
							$('#uniqueId').hide();
							var notiCountCall={
									url:path+"/getJobDetailsToShowNotificationstudentAction",
									
									success : function(jobNotification){
										//alert(noti);
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											
											
											$("#notificationDetails").append(
													"<li>" +
														"<a href='"+path+"/viewAndForwardingJobOpportunitiesAction?jobPostingID="+jobNotification[ind].jobPostingID+"'  class='clearfix'>"+ 
															"<img src='"+jobNotification[ind].companyLogo+"' class='msg-photo' />" +
															"<span class='msg-body'>" + 
															"<span class='msg-title'>" + 
																"<span class='blue'>"
																+ jobNotification[ind].jobPostingID + ':  ' +
																	jobNotification[ind].jobDescription + '   '+
																	' \n openings in  '+jobNotification[ind].companyName+
																	
																"</span>" 
															        +
															"</span> </span>" +
														"</a></li>");
						
										}
										
									},
									//data:{"jpID":jobNotification.jobPostingID},
									error : function(){
										
										alert("err");
									}
							}
							$.ajax(notiCountCall);
						});