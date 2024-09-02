pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'M3'
    }

    stages {
        stage('Build') {
            steps {
                git branch: 'master',
                credentialsId: '6fe3e5c5-52da-46be-b826-133979b64daa',
                url: 'https://github.com/Nuntuch/spring_junit_jenkins.git'

                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
