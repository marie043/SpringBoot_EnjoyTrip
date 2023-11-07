const ip = 'localhost';
const session_check_url = 'http://'+ip+'/EnjoyTrip/user/session';

sessionCheck();
changePage('home-page');
document.getElementById('home-link').addEeventListener('click', function(){
	changePage('home-page');
});
document.getElementById('map-link').addEeventListener('click', function(){
	changePage('map-page')
});
document.getElementById('board-link').addEeventListener('click', function(){
	changePage('board-page');
});
document.getElementById('update-link').addEeventListener('click', function(){
	changePage('update-page');
});
document.querySelectorAll('.close-area').forEach(element=>{
	element.addEventListener('click', closeModal);
});
document.getElementById('login-a').addEventListener('click', function(){
	document.getElementById('login-modal').style.display='flex';
	const id = getCookie('id');
	const pw = getCookie('pw');
	if(id!=null&&pw!=null){
		document.getElementById('login-id').value = id;
		document.getElementById('login-password').value = pw;
	}
});
document.getElementById('join-a').addEventListener('click', function(){
	document.getElementById('join-modal').style.display='flex';
});

function sessionCheck(){
	let userId = getCookie('id');
	let userPassword = getCookie('pw');
	if(userId==null||userPassword==null){
		document.getElementById('before-login').style.display='block';
		document.getElementById('after-login').style.display='none';
		return;
	}	
	fetch(session_check_url+`?userId=${userId}&userPassword=${userPassword}`, {
		method: "GET",
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
function closeModal(){
	document.getElementById('login-modal').style.display='none';
	document.getElementById('join-modal').style.display='none';
}