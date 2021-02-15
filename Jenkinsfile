pipeline{
    agent any

    tools{
        maven 'maven'
    }

    stages{
        stage('maven clean'){
            steps{
                sh 'mvn clean'
            }
        }

        stage('maven compile'){
            steps{
                sh 'mvn compile'
            }
        }

        stage('maven test'){
            steps{
                sh 'mvn test'
            }
        }

        stage('maven package'){
            steps{
                sh 'mvn package'
            }
        }
    }
}
