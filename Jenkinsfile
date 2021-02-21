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
                    withMaven(maven:'maven'){
                        bat 'mvn sonar:sonar\
                        -Dsonar.projectKey=collegeServay \
                        -Dsonar.host.url=http://localhost:9000 \
                        -Dsonar.login=d075db72fdd0f01250743a33e3578453544fd495'
                    }
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