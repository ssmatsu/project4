pipeline {
    agent any
    tools{
        maven 'Maven'
        jdk 'Java'
    }

    stages {
        stage('Build') {
            steps {
                echo "Building project with maven"
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}