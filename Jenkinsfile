pipeline {
 agent none
 tools {
    	maven 'Maven'
 }
 stages {
  stage("Checkout"){
   agent any
   steps{
     checkout scm
     sh 'mvn clean test'
   }
   post {
       always {
          junit '**/target/surefire-reports/*.xml' 
       }
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
   }
  }
 }
}
