job('Backend 1 Monitor') {
  
    triggers {
        cron('* */1 * * *')
    }
     steps {
        script {
                    def response = httpRequest 'https://dog.ceo/api/breeds/list/all'
                    

                    println("Status: "+response.status)
					println("Content: "+response.content)
                }
    }
  
}