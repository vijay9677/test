
<style>
	#change-password{
				display:none;
				width: 70%;
				height: auto;
				position: fixed;
				color: #000000;
				background-color: #ffffff;
				/* To align popup window at the center of screen*/
				top: 35%;
				left: 30%;
				margin-top: -100px;
				margin-left: -150px;
}
#successmask{
				width: 100%;
				height: 100%;
				top: 0;
				left: 0;
				display: none;
				position: absolute;				
				background-color: #cccccc;
				color: #aaaaaa;
				opacity: .4;
				filter: alpha(opacity = 50);
}

</style>

   <!-- popup -->
		<div id='successmask'  ></div>
<div id='change-password'>
		<form id="changepwdform" action="<%=application.getContextPath()%>/ChangePasswordAction" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
																										
		<input name='oldpwd' id='oldpwd'  type="password" class="form-control" placeholder="Enter Old Password" /><span class='status'></span>
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
		<input id='newpwd' name='newpwd'  type="password" class="form-control" placeholder="Enter New Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>
													
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
		<input id='confirmpwd' name='confirmpwd' type="password" class="form-control" placeholder="Confirm Password" />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<!--  <label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> Remember Me</span>
														</label>	-->

														<!--  <button type="button" class="width-35 pull-right btn btn-sm btn-primary">	-->
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110" ><input type="submit" value='submit' class="width-35 pull-right btn btn-sm btn-primary"></span>
														<!--  </button>		-->
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>


</div>
<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">NACRE SOFTWARE SERVICES Application &copy; 2016-2017</span>
							
						</span>

						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
<script>



</script>