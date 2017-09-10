
function sugerencia() {
	var popup = document.getElementById("myPopup");
	var dropdown = document.getElementById("dropdown1");
	var cursorPosition = $('#s3d').prop("selectionStart");
	var $input = $('#s3d');
	var poss = resetOffset2($input);
	popup.style.left=(poss.left) + "px";
	//popup.style.marginTop =poss.top+ "px";
	//popup.style.top =poss.top+ "px";
	//popup.style.paddingTop=poss.top+ "px";
	//popup.style.borderTop=poss.top+ "px";
	//popup.classList.toggle("show");
	var elemento = document.getElementById('dropdown2');
	if (elemento.style.display == 'none'){
		elemento.style.display ='block';
		elemento.style.top = (poss.top+20)+'px';
		elemento.style.left = poss.left+'px';
		//console.log(elemento.style.top + '  ' + poss.top);	
	}else{
		elemento.style.display ='none';
	
	}
	//console.log(elemento.style);
}

function pulsar(e) { 
	tecla=(document.all) ? e.keyCode : e.which; 
	var elemento = document.getElementById('dropdown2');
	elemento.style.display ='none';
	if (e.ctrlKey && tecla == 32 ){	
		sugerencia();
	} 
}

function resetOffset2($textField) {
	var offset = $textField.caret('offset');
	var position = $textField.caret('position');
	return offset;
}

