function sendDataOwner() {
    var http = new XMLHttpRequest()

    var email = document.getElementById("email").value
    var name = document.getElementById("name").value
    var passsword = document.getElementById("password").value
    var role = document.getElementById("role").value

    var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/' + name + '/' + passsword + "/" + email + '/' + role + '/sergio/address/la 80'


    http.open("POST", url, true)
    http.setRequestHeader("Content-Type", "application/json;charset=UTF-8")
    http.onreadystatechange = function () {

        if (http.readyState == 4 && http.status == 200) {
            alert(http.responseText)
        } else if (http.readyState == 4 && http.status == 201) {
            alert(http.responseText)
            window.location.href = "testCookie.html"
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

function sendDataOficial() {

    var http = new XMLHttpRequest()
    var name = document.getElementById("name").value
    var userName = document.getElementById("userName").value
    var email = document.getElementById("email").value
    var password = document.getElementById("pwrd").value
    var checkpassw = document.getElementById("chechpwrd").value
    var role = "oficial"


    if (password != checkpassw) {

        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    } else {
        var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial/" + userName + '/' + password + '/' + email + '/' + name

        http.open("POST", uri, true)
        http.onreadystatechange = function () {

            if (http.readyState == 4 && http.status == 201) {
                alert("Oficial created successfully")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "   -This inputs don´t shoudl null")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }
        }

        http.send()


    }


}


