

/**
@Author: Zak Hassan


**/

(function(_){

_.growl = function ( gtitle, gtext) {
	new PNotify({
		title: gtitle,
		text: gtext
	})


_.getJSON = function ( appurl, action, payload, callback){

	$.ajax ({
		type: action,
		url: apiurl,
		contentType:"application/json",
		dataType: "json",
		cache: false,
		success: callback
	});
}



_.wrapTD= function(d){
	return "<td>"+ d + "</td>";
}



_.appendTableData= function( uri , callback){
	getJSON(uri, "GET", null , function(data){
		var html = callback();
		$("#tableContent").append(html);
	}
}


_.addItem = function(req, uri, callback){
	getJSON(uri, "POST", JSON.stringify(req), callback);
}

_.deleteItem = function(id, uri, callback ){
	getJSON(uri+id,"DELETE", null, callback);
}

_.makeModel = (function (formFields, id, title) {
        html = '<!-- Modal -->' +
            '<div class="modal fade" id="' + id + '" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">' +
            '<div class="modal-dialog">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
            '<h4 class="modal-title" id="myModalLabel">' + title + '</h4>' +
            '</div>' +
            '<div class="modal-body">' +
            formFields +
            '</div>' +
            '<div class="modal-footer">' + //   buttons+
            '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
            '<button type="button" onclick="createNewNode()" class="btn btn-primary">Save</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
        $("body").append(html);
    });

})(this);
