var clima = (function(){
	var clima;	
	return{
		setClima : function(tiempo){                    
                    clima = tiempo;
		},
                getClima : function(){
                    return clima;
                },
		resetAll : function(){
			clima = 0;
		}
	}
})();

async function inicio(){
    await getClima(document.getElementById("ciudad").value);
    setInfo();
    initialize(document.getElementById("ciudad").value);
}

function setInfo(){
    var m = "";
    m += "Las coordenadas son: latitud " + clima.getClima().coord.lat+" Longitud "+clima.getClima().coord.lon;
    m += " Clima: " + clima.getClima().weather[0].main + " description: " + clima.getClima().weather[0].description;
    m +=  " Temperatura: " + clima.getClima().main.temp + " Presion: " + clima.getClima().main.pressure + " Humedad: " + clima.getClima().main.humidity; 
    document.getElementById("cityinfo").innerHTML = m;
}

