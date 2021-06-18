console.log("paso")
var http = new XMLHttpRequest()
http.onreadystatechange = () => {
    if (http.readyState == 4) {
        var data = JSON.parse(http.responseText)
        console.log(data)
        var tbody = document.getElementById("res")


    }
}

http.open("GET", 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/list', true)
http.send()