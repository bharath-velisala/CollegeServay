pipeline{
    agent any

    tools{
        maven 'maven-3'
    }

    stages{
        stage('maven clean'){
            steps{
                bat 'mvn clean'
            }
        }

        stage('maven compile'){
            steps{
                bat 'mvn compile'
            }
        }

        stage('maven test'){
            steps{
                bat 'mvn test'
            }
        }

        stage('maven package'){
            steps{
                bat 'mvn package'
            }
        }
    }
}
