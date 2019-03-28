async function getClima(ciudad){
	await Promise.resolve(axios.get('https://arsw2talejandra.herokuapp.com/'+ciudad)
	.then(async function (response){            
            clima.setClima(response.data);
	}));
}

