pipeline {
 agent any
 stages {
  stage("Checkout, Test & Publish") {
   steps {
    snDevOpsStep()
    checkout scm
    sh 'mvn clean test'
    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
   }
  }
 }
}
