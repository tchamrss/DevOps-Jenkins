
pipeline {
    agent any
    tools { maven 'maven-3.9' }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("increment version") {
                    steps {
                        script {
                            echo "incrementing the application version"
                            sh 'mvn build-helper:parse-version versions:set \
                                -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                                versions:commit'
                          def matcher = readFile('pom.xml') =~'<version>(.+)</version>'
                          def version = matcher[0][1]
                          env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                        }
                    }
        }

        stage("build app") {
            steps {
                script {
                    //echo "building the application"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    //echo "building the docker image"
                    gv.buildImage(env.IMAGE_NAME)
                }
            }
        }
        
        stage("commit version update") {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'github_token', passwordVariable: 'GITHUB_TOKEN', usernameVariable: 'GITHUB_USERNAME')]) {
                        sh '''
                            git config --global user.email "$GITHUB_USERNAME@example.com"
                            git config --global user.name "$GITHUB_USERNAME"

                            git status
                            git branch
                            git config --list

                            git remote set-url origin https://${GITHUB_USERNAME}:${GITHUB_TOKEN}@github.com/tchamrss/DevOps-Jenkins.git
                            git add .
                            git commit -m "Incremented version to ${IMAGE_NAME}"
                            git push origin HEAD:master
                        '''
                    }
                }
            }
        }
    }   
}

