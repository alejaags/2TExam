async function getClima(ciudad){
	await Promise.resolve(axios.get('https://gomezsanchezarswt2.herokuapp.com/weather/'+ciudad)
	.then(async function (response){            
            clima.setClima(response.data);
	}));
}

