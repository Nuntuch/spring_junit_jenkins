pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven 'M3'
    }

    stages {
        stage('Check Out Code') {
            steps {
                git branch: 'master',
                credentialsId: 'githubPrivateKey2',
                url: 'https://github.com/Nuntuch/spring_junit_jenkins.git'
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        // stage('SonarQube analysis') {
        //     steps {
        //         withSonarQubeEnv('SonarQube') {
        //             sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=spring_junit_jenkins'
        //         }
        //     }
        // }
        // stage('Quality gate') {
        //     steps {
        //         waitForQualityGate abortPipeline: true
        //     }
        // }

        stage('Build') {
            steps {
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
                    recordCoverage(
                        tools: [[parser: 'JUNIT']],
                        sourceCodeRetention: 'EVERY_BUILD'
                    )

                // Assuming JaCoCo report is generated at target/site/jacoco
                // archiveArtifacts artifacts: 'target/site/jacoco/*.xml', allowEmptyArchive: true
                // archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true
                }
            }
        }
        stage('Code Coverage') {
            steps {
                // sh 'mvn test'
                sh 'mvn jacoco:report'
                // sh '**/target/site/jacoco/jacoco.xml'
                sh 'ls -al ./target/site/jacoco/'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                sh 'ls -al ./target/site/jacoco/'

                // Assuming JaCoCo report is generated at target/site/jacoco
                // archiveArtifacts artifacts: 'target/site/jacoco/*.xml', allowEmptyArchive: true
                // archiveArtifacts artifacts: 'target/surefire-reports/*.xml', allowEmptyArchive: true

                // publishCoverage adapters: [
    // jacocoAdapter('build/reports/jacoco/test/jacocoTestReport.xml')
// ], sourceFileResolver: sourceFiles('STORE_ALL_BUILD') adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
                // publishCoverage adapters: [jacocoAdapter('./target/site/jacoco/jacoco.xml')]

            //     publishCoverage adapters: [
            //     jacocoAdapter('build/reports/jacoco/test/jacocoTestReport.xml')]
            //     , sourceFileResolver: sourceFiles('STORE_ALL_BUILD')

            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
