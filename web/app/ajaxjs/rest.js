
/*****************************
*  @Author: Zak Hassan
*  Javascript for connecting ui with backend
* "/api/jobs" 
* "/api/logs"
* "/api/nodes"
* "/api/alerts"
* "/api/users"
******************************/
 

(function(_){
	 
    // @usage: growl("Listen","Emergency4");
    _.growl= (function( gtitle, gtext ){
        new PNotify({
            title: gtitle,  
            text: gtext
        });
    });
    // @param apiurl    -    http://localhost:8080/api/logs
    // @param action    -    "POST" / "GET" / "DELETE"
    // @param callback  -    function(data) { }
    // @param payload   -    {"name": "zak",  .... }
    // @usage    getJSON("http://localhost:8080/api/logs","GET", null, function(data){ console.dir(data); });
 var getJSON= function( apiurl, action, payload, callback ){ $.ajax({
				type: action,    
				url:  apiurl,
                data: payload,
				dataType: "json",
				cache: false,
				success : callback
        }); } 
    
    
    // May decide to delete this.
    
	_.makeModel=(function(formFields, id, title ){   
		html='<!-- Modal -->'+
		'<div class="modal fade" id="'+id+'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">'+
			'<div class="modal-dialog">'+
				'<div class="modal-content">'+
				  '<div class="modal-header">'+
				    '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>'+
				    '<h4 class="modal-title" id="myModalLabel">'+title+'</h4>'+
				  '</div>'+
				  '<div class="modal-body">'+
				  formFields+
				  '</div>'+
				  '<div class="modal-footer">'+//	buttons+
				  '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'+
				    '<button type="button" onclick="" class="btn btn-primary">Save</button>'+
				  '</div>'+
				'</div>'+
			'</div>'+
		'</div>';
		$("body").append(html);
	
})();
 

})(this);