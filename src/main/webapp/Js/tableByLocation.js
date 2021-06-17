function selectLocation(){
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var cont = ""
            var tbodyRef = document.getElementById("selectLocalidad")
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <option value="${data[i].neigboorhood}">${data[i].neigboorhood}</option>
                `
            }

        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/filter', true);
    xhr.send(null)

}
selectLocation()

function tableLocation(){
    var neight = document.getElementById("selectLocalidad").value
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("res")
            tbodyRef.innerHTML = ""
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].person_id}</td>
                <td>${data[i].name}</td>
                <td>${data[i].address}</td>
                <td>${data[i].neigboorhood}</td>
                </tr>`
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial/'+neight, true);
    xhr.send(null)
}

function tableCases(){
    var type = document.getElementById("table-container").value
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        var data = JSON.parse(xhr.responseText);
        var tbodyRef = document.getElementById("res")
        tbodyRef.innerHTML = ""
        for(vari=0;i<data.length;i++){
             tbodyRef.innerHTML += `
             <tr>
            <td>${data[i].pet_id}</td>
            <td>${data[i].type}</td>
            <td>${data[i].description}</td>
            <td>${data[i].created_id}</td>
              </tr>`

        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/cases/list/'+type, true);
    xhr.send(null)
}

function tablePets(){
    var type = document.getElementById("selectLocalidad").value
    var value = document.getElementById("selectType").value
    console.log("El tipo es "+type+ " el valor es "+value)
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            var data = JSON.parse(xhr.responseText);
            var tbodyRef = document.getElementById("res")
            tbodyRef.innerHTML = ""
            for (let i = 0; i < data.length; i++) {
                tbodyRef.innerHTML += `
                <tr>
                <td>${data[i].id}</td>
                <td>${data[i].specie}</td>
                <td>${data[i].race}</td>
                <td>${data[i].size}</td>
                <td>${data[i].sex}</td>
                <td>${data[i].microship}</td>
                <td>${data[i].microship}</td>
                </tr>`
            }
        }
    }
    xhr.open('GET', 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/'+type+'/'+value, true);
    xhr.send(null)

}










