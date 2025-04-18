function login() {
    const username = document.getElementById("txtUsername").value;
    const password = document.getElementById("txtPassword").value;
    
    fetch("/login",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username,
                password
            })
        }
    )
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            const { rol, idUsuario, nombre } = data
            window.sessionStorage.setItem("rol", rol);
            window.sessionStorage.setItem("idUsuario", idUsuario);
            window.sessionStorage.setItem("nombre", nombre);
            
            window.location.href = "/";
        })
        .catch((error) => {
            console.log(error);
        });
}

