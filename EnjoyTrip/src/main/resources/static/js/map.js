const search_map_url = 'http://'+ip+'/EnjoyTrip/map/search';
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