function sendDataOwner() {
    var http = new XMLHttpRequest()
    var name = document.getElementById("usernm").value
    var email = document.getElementById("email").value
    var address = document.getElementById("Adress").value
    var neighborhood = document.getElementById("neighborhood").value
    var username = document.getElementById("username").value
    var passsword = document.getElementById("password").value
    alert("El usuario es "+username+ " La clave es "+passsword)

    var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/' + username + '/' + name + "/" + email + '/' + address +'/'+neighborhood+'/'+passsword


    http.open("POST", url, true)
    http.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    http.onreadystatechange = function () {

        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status == 201) {
            alert(http.responseText)
           // window.location.href = "testCookie.html"
        } else if (http.readyState == 4 && http.status == 400) {
            alert('Error de peticion...')
        }
    }

    http.send(JSON.stringify({
        userName: name,
        email: email,
        passsword: passsword,
        role: role
    }))


}