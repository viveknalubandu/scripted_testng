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
    //step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
  stage('Deploy'){
   agent any
   steps{
     snDevOpsChange()
     //bzt "load_test1.yml"
     junit '**/xunit.xml'
   }
  }
 }
}
