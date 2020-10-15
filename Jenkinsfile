pipeline {
 agent none
 tools {
    	maven 'Maven'
 }
 stages {
  stage("Checkout"){
   agent none
   steps{
     snDevOpsChange()
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
  stage('Load'){
   agent any
   steps{
     //bzt "load_test1.yml"
     //junit '**/xunit.xml'
   }
  }
  stage('Deploy-Change'){
   agent any
   steps{
     snDevOpsChange()
     //bzt "load_test1.yml"
     //junit '**/xunit.xml'
   }
  }
  
 }
}
