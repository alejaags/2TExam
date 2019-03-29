async function getClima(ciudad){
	await Promise.resolve(axios.get('https://arsw2talejandra.herokuapp.com/weather/'+ciudad)
	.then(async function (response){            
            clima.setClima(response.data);
	}));
}

