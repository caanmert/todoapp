function openForm(val){
	document.getElementById("todoid").value = val.value;
	document.querySelector(".form-popup").style.display = "flex";
}

function closeForm() {
	document.querySelector(".form-popup").style.display = "none";
}
function getTodoID(){
	var id = document.getElementById('getid');
	alert(id);
}



