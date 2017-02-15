$(document).ready(function() {

	 $("#Jdatatable").dataTable( {
	        "bProcessing": false,
	        "bServerSide": false,
	        "url": "<%=application.getContextPath()%>/GetAllFeebacksAction",
	        "bJQueryUI": true,
	        "aoColumns": [
	            { "mData": "ClientName" },
	            { "mData": "City" }
	            
	        ]
    } ); 
} );

