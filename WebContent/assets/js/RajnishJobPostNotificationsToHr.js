/**
 * rajnish Job Post Notifications
 */
						
	
						$(document).ready(function(){
							var notiCountCall={
									url:path+"/JobPostingNotificatonActionRajnish",
									
									success : function(jobNotification){
										
										$("#mainNotificationCount").html(jobNotification.length);
										$("#notificationCount").html(jobNotification.length);
										for (var ind = 0; ind < jobNotification.length; ind++) {
											$("#notificationDetails").append(
													"<li>" +
													"<a href='"+path+"/JobPostingNotificationDetailAction?jobPostingID="+jobNotification[ind].jobPostId+"'  class='clearfix'>"+
													"<img src='"+jobNotification[ind].images+"' class='msg-photo' />" +
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" +
																"<span class='blue'>"
																 
                                                             
                                                                + ' Description: ' +jobNotification[ind].jobDescription +' Expected Date:  ' + jobNotification[ind].expectedDate  + ' Assesment Start Date:  '+jobNotification[ind].assStartDate +'Assesment End Date :' + jobNotification[ind].assEndDate+ 'Posted Date :' + jobNotification[ind].postDate + 'No Of Vacancies :' + jobNotification[ind].vacancies +  
																"</span>" 
															        +"</span> </span>" +"</a></li>");
											
											
										}
										
									},
									
									error : function(){}
							}
							$.ajax(notiCountCall);
						});
	