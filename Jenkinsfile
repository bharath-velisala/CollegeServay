pipeline{
    agent any

    tools{
        maven 'M3'
    }

    stages{
        stage('maven clean'){
            steps{
                sh 'mvn clean'
            }
        }

        stage('maven Build'){
            steps{
                sh 'mvn Build'
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
