pipeline {
    agent any
    tools{
        maven 'Maven'
        jdk 'jdk-21'
    }

    stages {
        stage('Build') {
            steps {
                echo "Building project with maven"
                sh 'mvn -B -DskipTests clean package'
            }
        }
         stage('Test') {
            steps {
                echo "Testing project with maven"
                sh 'mvn test'
            }
         }
    }
}