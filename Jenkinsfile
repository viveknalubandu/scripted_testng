pipeline {
 agent none
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
    
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
 }
}
