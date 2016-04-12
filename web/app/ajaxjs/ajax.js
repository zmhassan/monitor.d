var maxLength = 50

	$(document).ready(function () {
		$("#permission_name").attr('maxlength', maxLength);
		$("#up_permission_name").attr('maxlength', maxLength);
	});

	var addPermission=function() {
		var valid = true;
		var addForm = document.getElementById("addPermissionForm");
		var errors = new Array();
		var elementsId = new Array();

		for (var i = 0, j = 0; i < addForm.length - 2; ++i) {
			if (validate_empty(addForm.elements[i].value)) {
				valid = false;
				errors[j] = addForm.elements[i].getAttribute("name") + " is required";
				elementsId[j++] = addForm.elements[i].getAttribute("id");
			}
			else {
				if (!validate_length(addForm.elements[i].value, maxLength)) {
					valid = false;
					errors[j] = addForm.elements[i].getAttribute("name")  + " must be " +
					"equal to or under " + maxLength + " characters long";
					elementsId[j++] = addForm.elements[i].getAttribute("id");
				}
			}

		}

		if (valid) {
			$.ajax({
				type: "POST",
				url: "api/permission",
				data: {
					permission_name: document.getElementById("permission_name").value
			   	},
				dataType: "json",
				cache: false,
				success : function(data){
			    	if (data.success === "true") {
			    		$.pnotify({
							title : 'New Access Level Added',
							type : 'info',
							text : 'Access Level ' + document.getElementById('permission_name').value + ' has been added'
						});

			    		// Form needs resetting due to never being submitted
			    		document.getElementById("addPermissionForm").reset();

			    		for (i = 0; i < addForm.length - 2; ++i) { // Remove red border on form elements
			    			addForm.elements[i].style.border = "solid 1px #D1D7DF";
			    		}

			    		$('#addPermissionModal').modal('hide');

			    		location.reload(); // Refresh page..
				   	}
				}
			});
	   }
	   else { // Handle forms errors
		   for (i = 0; i < errors.length; ++i) {
				$.pnotify({
					title : 'Error',
					type : 'info',
					text : errors[i]
				});
				document.getElementById(elementsId[i]).style.border = "solid 1px red";
			}
	   }
	};


	var updatePermission=function() {
		var valid = true;
		var updateForm = document.getElementById("updatePermissionForm");
		var errors = new Array();
		var elementsId = new Array();

		var accessLevelId = document.getElementById("up_permission_id");

		for (var i = 0, j = 0; i < updateForm.length - 2; ++i) {
			if (validate_empty(updateForm.elements[i].value)) {
				valid = false;
				errors[j] = updateForm.elements[i].getAttribute("name") + " is required";
				elementsId[j++] = updateForm.elements[i].getAttribute("id");
			}
			else {
				if (!validate_length(updateForm.elements[i].value, maxLength)) {
					valid = false;
					errors[j] = updateForm.elements[i].getAttribute("name")  + " must be " +
					"equal to or under " + maxLength + " characters long";
					elementsId[j++] = updateForm.elements[i].getAttribute("id");
				}
			}
		}

		if (!validate_integer(accessLevelId.value)) {
			valid = false;
		   	errors[j] = accessLevelId.getAttribute("name") + "  must be a number";
		   	elementsId[j++] = accessLevelId.getAttribute("id");
		}

		if (valid) {
			$.ajax({
				type: "POST",
				url: "api/permission/"+accessLevelId.value,
				data: {
					permission_name: document.getElementById("up_permission_name").value
			   	},
				dataType: "json",
				cache: false,
				success : function(data){
			    	if (data.success === "true") {
			    		$.pnotify({
							title : 'Permission Updated',
							type : 'info',
							text : 'Permission ' + document.getElementById("up_permission_name").value + ' has been updated'
						});

			    		// Form needs resetting due to never being submitted
			    		document.getElementById("updatePermissionForm").reset();

			    		for (i = 0; i < updateForm.length - 2; ++i) { // Remove red border on form elements
			    			updateForm.elements[i].style.border = "solid 1px #D1D7DF";
			    		}

			    		$('#updatePermissionModal').modal('hide');

			    		location.reload(); // Refresh page..
				   	}
				}
			});
		}
		else { // Handle form errors
			for (i = 0; i < errors.length; ++i) {
				$.pnotify({
					title : 'Error',
					type : 'info',
					text : errors[i]
				});
				document.getElementById(elementsId[i]).style.border = "solid 1px red";
			}
		}
	};

	var deletePermission= function() {
		var valid = true;
		var errors = "";

		var accessLevelId = document.getElementById('del_permission_id');

		if (!validate_integer(accessLevelId.value)) {
			valid = false;
			errors = accessLevelId.getAttribute("name") + "  must be a number";
		}

		if (valid) {
		 	$.ajax({
		 		type:"DELETE",
			  	url : "api/permission/"+accessLevelId.value,
			  	data : null,
			  	cache : false,
			  	success : function(data){
		     		if (data.success === "true") {
		    			$.pnotify({
							title : 'Permission: ' + document.getElementById("del_permission_name").value,
							type : 'info',
							text : 'Permission has been deleted'
						});
		  			}
		     		location.reload(); // Refresh page..
		 	  	}
		 	});
		}
		else { // Handle HTML inspect errors
			$.pnotify({
				title : 'Error',
				type : 'info',
				text : errors
			});
		}
	};

   var updateForm=function(up_permission_id, up_permission_name){
		$("#up_permission_id").val(up_permission_id);
		$("#up_permission_name").val(up_permission_name);
	};

	var deleteForm=function(del_permission_id, del_permission_name){
		$("#del_permission_id").val(del_permission_id);
		$("#del_permission_name").val(del_permission_name);
	};
