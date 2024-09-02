pipeline {
    agent any
    // agent {
    // docker { image 'maven:3.8.1-adoptopenjdk-17' }
    // }
    
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }
    
    environment {
        MAVEN_HOME = tool('M3')
    }

  stages {
    stage("Build") {
      steps {
        // git url: 'git@github.com:Nuntuch/spring_junit_jenkins.git'
        git branch: 'master',
                credentialsId: '6fe3e5c5-52da-46be-b826-133979b64daa',
                url: 'https://github.com/Nuntuch/spring_junit_jenkins.git'
                // url: 'git@github.com:Nuntuch/spring_junit_jenkins.git'
        // withMaven(
        //     // Maven installation declared in the Jenkins "Global Tool Configuration"
        //     maven: 'maven-3', // (1)
        //     // Use `$WORKSPACE/.repository` for local repository folder to avoid shared repositories
        //     mavenLocalRepo: '.repository', // (2)
        //     // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
        //     // We recommend to define Maven settings.xml globally at the folder level using
        //     // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
        //     // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
        //     mavenSettingsConfig: 'my-maven-settings' // (3)
        // ) 
        // {
          // Run the maven build


          sh 'mvn -B -DskipTests clean package'
          sh "mvn clean install"
          sh "mvn verify"
        // } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe & FindBugs & SpotBugs reports...
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



