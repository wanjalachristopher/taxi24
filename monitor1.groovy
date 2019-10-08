job('Backend 1 Monitor') {
   agent any
    triggers {
        cron('* */1 * * *')
    }
    
    stages {
        stage('Build') { 
            steps {
                script {
                    def response = httpRequest 'https://dog.ceo/api/breeds/list/all'
                    

                    echo "Status: ${response.status}"
                }
            }
        }
    }
}