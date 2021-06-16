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
            console.log(data)
            var tbodyRef = document.getElementById("res")
            for (let i = 0; i < data.length; i++) {

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
                
                </tr>`

            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/'+finalUsername, true);
    xhr.send()

}





printTable();
