pipeline {

    agent any

    environment {
        SLACK_CHANNEL = 'builds'
        SLACK_URL = 'https://hooks.slack.com/services/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'
        JENKINS_ICON = 'https://wiki.jenkins-ci.org/download/attachments/2916393/logo.png'
    }


    stages {
    
        stage("Stop") {
            steps {
                sh "pwd"
                sh "ls"
                
                sh "docker-compose stop xmartech-chatbot || true"
                
                sh "docker rm -f xmartech-chatbot || true"
            }
        }

        stage("Build and deploy image") {

            steps {
                withMaven(
                        maven: 'M3',
                        mavenLocalRepo: '.repository') {

                    sh "pwd"
                    sh "ls"
                    
                    // Run the maven build
                    sh "mvn clean package -DskipTests"
                }
            }

        }

        stage("Start") {

            steps {
                sh "pwd"
                sh "ls"
                sh "docker-compose up -d --no-deps --build"
            }
            
            post {

                success {
                    sh "curl -X POST --data-urlencode 'payload={\"channel\": \"#builds\", \"username\": \"Jenkins\", \"text\": \"*Build Java Chatbot*\", \"attachments\": [{ \"fallback\": \"${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)\", \"pretext\": \"${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)\", \"color\":\"good\", \"fields\": [{ \"title\": \"Success\" }] }] ,\"icon_emoji\": \":grinning:\"}' ${env.SLACK_URL}"
                }

                failure {
                    sh "curl -X POST --data-urlencode 'payload={\"channel\": \"#builds\", \"username\": \"Jenkins\", \"text\": \"*Build Java Chatbot*\", \"attachments\": [{ \"fallback\": \"${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)\", \"pretext\": \"${env.JOB_NAME} #${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)\", \"color\":\"danger\", \"fields\": [{ \"title\": \"Failure\" }] }] ,\"icon_emoji\": \":skull:\"}' ${env.SLACK_URL}"
                }

            }

        }

  

    }


}