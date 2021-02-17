pipeline {
    agent any
    tools{
        maven 'maven'
        jdk 'java15'
    }
    stages {
        stage('SCM') {
            steps {
                git url: 'https://github.com/bharath-velisala/CollegeServay.git'
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('sonarcube') {
                    // Optionally use a Maven environment you've configured already
                    withMaven(maven:'maven') {
                        bat 'mvn clean package sonar:sonar'
                    }
                }
            }
        }
    }
}