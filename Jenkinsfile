pipeline {
 agent any
 stages {
  stage("Checkout"){
   agent any
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
