pipeline {
    agent any

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
