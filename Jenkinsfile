
pipeline {
    agent any


    
    stages {

        stage('test') {
            steps {
                echo 'testing the application'
                echo "executing pipeline for branch: ${env.GIT_BRANCH}"
                echo 'the application was tested successfully'
            }
        }

        stage('build') {
            
            steps {
                echo 'Building the application'
            }
        }

        stage('deploy') {
            when {
                expression {
                    env.GIT_BRANCH == 'origin/master'
                }
            }
            steps {
                echo 'deploying the application'
            }
        }
    }
}

