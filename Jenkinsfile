
pipeline {
    //agent { dockerfile true }
    agent any
    tools {
        maven "pi-Maven 3.6.3"
        jdk "pi-open-jdk-8"
    }
    environment {
        registry = 'sevgulnl/sphib-shopping'
        HOME = '.'
        JENKINS_USER='pi'
    }
    stages {
        stage('Initialize'){
            steps{
                //sh 'docker run --name myh2 -p 8082:8082 -d buildo/h2database -v /home/pi/h2-data:/h2-data'
                //sh '/home/pi/h2/bin/h2-server.sh'  
                //sh 'nohup java -cp /home/pi/h2/bin/h2-2.1.210.jar org.h2.tools.Server -web -webAllowOthers -tcp -tcpAllowOthers -baseDir /home/pi/h2-data'
               sh 'echo  "implement Initialize" '
               //sh 'docker container rm h2 --force'
               //sh 'docker build  -t h2-1.4.200 -f ./H2-Dockerfile . '
               //sh 'docker run -dp 9092:9092 -v /home/pi/h2-data:/h2-data --name h2 h2-1.4.200 '                           
               //sh 'docker container start h2'
            } 
        }
        stage('Build') {
            steps {
                sh 'mvn clean install -U --file=./backend/pom.xml'
                sh 'mvn clean install -U --file=./frontend/pom.xml'
               
            }
        }
        stage('Test') { 
            steps {
                //sh 'mvn test --file=./backend/pom.xml'
               sh 'echo  "implement Test" '
            }
        }
        stage('Publish') {
            environment {   registryCredential = 'dockerhub'  }
            steps {
                script {
                    //sh 'docker stop $(docker ps -aqf "name=sevgulnl/snl-vue") && docker container prune -f -v $(docker ps -aqf "name=sevgulnl/snl-vue")'
                    //sh 'docker image prune -f -v $(docker ps -aqf "name=sevgulnl/snl-vue")'

                    def appimage = docker.build registry + ":$BUILD_NUMBER"
                    docker.withRegistry( '', registryCredential ) {
                        appimage.push()
                        appimage.push('latest')
                    }
                 sh 'docker container rm sphib --force'
                 sh 'docker run -dp 8081:8080  -v /home/pi/h2-data:/h2-data --name sphib sevgulnl/sphib-shopping'
                 //sh 'docker container start shopping'
                }
            }
        }
    }
}