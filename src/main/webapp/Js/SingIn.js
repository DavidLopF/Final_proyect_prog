function verificationLoginOficial() {
    var name = document.getElementById("userNameOficial").value
    var password = document.getElementById("passswordOficial").value
    var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial"
    var http = new XMLHttpRequest()

    http.open("GET", uri, true)
    http.setRequestHeader("Authorization", "Basic " + btoa(name + ":" + password))
    http.withCredentials = true
    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status != 200) {
            alert(http.responseText)
        }

    }
    http.send()
}

function verificationLoginVet() {
    var name = document.getElementById("userNameVet").value
    var password = document.getElementById("passVet").value
    var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet"
    var http = new XMLHttpRequest()

    http.open("GET", uri, true)
    http.setRequestHeader("Authorization", "Basic " + btoa(name + ":" + password))
    http.withCredentials = true
    http.onreadystatechange = function () {

        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status != 200) {
            alert(http.responseText)
        }

    }
    http.send()
}

function verificationLoginOwner() {
    var name = document.getElementById("userOwner").value
    var password = document.getElementById("passOwner").value
    var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners"
    var http = new XMLHttpRequest()

    http.open("GET", uri, true)
    http.setRequestHeader("Authorization", "Basic " + btoa(name + ":" + password))
    http.withCredentials = true
    http.onreadystatechange = function () {

        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status != 200) {
            alert(http.responseText)
        }

    }
    http.send()
}

