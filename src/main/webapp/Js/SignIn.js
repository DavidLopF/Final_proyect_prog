function sendDataOwner() {
    var http = new XMLHttpRequest()

    var email = document.getElementById("email").value
    var name = document.getElementById("name").value
    var passsword = document.getElementById("password").value
    var role = document.getElementById("role").value

    var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/' + name + '/' + passsword + "'/" + email + '/' + role +'/sergio/address/la 80'


    http.open("POST", url, true)
    http.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status == 201) {
            alert(http.responseText)
            window.location.href = "testCookie.html"
        } else if (http.readyState == 4 && http.status == 400) {
            console.log('paso')
            alert(http.responseText)
        }
    }

    http.send(JSON.stringify({
        userName: name,
        email: email,
        passsword: passsword,
        role: role
    }))


}

