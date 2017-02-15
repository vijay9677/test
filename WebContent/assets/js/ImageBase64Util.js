function readImage(inputElement) {
    var deferred = $.Deferred();

    var files = inputElement.get(0).files;
    if (files && files[0]) {
        var fr= new FileReader();
        fr.onload = function(e) {
            deferred.resolve(e.target.result);
        };
        fr.readAsDataURL( files[0] );
    } else {
        deferred.resolve(undefined);
    }

    return deferred.promise();
}

/**
 * usage
 */
/*$(input).on('change',function(){
	  readImage($(this)).done(function(base64Data){ alert(base64Data); });
	});

*or
*var inputElement = $("input[name=file]");
readImage(inputElement).done(function(base64Data){
    alert(base64Data);
});
*
*
*/