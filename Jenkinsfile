pipeline {
    agent {
            docker { image 'maven:3.9.9-openjdk-17' }
        }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ms01ms/java.git'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn -Dtest=UITests.AddCarToGarageTest test'
            }
        }
    }
}
