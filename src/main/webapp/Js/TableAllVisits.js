function init() {
    var h1 = document.getElementById("h1Vet")
    h1.innerHTML = `${"All visits of:" + leerCookie("userName")}`
    var http = new XMLHttpRequest()
    var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/list'
    http.open('GET', uri, true)
    http.onreadystatechange = () => {
        if (http.readyState == 4) {
            var data = JSON.parse(http.responseText);
            var select = document.getElementById("selecPets")
            for (let i = 0; i < data.length; i++) {
                select.innerHTML += `
            <option value="${data[i].id}">${data[i].name}</option>
            `
            }
        }
    }

    http.send()
}

init()

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

function writeTable() {
    var petId = document.getElementById('selecPets').value
    var firstDate = document.getElementById('fromperiod').value
    var secondDate = document.getElementById('toperiod').value
    console.log(petId)
    var http = new XMLHttpRequest()

    if (firstDate == "" && secondDate == "") {
        var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/visit/' + petId
        http.onreadystatechange = () => {
            if (http.readyState == 4) {
                var data = JSON.parse(http.responseText)
                var tbody = document.getElementById("res")
                tbody.innerHTML = ""
                for (let i = 0; i < data.length; i++) {
                    tbody.innerHTML += `
                     <tr>
                        <td>${data[i].visitId}</td>
                        <td>${data[i].createAt}</td>
                        <td>${data[i].type}</td>
                        <td>${data[i].descripcion}</td>
                        <td>${data[i].pet_id}</td>
                        <td>${data[i].vet_id}</td>
                     </tr>`
                }
            }
        }
        http.open('GET', url, true)
        http.send()
    } else {
        var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/visit/' + petId +'/' + firstDate + '/' + secondDate
        http.onreadystatechange = () => {
            if (http.readyState == 4) {
                var data = JSON.parse(http.responseText)

                var tbody = document.getElementById("res")
                tbody.innerHTML= ""
                for (let i = 0; i < data.length; i++) {
                    tbody.innerHTML+=`
                     <tr>
                        <td>${data[i].visitId}</td>
                        <td>${data[i].createAt}</td>
                        <td>${data[i].type}</td>
                        <td>${data[i].descripcion}</td>
                        <td>${data[i].pet_id}</td>
                        <td>${data[i].vet_id}</td>
                     </tr>`
                }
            }
        }
        http.open('GET', url, true)
        http.send()
    }
}