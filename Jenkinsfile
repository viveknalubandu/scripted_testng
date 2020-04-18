pipeline {
 agent any
 stages {
  stage("Checkout, Test & Publish") {
   steps {
    snDevOpsStep()
    checkout scm
    sh 'mvn clean test'

    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
    getCurrentBuildFailedTests("Checkout, Test & Publish")
   }
  }
 }
}



def getCurrentBuildFailedTests(String stageName) {
 def jsonObj = [: ]
 jsonObj.put("stageName", stageName)
 def build = currentBuild.build()
 def action = build.getActions(hudson.plugins.testng.TestNGTestResultBuildAction.class)
 if (action) {
  def result = build.getAction(hudson.plugins.testng.TestNGTestResultBuildAction).getResult();
  if (result) {
   jsonObj.put("name", result.getDisplayName())
   jsonObj.put("url", result.getUpUrl())
   jsonObj.put("totalTests", result.getTotalCount())
   jsonObj.put("passedTests", result.getPassCount())
   jsonObj.put("failedTests", result.getFailCount())
   jsonObj.put("skippedTests", result.getSkipCount())
   jsonObj.put("duration", result.getDuration())
   jsonObj.put("buildNumber", env.BUILD_NUMBER)
   jsonObj.put("pipelineName", env.JOB_NAME)
   def json = new groovy.json.JsonBuilder(jsonObj)
   def response = ["curl", "-k", "-X", "POST", "-H", "Content-Type: application/json", "-d", "${json}", "http://devops.integration.user:devops@127.0.0.1:8082/api/sn_devops/v1/devops/orchestration/stepMapping?toolId=fd23e7t"].execute()
   response.waitFor()
   println response.err.text
   println response.text


   def testName = result.getDisplayName()
   def testUrl = result.getUpUrl()
   def totalExecuted = result.getTotalCount()
   def totalPassed = result.getPassCount()
   def totalFailed = result.getFailCount()
   def totalSkipped = result.getSkipCount()
   def duration = result.getDuration()
   println "Url : ${testName} : ${testUrl} : ${totalExecuted} : ${totalPassed} : ${totalFailed} : ${totalSkipped} : ${duration} : ${env.BUILD_NUMBER}: ${env.JOB_NAME}"
   def testList = result.getTestList();
   for (def test in testList) {
    println "TestList"
    def classList = test.getClassList();
    println "ClassList"
    for (def obj in classList) {
     def name = obj.getCanonicalName()
     println "Class Name : ${name}"
     def pass = obj.getPassCount()
     println "Pass : ${pass}"
     def fail = obj.getFailCount()
     println "Fail : ${fail}"
     def totalClass = obj.getTotalCount()
     println "Total : ${totalClass}"
   }
  }
 }
}
}
