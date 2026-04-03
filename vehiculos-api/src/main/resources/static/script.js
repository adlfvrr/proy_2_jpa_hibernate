// Esto es un comentario. JavaScript se ejecuta en el navegador.

// 1. PRIMERO: Entendamos cómo funciona fetch (llamar a la API)

// Cuando la página termine de cargar, hacemos esto:
document.addEventListener('DOMContentLoaded', function() {
    console.log('La página está lista');
    
    // Llamamos a la función que trae los vehículos
    traerVehiculos();
});

// 2. Función para traer vehículos desde tu API
function traerVehiculos() {
    console.log('Voy a pedir los vehículos a la API...');
    
    // fetch es como hacer una petición GET (como en ThunderClient)
    fetch('http://localhost:8080/api/vehiculos')
        .then(function(respuesta) {
            console.log('Respuesta recibida:', respuesta);
            return respuesta.json(); // Convertir a JSON
        })
        .then(function(datos) {
            console.log('Datos recibidos:', datos);
            // Acá vamos a mostrar los datos en el HTML
            mostrarVehiculos(datos);
        })
        .catch(function(error) {
            console.error('Error al traer vehículos:', error);
        });
}

// 3. Función para mostrar los vehículos en el HTML
function mostrarVehiculos(vehiculos) {
    console.log('Mostrando', vehiculos.length, 'vehículos');
    
    const contenedor = document.getElementById('contenedor-vehiculos');
    
    // Limpiamos el contenido actual
    contenedor.innerHTML = '';
    
    // Recorremos todos los vehículos
    for(let i = 0; i < vehiculos.length; i++) {
        const v = vehiculos[i];
		
		let tipo = '';
		let detalle = '';
        
        // Creamos un elemento de párrafo
        const parrafo = document.createElement('p');
        
        // Le ponemos texto: "Tipo Marca - Precio - Año - cc/cantpuertas"
		
		if(v.cant_puertas != undefined){
			tipo = 'AUTO';
			 detalle = 'Puertas: ' + v.cant_puertas;
		 }
		 
		else if(v.cilindrada != undefined){
			tipo = 'MOTO';
			 detalle = 'CC: ' + v.cilindrada;
		 }
		 
		parrafo.textContent = tipo + ' ' + v.marca + ' - $' + v.precio + ' - ' + v.anio + ' - ' + detalle;
        
        // Lo agregamos al contenedor
        contenedor.appendChild(parrafo);
		
    }
}