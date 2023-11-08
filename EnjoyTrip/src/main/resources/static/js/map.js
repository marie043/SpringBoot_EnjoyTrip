var markers = [];
var ps = new kakao.maps.services.Places();
function changeGugun(){
	const select = document.getElementById('search-area');
	const sido = select[select.selectedIndex].value;
	console.log(sido);
	document.querySelectorAll('#search-sigungu>option').forEach(function(e){
		if(e.getAttribute('class')==sido){
			e.style.display = 'block';
		}else{
			e.style.display = 'none';
		}
	});
}

function mapChange(){
	
}