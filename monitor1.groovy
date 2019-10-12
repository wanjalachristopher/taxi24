job('Backend 1 Monitor') {
  
    triggers {
        cron('* */5 * * *')
    }
     steps {
	def res = httpRequest('https://httpbin.org/get'){
	 httpMode('GET')
       
	 }
	 if(res.status == 200){}
	  println('Status: '+res.status)
	  println('Response: '+res.content)
	}
  
}