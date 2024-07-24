pipeline {
    agent any
    tools{
        maven 'MAVEN_HOME'
        jdk 'JAVA_HOME'
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
