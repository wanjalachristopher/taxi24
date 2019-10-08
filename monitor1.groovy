job('Backend 1 Monitor') {
  
    triggers {
        cron('* */5 * * *')
    }
     steps {
	 httpRequest('https://httpbin.org/get'){
	 httpMode('GET')
       
	 }
	 
	}
  
}