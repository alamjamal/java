function pinSearch(){
	// store user input
	var pin =  document.getElementById('pin').value
	// clear any previous data
	// make a data request
	$.ajax({
		// url for database 
	    url: "https://www.whizapi.com/api/v2/util/ui/in/indian-city-by-postal-code?project-app-key=ceqbtke2czk5biepxxinhadd&pin="+pin,
	    dataType: "json",
	    type: 'GET',
	    // on success, do this
	    success: function(data) {
	    	console.log(data)	
		    // loop through data in data.items
		    for(var i = 0; i <1; i++){
		   		// store current DATA info 
		   		var jdata = data.Data[i]
				
				//store data to var
			
				var address = jdata.Address
				var city = jdata.City
				var state = jdata.State
				var country = jdata.Country
		   		
				//print data to text boxes
				
				document.getElementById('address').value=address
				document.getElementById('city').value=city
				document.getElementById('state').value=state
				document.getElementById('country').value=country

		    }
	    }
	})
}

document.getElementById('pin').addEventListener('blur', pinSearch, true)
document.getElementById('pin').addEventListener('focus', pinSearch, true)
document.getElementById('pin').addEventListener('keyup', pinSearch, true)
