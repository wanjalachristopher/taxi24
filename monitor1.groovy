job('Server Monitor') {
  
    triggers {
        cron('*/5 * * * *')
    }
     steps {
		 httpRequest('http://192.168.144.129:8181/vending-backend-dev/ping/backend?idVendor=0&codUser=jenkins'){
		 httpMode('GET')
		    
		 }
	     validResponseCodes(200,201)
	 
	}
  
}
