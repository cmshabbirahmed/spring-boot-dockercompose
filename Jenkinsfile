pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t spring-boot-dockercompose:latest .'
            }
        }

        stage('Docker Hub Push') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'cmshabbirahmed-dockerhub',
                        usernameVariable: 'DOCKERHUB_USERNAME',
                        passwordVariable: 'DOCKERHUB_PASSWORD'
                    )
                ]) {
                    bat '''
                        echo %DOCKERHUB_PASS% | docker login -u %DOCKERHUB_USER% --password-stdin

                        docker tag spring-boot-dockercompose:latest cmshabbirahmed/spring-boot-dockercompose:latest

                        docker tag spring-boot-dockercompose:latest cmshabbirahmed/spring-boot-dockercompose:%BUILD_NUMBER%

                        docker push cmshabbirahmed/spring-boot-dockercompose:latest

                        docker push cmshabbirahmed/spring-boot-dockercompose:%BUILD_NUMBER%

                        docker logout
                    '''
                }
            }
        }

        stage('Docker Compose') {
            steps {
                bat 'docker compose up -d'
            }
        }
    }

    post {
        success {
            echo 'CI/CD pipeline completed successfully'
        }

        failure {
            echo 'CI/CD pipeline failed'
        }
    }
}