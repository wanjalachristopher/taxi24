job('Backend 1 Monitor') {
  
    triggers {
        cron('* */5 * * *')
    }
     steps {
	 def get = new URL("https://httpbin.org/get").openConnection();
        println('so far so good...')
	}
  
}