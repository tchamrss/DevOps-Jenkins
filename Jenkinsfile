@Library('jenkins-shared-library')
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
                 buildImage 'tchamrss/demo-app:jma-3.0'
                 dockerLogin()
                 dockerPush() 'tchamrss/demo-app:jma-3.0'
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
