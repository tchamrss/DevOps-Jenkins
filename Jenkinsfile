 
pipeline {
    agent any
    
    stages {
        stage('test') {
            steps{
                echo 'testing the application'
                echo "executing pipeline for branch: ${env.GIT_BRANCH}"
                
            }
        }
        stage('build') { // for display purposes
            when {
                expression { 
                    env.GIT_BRANCH == 'origin/master'
                 }
            }
            steps{
                echo 'Building the application'
            }
        }
        
        stage('deploy') {
            
            steps{
                echo 'deploying the application'
            }
        }
    }
}
