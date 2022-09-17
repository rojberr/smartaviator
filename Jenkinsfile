pipeline {
    agent {
        docker {
            image 'gradle:7.5.1-jdk17-alpine'
            args '-p 8080:8080'
        }
    }
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew test'
            }
        }
    }
}