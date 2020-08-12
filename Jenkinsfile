pipeline {
 agent none
 stages {
  stage("Checkout"){
   agent none
   steps{
     snDevOpsStep()
     snDevOpsChange()
     checkout scm
   }
  }
  stage("Tests") {
   agent any
   steps {
    snDevOpsStep()
    sh 'mvn clean test'
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
 }
}
