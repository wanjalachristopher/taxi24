job('Backend 1 Monitor') {
  
    triggers {
        cron('* */5 * * *')
    }
     steps {
	 httpRequest{
	 def get = new URL("https://httpbin.org/get").openConnection();
       
	 }
	 
	}
  
}