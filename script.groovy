def buildJar() {
    echo "building the application..."
    sh 'mvn clean package'
} 

def buildImage(String IMAGE_NAME) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {

        sh "docker build -t tchamrss/demo-app:${IMAGE_NAME} ."
        sh '''
            echo "$DOCKER_HUB_PASSWORD" |
            docker login -u "$DOCKER_HUB_USERNAME" --password-stdin
        '''
        sh "docker push tchamrss/demo-app:${IMAGE_NAME}"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
