job('Token Generator') {
  
    triggers {
        cron('*/5 * * * *')
    }
     steps {
		 httpRequest('http://192.168.144.128:8007/request.cgi'){
		 httpMode('POST')
		 }
	     
	 
	}
  
}