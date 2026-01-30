# Docker Login – Jenkins Shared Library

Reusable Jenkins Shared Library step to securely log in to Docker Hub using Jenkins credentials.

Usage

Import the shared library in your Jenkinsfile:

```
@Library('jenkins-shared-library') _
```

Use the Docker login step inside a stage:

```
stage('DockerHub Login') {
  steps {
    dockerLogin()
  }
}
```

Custom credentials ID

If your Docker Hub credentials are saved with a different ID, pass it as an argument:

```
dockerLogin('my-dockerhub-creds')
```