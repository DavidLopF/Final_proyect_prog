function leerCookie(nombre) {
    var lista = document.cookie.split(";");
    for (i in lista) {
        var busca = lista[i].search(nombre);
        if (busca > -1) {
            micookie = lista[i]
        }
    }
    var igual = micookie.indexOf("=");
    var valor = micookie.substring(igual + 1);
    return valor;
}

function crearCookie(value) {
    document.cookie = "selectedButton=" + value
}

function printTable() {
    var finalUsername = leerCookie("userName")
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            console.log(data)
            var cont = ""
            var tbodyRef = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {
                console.log(data[i].url)
                var ruta = data[i].url.split('\\')
                var imagen = ruta[ruta.length - 2] + '/' + ruta[ruta.length - 1];
                cont += data[i].id + "/"

                imagen = imagen.split("/")
                imagen = imagen[imagen.length - 2] + "/" + imagen[imagen.length - 1]

                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].id}</td>
                <td>${data[i].microship}</td>
                <td>${data[i].name}</td>
                <td>${data[i].specie}</td>
                <td>${data[i].race}</td>
                <td>${data[i].size}</td>
                <td>${data[i].sex}</td>
                <td><img src="${'images/'+data[i].url}", width="100", height="100" style="border-radius: 2px"></td>
                <td>
                  <a class= "cta"  href="#" id=""><button onclick="crearCookie(${data[i].id})">Modify</button></a>
                </td>
                <td>
                <a class= "cta1" href="#" id=""><button onclick="crearCookie(${data[i].id})">Case</button></a>
                </td>   
                </tr>`
            }
            createListener()
            var cerrar = document.getElementById("cerrar")
            cerrar.addEventListener("click", () => {
                header = document.getElementById("overlay")
                header.style.visibility = "hidden"
            })

            var cerrar2 = document.getElementById("btn-cerrar-popupVet")
            cerrar2.addEventListener("click", () => {
                header = document.getElementById("overlayVet")
                header.style.visibility = "hidden"
            })

        }
    }
    xhr.open('GET', 'http://35.206.97.221:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/' + finalUsername, true);
    xhr.send()

}

function createListener() {
    var boton = document.getElementsByClassName("cta")
    for (let i = 1; i < boton.length; i++) {
        boton[i].addEventListener("click", () => {
            header = document.getElementById("overlay")
            header.style.visibility = "visible"
        })
    }

    var boton2 = document.getElementsByClassName("cta1")
    for (let i = 0; i < boton2.length; i++) {
        boton2[i].addEventListener("click", () => {
            form = document.getElementById("overlayVet")
            form.style.visibility = "visible"
        })
    }
}


printTable();

function selectVet() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("selectVisits")
            tbodyRef.innerHTML = ""

            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <option value="${data[i].userName}">${data[i].name}</option>
                `
            }

        }
    }
    xhr.open('GET', 'http://35.206.97.221:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/list', true);
    xhr.send(null)
}
selectVet()

function tableVisit() {
    var username = document.getElementById("selectVisits").value
    var type = document.getElementById("selectType").value
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        var data = JSON.parse(xhr.responseText);
        var tbodyRef = document.getElementById("res")
        tbodyRef.innerHTML = ""
        for (let i = 0; i < data.length; i++) {
            tbodyRef.innerHTML += `
                <tr>
                 <td>${data[i].visitId}</td>
                <td>${data[i].vet_id}</td>
                <td>${data[i].descripcion}</td>
                <td>${data[i].createAt}</td>
                <td>${data[i].type}</td>
                </tr>
                
                `
        }


    }
    xhr.open('GET', 'http://35.206.97.221:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/visit/list/' + username + '/' + type, true);
    xhr.send()

}