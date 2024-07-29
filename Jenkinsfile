pipeline {
    agent{
    	docker {image 'node:20.16.0-alpine3.20'
    	}
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