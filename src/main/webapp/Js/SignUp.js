function sendDataOwner() {
    var http = new XMLHttpRequest()
    var name = document.getElementById("usrnm").value
    var email = document.getElementById("Email").value
    var address = document.getElementById("Adress").value
    var neighborhood = document.getElementById("neighborhood").value
    var passsword = document.getElementById("pwrd").value
    var confirmPassword = document.getElementById("confirm").value
    var username =document.getElementById("username").value


    if(passsword != confirmPassword){
        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    }else{

        var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/' + username + '/' + name + "/" + email + '/' + address +'/'+neighborhood+'/'+passsword

        http.open("POST", url, true)
        http.onreadystatechange = function () {

            if (http.readyState == 4 && http.status == 201) {
                alert("Owner created successfully")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }else if(http.readyState == 4 && http.status != 404){
                alert("Not found html ")
            }
        }
        http.send()

    }
}
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
function uploadPicture(){
    var fileName = document.getElementById("file").files[0].name
    var microship = document.getElementById("microship").value
    var name = document.getElementById("name").value
    var specie = document.getElementById("specie").value
    var race = document.getElementById("race").value
    var size = document.getElementById("size").value
    var sex = document.getElementById("sex").value
    var userOwner = document.cookie.split(";")

    var finalUsername = leerCookie("userName")

    var form = new FormData(document.getElementById("file2"))
    var http = new XMLHttpRequest()
    var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/pictures/upload/'
        + microship + '/' + name + "/" + specie + '/' + race +'/'+size+'/'+sex
        +  '/' + fileName + '/' + finalUsername
    http.open("POST", uri, true)
    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 201) {
            alert("picture and pet created successfully")
            window.location("functionOwner.html")
        } else if (http.readyState == 4 && http.status == 406) {
            alert("you should check all input for this form: \n" +
                "    -This inputs don´t shoudl null.\n" +
                "    -If all inputs isn't stay null, this user name is already in use.")
        } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
            alert(http.responseText)
        }
    }
    http.send(form)
}


function createPet(){

    var fileName = document.getElementById("file").files[0].name
    var microship = document.getElementById("microship").value
    var name = document.getElementById("name").value
    var specie = document.getElementById("specie").value
    var race = document.getElementById("race").value
    var size = document.getElementById("size").value
    var sex = document.getElementById("sex").value
    var http = new XMLHttpRequest()



    var url = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/owners/pets/'
        + microship + '/' + name + "/" + specie + '/' + race +'/'+size+'/'+sex
        +  '/' + fileName + '/' + userOwner
    http.open("POST", url, true)
    http.onreadystatechange = function () {

        if (http.readyState == 4 && http.status == 201) {
            alert("Pet created successfully")
        } else if (http.readyState == 4 && http.status == 406) {
            alert("you should check all input for this form: \n" +
                "    -This inputs don´t shoudl null")
        } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
            alert(http.responseText)
        }
    }
    http.send()
    uploadPicture()


}



function sendDataOficial() {


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
        var http = new XMLHttpRequest()
        var uri = "http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/oficial/" + userName + '/' + password + '/' + email + '/' + name

        http.open("POST", uri, true)
        http.onreadystatechange = function () {

            if (http.readyState == 4 && http.status == 201) {
                alert("Oficial created successfully")
                window.location("index.html")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null.\n" +
                    "    -If all inputs isn't stay null, this user name is already in use.")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }
        }
        http.send()

    }
}

function sendDataVet() {
    var userName = document.getElementById("username").value
    var name = document.getElementById("name").value
    var email = document.getElementById("email").value
    var password = document.getElementById("pwrd").value
    var check = document.getElementById("confirm").value
    var adress = document.getElementById("adress").value
    var neighborhood = document.getElementById("neighborhood").value

    if (password == check) {
        var http = new XMLHttpRequest()
        var uri = 'http://localhost:8080/Final_proyect_prog-1.0-SNAPSHOT/api/userApp/vet/' + userName + '/' + password + "/" + email
            + '/' + name + '/' + adress + '/' + neighborhood

        http.open("POST", uri, true)
        http.onreadystatechange = function () {
            if (http.readyState == 4 && http.status == 201) {
                alert("Vet created successfully")
                window.location("index.html")
            } else if (http.readyState == 4 && http.status == 406) {
                alert("you should check all input for this form: \n" +
                    "    -This inputs don´t shoudl null.\n" +
                    "    -If all inputs isn't stay null, this user name is already in use.")
            } else if (http.readyState == 4 && http.status != 201 && http.status != 406) {
                alert(http.responseText)
            }
        }
        http.set
        http.send()
    } else {
        alert("You do have mistakes in inputs:" +
            "\n-password and confirm password, this inputs should same !!!!")
    }
}



