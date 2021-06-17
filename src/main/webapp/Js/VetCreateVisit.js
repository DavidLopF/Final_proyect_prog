var xhr = new XMLHttpRequest();
xhr.onreadystatechange = () => {
    if (xhr.readyState == 4) {
        var data = JSON.parse(xhr.responseText)
        var tbody = document.getElementById("res")
        var cont = ""
        for (let i = 0; i < data.length; i++) {
            var ruta = data[i].image.split('\\')
            var imagen = ruta[ruta.length - 2] + '/' + ruta[ruta.length - 1];
            cont += data[i].id + "/"
            imagen = imagen.split("/")
            imagen = imagen[imagen.length - 2] + "/" + imagen[imagen.length - 1]
            tbody.innerHTML += `
            <tr>
             <td>${data[i].id}</td>
             <td>${data[i].microship}</td>
             <td>${data[i].name}</td>
             <td>${data[i].specie}</td>
             <td>${data[i].race}</td>
             <td>${data[i].size}</td>
             <td>${data[i].sex}</td>
             <td><img src="${imagen}" width="60" height="60" style="border-radius: 2px"></td>
             <td>       <a class="cta" href="#" id="${data[i].id}"><button>Create Visit</button></a></td>
            </tr>
            `
        }
        cont = cont.substring(0, cont.length - 1)
        cont = cont.split("/")
        createListener(cont)

    }
}
xhr.open("GET", 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets', true)
xhr.send()

function createListener(id) {
    var boton = document.getElementsByClassName("cta")
    for (let i = 0; i < boton.length; i++) {
        boton[i].addEventListener("click", () => {
            header = document.getElementById("overlay")
            header.style.visibility = "visible"
            document.cookie = "pet_id=" + id[i];

        })
    }
    var cerrar = document.getElementById("cerrar")
    cerrar.addEventListener("click", () => {
        header = document.getElementById("overlay")
        header.style.visibility = "hidden"
    })

}

function sendDataVisit() {
    var micro = document.getElementById("microchi").value
    var create_at = document.getElementById("createAT").value
    var description = document.getElementById("description").value
    var type = document.getElementById("visit").value
    var pet_id = leerCookie('pet_id')
    var vet_id = leerCookie('userName')
    var http = new XMLHttpRequest()


    if (micro != "") {
        if (micro != "" && create_at != "" && description != "") {
            var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/visit/' + pet_id + '/' + vet_id + '/'
                + type + '/' + create_at + '/' + description + '/' + micro
            http.open("POST", uri, true)
            http.onreadystatechange = () => {
                if (http.readyState == 4 && http.status == 201) {
                    alert("Visit created successfully")
                    window.location.reload()
                } else if (http.readyState == 4 && http.status != 201) {
                    alert(http.responseText)
                }
            }
            http.send()
        } else {
            alert("this form have null inputs !!")
        }
    } else {
        if (create_at != "" && description != "") {
            var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/visit/' + pet_id + '/' + vet_id + '/'
                + type + '/' + create_at + '/' + description
            http.open("POST", uri, true)
            http.onreadystatechange = () => {
                if (http.readyState == 4 && http.status == 201) {
                    alert("Visit created successfully")
                    window.location.reload()
                } else if (http.readyState == 4 && http.status != 201) {
                    alert("this pet is already sterilized")
                }
            }

            http.send()
        } else {
            alert("this form have null inputs !!")
        }


    }
}

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






