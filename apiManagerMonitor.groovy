job('Api Manager Monitor') {
  
    triggers {
        cron('*/5 * * * *')
    }
     steps {
		 httpRequest('https://192.168.144.129:8243/venPing/1.0.1/?idVendor=0&codUser=jenkins'){
		 httpMode('GET')
		 }
	     
	 
	}
  
}
