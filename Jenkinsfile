 
pipeline {
    agent any
    
    stages {
        stage('test') {
            steps{
                echo 'testing the application'
                echo "executing pipeline for branch: $BRANCH_NAME"
                
            }
        }
        stage('build') { // for display purposes
            when {
                expression { 
                    BRANCH_NAME == 'master'
                 }
            }
            steps{
                echo 'Building the application'
            }
        }
        
        stage('deploy') {
            when {
                expression { 
                    BRANCH_NAME == 'master'
                 }
            }
            steps{
                echo 'deploying the application'
            }
        }
    }
}
