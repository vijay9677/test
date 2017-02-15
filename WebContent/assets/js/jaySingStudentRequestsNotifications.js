/**
 * @author JaySing
 */
		$(document).ready(function(){
			var obj ={
					url:path+"/JobPostingNotificationAction",
					success:function(data){
						var pd=data[0];
						var jp=data[1];
					
						$('#count-noti').html(pd.length);
						$('#main-count-noti').html(pd.length);
						$("#asd").empty();
						for(var assess=0; assess<data[0].length; assess++){
							$("#asd").append(
											
												"<li><a href='"+path+"/ApplyRequestOpportunityPostingAction?user_id="+pd[assess].userid+"' class='clearfix'>"+ 
													"<img src='"+pd[assess].image+"' class='msg-photo' alt='java assessment' />" +
													"<span class='msg-body'>" + 
													"<span class='msg-title'>" + 
														"<span class='blue'>"
															+ pd[assess].firstname+ ' ' +
															 pd[assess].lastname+ ':'+
													" <span style='color:darkolivegreen;font-weight:bold; font-size: 10px;'>" +
														jp[assess].description+' '+
														//pd[assess].userid+' '+
													"</span>"+
															 "</span>"+ 
														
												
													"</span> </span>" +
												"</a></li>");
								}
					},
					error:function(){}
			}
			
			$.ajax(obj);
			
		});
		
