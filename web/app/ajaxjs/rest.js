
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
	
   
    
    _.growl= (function( gtitle, gtype, gtext ){
        $.pnotify({
                    title : gtitle, //'New Access Level Added',
                    type : gtype, //'info',
                    text : gtext //'Access Level ' + document.getElementById('permission_name').value + ' has been added'
        });
    });
    // @param apiurl    -    http://localhost:8080/api/logs
    // @param action    -    "POST" / "GET" / "DELETE"
    // @param callback  -    function(data) { }
    // @param payload   -    {"name": "zak",  .... }
    //
    _.reqJson =(function( apiurl, action, payload, callback ){   
    
        $.ajax({
				type: action,   //  "POST",
				url:  apiurl,   //  "api/permission",
				data: payload,  //  { permission_name: document.getElementById("permission_name").value },
				dataType: "json",
				cache: false,
				success : callback  // function(data){}
        });
        
    })();
    
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