function leerCookie(nombre) {
    var lista = document.cookie.split(";");
    for (i in lista) {
        var busca = lista[i].search(nombre);
        if (busca > -1) {micookie=lista[i]}
    }
    var igual = micookie.indexOf("=");
    var valor = micookie.substring(igual+1);
    return valor;
}
function printTable(){
    var finalUsername = leerCookie("userName")
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {
                var botonId = "idBoton"+i
                var boton = "boton" + i
                var boton2 = "boton2"+i
                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].name_id}</td>
                <td>${data[i].microchip}</td>
                <td>${data[i].name}</td>
                <td>${data[i].species}</td>
                <td>${data[i].race}</td>
                <td>${data[i].size}</td>
                <td>${data[i].sex}</td>
                <td></td>
                 <td>
                     <a class= "cta" id="${boton}" value="${data[i].name_id}"  href="#" ><button value="${i}" onclick="cookieSelectedButton(${data[i].owner_id})"  id="${botonId}" >Update</button></a>
                </td>
                 <td>
                    <a class= "cta" href="#" value="${data[i].name_id}" id="${boton2}"><button  value="${i}" onclick="cookieSelectedButton(${data[i].owner_id})" id="${botonId}" >Case</button></a>
                </td>
                </tr>`
                var boton = document.getElementById(boton)
                boton.addEventListener("click", () => {
                    console.log("melo")
                    header = document.getElementById("overlay")
                    header.style.visibility = "visible"

                })


            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/'+finalUsername, true);
    xhr.send()

}

function cookieSelectedButton(value){
    var value = "selected="+value
    document.cookie = value
}



function laBrix(id){
    var btnAbrirPopup = document.getElementById(id),
        overlay = document.getElementById('overlay'),
        popup = document.getElementById('popup'),
        btnCerrarPopup = document.getElementById('btn-cerrar-popup');


    btnAbrirPopup.addEventListener('click', function(){
        overlay.classList.add('active');
        popup.classList.add('active');

    });

    btnCerrarPopup.addEventListener('click', function(e){
        e.preventDefault();
        overlay.classList.remove('active');
        popup.classList.remove('active');
    });

}

function ahiram(id){
    btnAbrirPopupVet = document.getElementById(id),
        overlayVet = document.getElementById('overlayVet'),
        popupVet = document.getElementById('popupVet'),
        btnCerrarPopupVet = document.getElementById('btn-cerrar-popupVet');

    btnAbrirPopupVet.addEventListener('click', function(){
        overlayVet.classList.add('active');
        popupVet.classList.add('active');
    });
    btnCerrarPopupVet.addEventListener('click', function(e){
        e.preventDefault();
        overlayVet.classList.remove('active');
        popupVet.classList.remove('active');
    });
}



printTable();
