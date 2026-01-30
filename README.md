# Jenkins Shared Library 

This repository contains **reusable Jenkins Shared Library steps** used to simplify and standardize CI/CD pipelines.

All shared functions are placed under:

**Jenkins-Shared-Library/vars/**

---

## 🔐 dockerLogin.groovy

**Path:**
**Jenkins-Shared-Library/vars/dockerLogin.groovy**


Reusable step to securely log in to **Docker Hub** using Jenkins credentials  
(no hard-coded usernames or passwords).

## Usage

Import the shared library in your Jenkinsfile:

```groovy
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

If your Docker Hub credentials use a different ID:

```
dockerLogin('my-dockerhub-creds')
```

---

## 📧 emailNotifications.groovy

Path:
**Jenkins-Shared-Library/vars/emailNotifications.groovy**

Automatically sends email notifications when:

- Jenkins build fails

- Failed build is fixed (back to success)

## Usage
```
post {
  always {
    emailNotifications('your-email@gmail.com')
  }
}
```