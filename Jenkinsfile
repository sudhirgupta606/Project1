pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Define build steps here (e.g., compile code)
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Define test steps here (e.g., run unit tests)
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Define deployment steps here (e.g., deploy to production)
                sh 'mvn deploy'
            }
        }
    }
}
