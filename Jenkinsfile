pipeline {
	agent {
		node {
			label 'master'
		}
	}
	
	options{
		timestamps()
	}
	
	
	stages{
		stage("Checkout, Test & Publish") {
			steps{
				snDevOpsStep()
				checkout scm
				sh 'mvn clean test'
				
				step([$class : 'Publisher', reportFilenamePattern : '**/testng-results.xml'])
				getCurrentBuildFailedTests("Checkout, Test & Publish")
				//sh 'curl -X POST -H "Content-Type: application/json" "${jsonObj}" http://devops.integration.user:devops@127.0.0.1:8082/api/sn_devops/v1/devops/orchestration/stepMapping?toolId=fd23e7t'
			}
		}
		
		stage("Email"){
			steps{
				emailext (to: 'mohansairam423@gmail.com', replyTo: 'mohansairam423@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("target/surefire-reports/emailable-report.html"), mimeType: 'text/html');
			}
		}
	}
	

}

def getCurrentBuildFailedTests(String stageName) {
 def jsonObj = [: ]
 jsonObj.put("stageName", stageName)
 def failedTests = []
 def build = currentBuild.build()

 def action = build.getActions(hudson.plugins.testng.TestNGTestResultBuildAction.class)
 if (action) {
  def failures = build.getAction(hudson.plugins.testng.TestNGTestResultBuildAction).getFailedTests()
  println "${failures.size()} Failed Test Results Found"
  def total = build.getAction(hudson.plugins.testng.TestNGTestResultBuildAction).getTotalCount()
  println "${total} Test Results Found"
  echo "executing"
  for (def failure in failures) {
   failedTests.add(['name': failure.name, 'url': failure.url, 'details': failure.errorDetails])
  }

  def result = build.getAction(hudson.plugins.testng.TestNGTestResultBuildAction).getResult();
  if (result) {
 
   def json = new groovy.json.JsonOutput.toJson([foo: 'bar', baz: [1]])
 
   new File("/tmp/output.json").write(json)
   jsonObj.put("name", result.getDisplayName())
   jsonObj.put("url", result.getUpUrl())
   jsonObj.put("totalTests", result.getTotalCount())
   jsonObj.put("passedTests", result.getPassCount())
   jsonObj.put("failedTests", result.getFailCount())
   jsonObj.put("skippedTests", result.getSkipCount())
   jsonObj.put("duration", result.getDuration())
   jsonObj.put("buildNumber", env.BUILD_NUMBER)
   jsonObj.put("pipelineName", env.JOB_NAME)
   def json = new groovy.json.JsonBuilder()
   json rootKey: jsonObj
   println groovy.json.JsonOutput.prettyPrint(json.toString())
	  def apiCall =  'curl -X POST -H "Content-Type: application/json" --data "@/tmp/output" http://devops.integration.user:devops@127.0.0.1:8082/api/sn_devops/v1/devops/orchestration/stepMapping?toolId=fd23e7t'.execute()
   //def client = new wslite.rest.RESTClient('http://devops.integration.user:devops@127.0.0.1:8082')
   //def response = client.post(path: 'api/sn_devops/v1/devops/orchestration/stepMapping?toolId=fd23e7t',
    //accept: 'application/json',
    //headers: ['Content-Type': 'application/json']) {
    //text new groovy.json.JsonBuilder(jsonObj).toString()
   //}

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

 return failedTests
}
