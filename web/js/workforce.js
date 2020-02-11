function loadIds(selectId) {
	var constructedUrl = "http://localhost:8080/employees/";

	var result;
	$.ajax({
		type: "GET",
		url: constructedUrl,
		success: function(data) {

			manage(data,selectId);

		},
		error: function(){
			alert("json not found");
		}
	});


}



function manage(objects,selectId) {
	var options;
	for (var i=0; i<objects.length; i++) {
		options += '<option value="'+objects[i].id+'">'+objects[i].id+'</option>';	
	}
	document.getElementById(selectId).innerHTML = options;
}



function update() {
	var editId = document.getElementById("employeeId")[document.getElementById("employeeId").selectedIndex].value;
	var editName = document.getElementById("editName").value;
	var editRole = document.getElementById("editRole")[document.getElementById("editRole").selectedIndex].value;


	var editEmployee = {
			"name": editName,
			"role": editRole
	}

	editEmployee = JSON.stringify(editEmployee) + '{"id":'+editId+'}';

	var constructedURL = "http://localhost:8080/employees/" + editId; //

	$.ajax({
		type: "PUT",
		contentType: "application/json",
		url: constructedURL,
		data: editEmployee, 
		success: function(data) {

		},
		error: function(){
			alert("json not found");
		}
	});

}



function deleteEmployee() {
	var deleteId = document.getElementById("deletedEmployeeId")[document.getElementById("deletedEmployeeId").selectedIndex].value;
	var constructedURL = "http://localhost:8080/employees/" + deleteId;

	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: constructedURL,
		data: deleteId, 
		success: function(data) {

		},
		error: function(){
			alert("json not found");
		}
	});

}



function seeAll() {

	var constructedUrl = "http://localhost:8080/employees/";

	var result;
	$.ajax({
		type: "GET",
		url: constructedUrl,
		success: function(data) {

			print(data, "result");

		},
		error: function(){
			alert("json not found");
		}
	});


}



function seeRole() {

	var role = document.getElementById("role")[document.getElementById("role").selectedIndex].value;
	var constructedUrl = "http://localhost:8080/employees/role/";

	var result;
	$.ajax({
		type: "GET",
		url: constructedUrl + role,
		success: function(data) {

			print(data, "resultRole");

		},
		error: function(){
			alert("json not found");
		}
	});


}



function addNew() {

	var newEmployeeName = document.getElementById("name").value;
	console.log(newEmployeeName);

	var newEmployeeRole = document.getElementById("role")[document.getElementById("role").selectedIndex].value;



	var newEmployee = {
			"name": newEmployeeName,
			"role": newEmployeeRole
	}


	console.log(newEmployee);


	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "http://localhost:8080/employees",
		data: JSON.stringify(newEmployee),    
		success: function(data) {

		},
		error: function(){
			alert("json not found");
		}
	});

}



function print(objects, id) {

	var result = "";
	if (objects.length>0) {
		for (var i=0; i<objects.length; i++) {
			result += JSON.stringify(objects[i])+"<br>";
		}

	}
	else {
		result = "NO RESULTS";
	}
	document.getElementById(id).innerHTML = result;
}
