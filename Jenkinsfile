pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout source code from version control
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build the application using Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests using Maven and JUnit
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                // Example: Deploy to Tomcat using Maven
                sh 'mvn tomcat7:redeploy'
            }
        }
    }

    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed. Trigger rollback or notify the team.'
        }
    }
}
