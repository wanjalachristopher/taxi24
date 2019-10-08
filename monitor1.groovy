job('Backend 1 Monitor') {
  
    triggers {
        cron('* */1 * * *')
    }
     steps {
        println('so far so good...')
	}
  
}