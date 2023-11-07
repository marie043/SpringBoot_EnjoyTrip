const session_check_url = 'http://'+ip+'/EnjoyTrip/user/session';
function sessionCheck(){
	let userId = getCookie('id');
	let userPassword = getCookie('pw');
	fetch(session_cehck_url, {
		method: "GET",
		headers: {"Content-Type": "application/json"},
		body: JSON.stringify({userId, userPassword})
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		let msg = obj['msg'];
		let detail = obj['detail'];
		let name = obj['name'];
		let email_id = obj['eamil_id'];
		let email_domain = obj['email_domain'];
		if(msg=="OK"){
			document.getElementById('before-login').style.display='none';
			document.getElementById('after-login').style.display='block';
			document.getElementById('user-id-nim').innerText = name;
			alert(detail);
			return;
		}else{
			document.getElementById('before-login').style.display='block';
			document.getElementById('after-login').style.display='none';
			alert(detail);
			return;
		}
	});
}
function changePage(pageId){
	document.querySelectorAll('content').forEach(element=>{element.style.display='none'});
	document.getElementById(pageId).style.display='block';
}
sessionCheck();
changePage('home-page');