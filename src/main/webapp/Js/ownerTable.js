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

function printTable() {
    var finalUsername = leerCookie("userName")
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            console.log(data)
            var tbodyRef = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {

                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].id}</td>
                <td>${data[i].microship}</td>
                <td>${data[i].name}</td>
                <td>${data[i].specie}</td>
                <td>${data[i].race}</td>
                <td>${data[i].size}</td>
                <td>${data[i].sex}</td>
                <td>
                  <a class= "cta" href="#" id=""><button>Create Visit</button></a>
                </td>
                <td>
                <a class= "cta1" href="#" id=""><button>Case</button></a>
                </td>
                
                </tr>`
            }
            createListener()
            var cerrar = document.getElementById("cerrar")
            cerrar.addEventListener("click", () => {
                console.log("paso")
                header = document.getElementById("overlay")
                header.style.visibility = "hidden"
            })

            var cerrar2 = document.getElementById("btn-cerrar-popupVet")
            cerrar2.addEventListener("click", () => {
                console.log("paso")
                header = document.getElementById("overlayVet")
                header.style.visibility = "hidden"
            })

        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/' + finalUsername, true);
    xhr.send()

}

function createListener() {
    var boton = document.getElementsByClassName("cta")
    for (let i = 0; i < boton.length; i++) {
        boton[i].addEventListener("click", () => {
            header = document.getElementById("overlay")
            header.style.visibility = "visible"
        })
    }

    var boton2 = document.getElementsByClassName("cta1")
    for (let i = 0; i < boton2.length; i++) {
        boton2[i].addEventListener("click", () => {
            console.log("paso")
            form =document.getElementById("overlayVet")
            form.style.visibility = "visible"
        })
    }
}


printTable();
