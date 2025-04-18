function verEntradas() {
    const historicoEntradas = document.getElementById("historicoEntradas");
    historicoEntradas.style.display = "block";
    
    const historicoSalidas = document.getElementById("historicoSalidas");
    historicoSalidas.style.display = "none";
}

function verSalidas() {
    const historicoEntradas = document.getElementById("historicoEntradas");
    historicoEntradas.style.display = "none";
    
    const historicoSalidas = document.getElementById("historicoSalidas");
    historicoSalidas.style.display = "block";
}