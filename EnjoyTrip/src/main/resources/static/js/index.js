const ip = 'localhost';
const session_check_url = 'http://'+ip+'/EnjoyTrip/user/session';

changePage('home-page');
document.getElementById('home-link').addEventListener('click', function(){
	changePage('home-page');
});
document.getElementById('map-link').addEventListener('click', function(){
	changePage('map-page')
});
document.getElementById('board-link').addEventListener('click', function(){
	changePage('board-page');
});
document.getElementById('update-link').addEventListener('click', function(){
	changePage('update-page');
});
document.querySelectorAll('.close-area').forEach(element=>{
	element.addEventListener('click', closeModal);
});
document.getElementById('login-a').addEventListener('click', function(){
	document.getElementById('login-modal').style.display='flex';
	if(getCookie('saveid')!=null){
	const id = getCookie('id');
	const pw = getCookie('pw');
	if(id!=null&&pw!=null||id!=''||pw!=''){
		document.getElementById('login-id').value = id;
		document.getElementById('login-password').value = pw;
	}
	}
});
document.getElementById('join-a').addEventListener('click', function(){
	document.getElementById('join-modal').style.display='flex';
});
let userId_session = getCookie('id');
let userPassword_session = getCookie('pw');
if(userId_session==null||userPassword_session==null||userId_session==''||userPassword_session==''){
	document.getElementById('before-login').style.display='block';
	document.getElementById('after-login').style.display='none';
}else{
	fetch(session_check_url, {
		method: "POST",
		headers: { 'Content-Type': 'application/json', },
		body: JSON.stringify({userId: userId_session, userPassword: userPassword_session}),
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		const msg = obj['msg'];
		const detail = obj['detail'];
		const name = obj['name'];
		const email_id = obj['eamil_id'];
		const email_domain = obj['email_domain'];
		if(msg=="OK"){
			document.getElementById('before-login').style.display='none';
			document.getElementById('after-login').style.display='block';
			document.getElementById('user-name-nim').innerText = name;
			document.getElementById('login-info-name').value = name;
			document.getElementById('login-info-email-id').value = email_id;
			document.getElementById('login-info-email-domain').value = email_domain;
		}else{
			document.getElementById('before-login').style.display='block';
			document.getElementById('after-login').style.display='none';
			alert(detail);
		}
	});
}
function changePage(pageId){
	document.querySelectorAll('content').forEach(element=>{element.style.display='none'});
	document.getElementById(pageId).style.display='block';
}
function closeModal(){
	document.getElementById('login-modal').style.display='none';
	document.getElementById('join-modal').style.display='none';
}