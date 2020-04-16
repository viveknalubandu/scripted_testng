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
				getCurrentBuildFailedTests()
			}
		}
		
		stage("Email"){
			steps{
				emailext (to: 'mohansairam423@gmail.com', replyTo: 'mohansairam423@gmail.com', subject: "Email Report from - '${env.JOB_NAME}' ", body: readFile("target/surefire-reports/emailable-report.html"), mimeType: 'text/html');
			}
		}
	}
	

}

def getCurrentBuildFailedTests() {
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
						    	def testList = result.getTestList();
							    for (def test in testList) {
							    	var classList = test.getClassList();
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
