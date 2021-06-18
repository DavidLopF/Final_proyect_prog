console.log("paso")
var http = new XMLHttpRequest()
http.onreadystatechange = () => {
    if (http.readyState == 4) {
        var data = JSON.parse(http.responseText)
        console.log(data)
        var tbody = document.getElementById("res")
        for (let i = 0; i < data.length; i++) {
            tbody.innerHTML += `
        <tr>
            <td>${data[i].specie}</td>
            <td>${data[i].race}</td>
            <td>${data[i].size}</td>
            <td>${data[i].sex}</td>
            <td>${data[i].microship}</td>
            <td>${data[i].sterelized}</td>
        </tr>`
        }
    }
}

http.open("GET", 'http://35.206.97.221:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/list', true)
http.send()