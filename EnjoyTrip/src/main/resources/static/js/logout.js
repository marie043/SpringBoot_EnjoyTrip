const logout_url = 'http://'+ip+'/EnjoyTrip/user/logout';

document.getElementById('logout-button').addEventListener('click', function(){
	fetch(logout_url, {
		methd:'GET',
	}).then(function(res){
		return res.json();
	}).then(function(obj){
		let msg = obj['msg'];
		let detail = obj['detail'];
		if(msg=='OK'){
			document.getElementById('before-login').style.display='block';
			document.getElementById('after-login').style.display='none';
		}
		alert(detail);
	})
	
});