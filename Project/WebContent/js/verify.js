var xmlhttp;
function judge(){
	var username = document.getElementById("username").value;
	xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange = callback;
	xmlhttp.open("GET","UserServlet?username",true);
	xmlhttp.send(null);
}

function callback(){
	
	
}