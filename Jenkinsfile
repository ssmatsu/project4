pipeline {
    agent any
    tools{
        maven 'Maven'
        jdk 'JDK 21'
    }

    stages {
        stage('Build') {
            steps {
                echo "Building project with maven"
                echo %PATH%
                bat 'mvn -B -DskipTests clean package'
            }
        }
         stage('Test') {
            steps {
                echo "Testing project with maven"
                bat 'mvn test'
            }
         }
    }
}