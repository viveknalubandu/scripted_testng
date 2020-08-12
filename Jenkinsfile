pipeline {
 agent any
 stages {
  stage("Checkout"){
   steps{
     snDevOpsStep()
     snDevOpsChange()
     checkout scm
   }
  }
  stage("Tests") {
   steps {
    snDevOpsStep()
    sh 'mvn clean test'
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
 }
}
