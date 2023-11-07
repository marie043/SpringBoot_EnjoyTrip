document.getElementById('login-button').addEventListener('click', function(){
	console.log('로그인 버튼 눌림');
});

document.getElementById('login-a').addEventListener('click', function(){
	document.getElementById('login-modal').style.display='flex';
});
document.getElementById('join-a').addEventListener('click', function(){
	document.getElementById('join-modal').style.display='flex';
});