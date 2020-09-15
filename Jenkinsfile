pipeline {
 agent any
 tools {
    maven 'Maven'
 }
 stages {
  stage("Checkout"){
   agent none
   steps{
     snDevOpsStep()
     snDevOpsChange()
   }
  }
  stage("Tests") {
   agent any
   steps {
    snDevOpsStep()
    checkout scm
    sh 'mvn clean test'
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
 }
}
