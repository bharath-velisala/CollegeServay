pipeline{
    agent any

    tools{
        maven 'maven'
        jdk 'java15'
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

        stage('sonar analysis'){
            steps{
            withSonarQubeEnv('sonarcube'){
                bat 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar'
            }
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
