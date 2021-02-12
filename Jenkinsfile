pipeline{
    stages{
        stage('cloning the code'){
            git https://github.com/bharath-velisala/CollegeServay.git
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
}
