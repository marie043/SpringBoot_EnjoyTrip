document.querySelectorAll('.close-area').forEach(element=>{
	element.addEventListener('click', closeModal);
});

document.getElementById('login-button').addEventListener('click', function(){
	
});

document.getElementById('login-a').addEventListener('click', function(){
	document.getElementById('login-modal').style.display='flex';
});

document.getElementById('join-a').addEventListener('click', function(){
	document.getElementById('join-modal').style.display='flex';
});

function closeModal(){
	document.getElementById('login-modal').style.display='none';
	document.getElementById('join-modal').style.display='none';
}
