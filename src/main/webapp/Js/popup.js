var btnAbrirPopup = document.getElementById('bton-owner'),
overlay = document.getElementById('overlay'),
popup = document.getElementById('popup'),
btnCerrarPopup = document.getElementById('btn-cerrar-popup');

///////////////////////////////////////////////////
    btnAbrirPopupVet = document.getElementById('bton-vet'),
    overlayVet = document.getElementById('overlayVet'),
    popupVet = document.getElementById('popupVet'),
    btnCerrarPopupVet = document.getElementById('btn-cerrar-popupVet');

/////////////////////////////////////////////////////
    btnAbrirPopupOff = document.getElementById('bton-official'), 
    overlayOff = document.getElementById('overlayOff'),
    popupOff = document.getElementById('popupOff'),
    btnCerrarPopupOff = document.getElementById('btn-cerrar-popupOff');
    
	  
	

btnAbrirPopup.addEventListener('click', function(){
	overlay.classList.add('active');
	popup.classList.add('active');

});
btnCerrarPopup.addEventListener('click', function(e){
	e.preventDefault();
	overlay.classList.remove('active');
	popup.classList.remove('active');
});

////////////////////////////////////////////////////
btnAbrirPopupVet.addEventListener('click', function(){
	overlayVet.classList.add('active');
	popupVet.classList.add('active');
    });
btnCerrarPopupVet.addEventListener('click', function(e){
	e.preventDefault();
	overlayVet.classList.remove('active');
	popupVet.classList.remove('active');
});

//////////////////////////////////////////////////////
btnAbrirPopupOff.addEventListener('click', function(){
	overlayOff.classList.add('active');
	popupOff.classList.add('active');
    });
btnCerrarPopupOff.addEventListener('click', function(e){
	e.preventDefault();
	overlayOff.classList.remove('active');
	popupOff.classList.remove('active');
});