const board_list_url = 'http://'+ip+'/EnjoyTrip/board/list'
const board_pagenation_url = 'http://'+ip+'EnjoyTrip/board/page';
document.getElementById('board-link').addEventListener('click', function(){
	changePage('board-page');
	const tbody = document.getElementById('board-list-tbody');
	
});

function getBoardList(pgno, key, word){
	makePageNation(pgno, key, word);
	fetch(board_list_url, {
		
	});
	
}

function makePageNation(pngo, key, word){
	fetch(boad_pagenation_url,{
		
	})
}