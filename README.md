# RouletteBetting

#Endpoints para realizar las pruebas 

#Create Roulette
GET http://localhost:8080/roulettebetting/roulette/addRoulette

#Roulette opening
PUT http://localhost:8080/roulettebetting/roulette/rouletteOpening/{id}

#Get All Roulettes 
GET http://localhost:8080/roulettebetting/roulette/getAllRoulettes

#Create bet
PUT http://localhost:8080/roulettebetting/bet/addBet 
	#Header example
	userId : 12345
	#Request example 
	{
		"idRoulette":"ybYqI7",
		"number":30
		"colour":"rojo",
		"amount":2000
	}

#Closed bet
PUT http://localhost:8080/roulettebetting/bet/closedBet/{idRoulette} 

#Create client
PUT http://localhost:8080/roulettebetting/client/createClient
	#Request example
	{
	"idClient":"12345",
	"totalAmount":50000
	}
