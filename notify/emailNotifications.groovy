def call(String recipientEmail) {

  return {
    failure {
      emailext(
        subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: """

The Jenkins build has FAILED.

Job Name : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}

Check logs:
${env.BUILD_URL}

""",
        to: recipientEmail
      )
    }

    fixed {
      emailext(
        subject: "✅ Jenkins Build Fixed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: """

The Jenkins build is BACK TO NORMAL.

Job Name : ${env.JOB_NAME}
Build No : ${env.BUILD_NUMBER}

View build:
${env.BUILD_URL}

""",
        to: recipientEmail
      )
    }
  }
}
