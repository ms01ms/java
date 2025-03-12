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
                sh 'mvn test -Dselenide.remote=http://selenoid:4444/wd/hub'
            }
        }
    }
}
