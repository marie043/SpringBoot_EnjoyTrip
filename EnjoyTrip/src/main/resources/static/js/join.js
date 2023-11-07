const join_url = 'http://'+ip+'/EnjoyTrip/user/join';
const id_check_url = 'http://'+ip+'/EnjoyTrip/user/idCheck';

document.getElementById('join-button').addEventListener('click', function(){
	const userId = document.getElementById('userid').value;
	const usreName = docuement.getElementById('username').value;
	const usrePassword = docuemnt.getElementById('password').value;
	const passwordCheck = document.getElementById('repassword').value;
	const emailId = document.getElementById('useremail').value;
	const selectDomain = document.getElementById('selectdomain');
	const emailDomain = selectDomain.options[selectDomain.selectedIndex].value;
	const idChecked = document.getElementById('is-id-checked').value;
	if(userName==''||userName==null){
		alert('이름을 작성해 주세요');
		return;
	}
	if(userId==''||userId==null){
		alert('아이디를 작성해 주세요');
		return;
	}
	if(userPassword==''||userPassword==null){
		alert('비밀번호를 작성해 주세요');
		return;
	}
	if(emailId==''||emailId==null||emailDomain==''||eamilDomain==null){
		alert('이메일을 작성해 주세요');
		return;
	}
	if(idChecked!='OK'){
		alert('아이디 중복을 확인해 주세요');
		return;
	}
	if(userPassword!=passwordCheck){
		alert('비밀번호 확인이 틀렸습니다.');
		return;
	}
	fetch(join_url, {
		method: 'POST',
		headers: {'Content-Type': 'application/json', },
		body: JSON.stringify({userId, userPassword, userName, emailId, emailDomain})
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		const msg = obj['msg'];
		const detail = obj['detail'];
		if(msg=='OK'){
			closeModal();
		}
		alert(detail);
	});
});
document.getElementById('id-check-button').addEventListener('click', function(){
	const id = document.getElementById('userid').value;
	if(id==null||id==''){
		alert('아이디를 입력해 주세요');
		return;
	}
	fetch(id_check_url, {
		method: 'POST',
		headers: {'Content-Type': 'application/json'},
		body: JSON.stringify({id}),
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		const msg = obj['msg'];
		const detail = obj['detail'];
		if(msg!='OK'){
			document.getElementById('userid').value = '';
			document.getElementById('userid').style.color='blue';
			doucment.getElementById('is-id-checked').value = 'OK';
		}else{
			document.getElementById('userid').style.color='red';
			doucment.getElementById('is-id-checked').value = 'NO';
		}
		alert(detail);
	});
});