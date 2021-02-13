pipeline{
        agent any
        tools{
                maven 'maven-3'
        }
        stage('maven clean'){
            sh 'mvn clean'
        }
        stage('maven compile'){
            sh 'mvn compile'
        }
        stage('maven package'){
            sh 'mvn package'
        }
}
