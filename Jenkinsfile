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
                        bat 'mvn sonar:sonar'
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

        stage('collect artifact'){
     steps{
     archiveArtifacts artifacts: 'target/*.jar', followSymlinks: false
     }
     }
     stage('deploy to artifactory')
     {
     steps{
     
     rtUpload (
    serverId: 'Jfrog',
    spec: '''{
          "files": [
            {
              "pattern": "target/*.jar",
              "target": "art-doc-dev-loc"
            }
         ]
    }''',
    buildName: 'holyFrog',
    buildNumber: '1'
)
     }}

     stage('email notification'){
         steps{
             mail bcc: '',
          body: 'pipeline code executed successfully with out any build faliures',
           cc: '',
            from: '',
             replyTo: '', 
             subject: 'pipeline executed successfully', 
             to: 'bharath.velisala@gmail.com'
         }
     }
    }
}