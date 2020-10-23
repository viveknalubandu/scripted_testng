pipeline {
 agent none
 tools {
    	maven 'Maven'
 }
 stages {
  stage("Checkout"){
   agent none
   steps{
     checkout scm
     sh 'mvn clean test'
   }
  }
  post {
       always {
          junit '**/target/surefire-reports/*.xml' 
       }
  } 
  stage("Tests") {
   agent any
   steps {
    checkout scm
    sh 'mvn clean test'
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
  stage('Deploy'){
   agent any
   steps{
     snDevOpsChange()
     //bzt "load_test1.yml"
     //junit '**/xunit.xml'
   }
  }
 }
}
