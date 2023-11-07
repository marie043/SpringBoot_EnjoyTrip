const login_url = 'http://'+ip+'/EnjoyTrip/user/login'

document.getElementById('login-button').addEventListener('click', function(){
	let userId = document.getElementById('login-id').value;
	let userPassword = document.getElementById('login-password').value;
	let saveid = document.getElementById('saveid').checked;
	if(userId==null||userId==''){
		alert('아이디를 입력해 주세요');
		return;
	}
	if(userPassword==null||userPassword==''){
		alert('비밀번호를 입력해 주세요');
		return;
	}
	if(saveid==true){
		setCookie('id', userId);
		setCookie('pw', userPassword);
	}
	fetch(login_url, {
		method: 'POST',
		headers: { 'Content-Type': 'application/json', },
		body: JSON.stringify({userId, userPassword})
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		const msg = obj['msg'];
		const detail = obj['detail'];
		const name = obj['name'];
		const email_id = obj['email_id'];
		const email_domain = obj['email_domain'];
		if(msg=='OK'){
			closeModal();
			document.getElementById('before-login').style.display='none';
			document.getElementById('after-login').style.display='block';
			document.getElementById('user-id-nim').innerText = name;
		}
		alert(detail);
	});
});
