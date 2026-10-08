library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
    [
        $class:'GitSCMSource',
        remote:'https://github.com/tchamrss/DevOps-Jenkins.git',
        credentialsId: 'git-credentials'
    ]

def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.9'
    }
    stages {

        stage('init') {
            steps{
                script{
                 gv = load "script.groovy"
                }
                
            }
        }
        
        stage('build jar') { // for display purposes
            
            steps{
                script{
                    buildJar()
       
                }
            }
        }
        
        stage('build and push image') {
            
            steps{
                script{
                 buildImage 'tchamrss/demo-app:jma-4.0'
                 dockerLogin()
                 dockerPush 'tchamrss/demo-app:jma-4.0'
                }
            }
        }
        stage('deploy') { // for display purposes
            
            steps{
                script{
                    gv.deployApp()
       
                }
            }
        }
    }
}
