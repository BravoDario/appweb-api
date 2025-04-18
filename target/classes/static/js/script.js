const role = window.sessionStorage.getItem("rol");

if (!role) {
    window.location.href = "/login";
}

function guardarNuevoProducto() {
    const nombre = document.getElementById("txtNuevoProducto").value;
    const precio = document.getElementById("txtNuevoPrecio").value;

    const nuevoProducto = {
        nombre,
        precio,
    };

    fetch("/agregarProducto", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(nuevoProducto),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            window.location.reload();
        })
        .catch((error) => {
            console.log(error);
        });
}

function agregarInventario() {
    const body = {
        idProducto: document.getElementById("txtIdProducto").value,
        idUsuario: window.sessionStorage.getItem("idUsuario"),
        cantidad: document.getElementById("cantidad").value,
    };

    fetch("/registrarInventario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
    })
        .then((response) => response.json())
        .then((data) => {
            console.log(data);
            //fetch(`/productoDetalle?idProducto=${body.idProducto}&np=${data.producto.nombre}`);
            window.location.reload();
        })
        .catch((error) => {
            console.log(error);
        });
}

function eliminarInventario(idInventario) {
    const cantidadOrigen = document.getElementById(
        `cantidadOrigen-${idInventario}`
    ).value;
    const cantidadDescontar = document.getElementById(
        `cantidadDescontar-${idInventario}`
    ).value;
    const idUsuario = window.sessionStorage.getItem("idUsuario");

    if (cantidadDescontar > cantidadOrigen || cantidadDescontar < 1) {
        alert("No puede eliminar esa cantidad");
        return;
    }

    const body = {
        idInventario,
        idUsuario,
        cantidad: cantidadDescontar,
    };

    fetch("/eliminarInventario", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(body),
    })
        .then((response) => response.json())
        .then((data) => {
            window.location.reload();
            console.log(data);
        })
        .catch((error) => {
            console.log(error);
        });
}

function activarProducto(idProducto) {
    fetch("/activarProducto", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            idProducto,
        }),
    })
        .then((response) => response.json())
        .then((data) => {
            window.location.reload();
        })
        .catch((error) => {
            console.log(error);
        });
}

function desactivarProducto(idProducto) {
    fetch("/desactivarProducto", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            idProducto,
        }),
    })
        .then((response) => response.json())
        .then((data) => {
            window.location.reload();
        })
        .catch((error) => {
            console.log(error);
        });
}

function mostrarFormularioNuevoProducto() {
    const divNuevoProducto = document.getElementById("divNuevoProducto");
    divNuevoProducto.style.display = divNuevoProducto.style.display === "block" ? "none" : "block";
}