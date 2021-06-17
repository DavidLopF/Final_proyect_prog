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
            var data = http.responseText.split(":")
            document.cookie = "role=" + data[0]
            document.cookie = "userName=" + data[1]

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
            var data = http.responseText.split(":")
            document.cookie = "role=" + data[0]
            document.cookie = "userName=" + data[1]
            window.location.href = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/funtionVet.html"

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
            var data = http.responseText.split(":")
            document.cookie = "role=" + data[0]
            document.cookie = "userName=" + data[1]
            window.location.href = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/funtionOwner.html"
        } else if (http.readyState == 4 && http.status != 200) {
            alert(http.responseText)
        }

    }
    http.send()
}

function testCookie() {
    var cookies = document.cookie.split(";")
    var userName = cookies[1].split("=")[1]
    var role = cookies[0].split("=")

    var http = new XMLHttpRequest()
    var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial/" + userName
    http.open("GET", uri, true)
    http.onreadystatechange = function () {
        if (http.readyState == 4) {
            alert(http.responseText)
        }
    }
    http.send()

}

