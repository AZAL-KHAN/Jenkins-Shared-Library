# Jenkins Shared Library 

This repository contains **reusable Jenkins Shared Library steps** used to simplify and standardize CI/CD pipelines.

All shared functions are placed under:

**Jenkins-Shared-Library/vars/**

---

## 📁 Repository Structure
```
Jenkins-Shared-Library
├── README.md
└── vars
    ├── dockerLogin.groovy
    └── emailNotifications.groovy

2 directories, 3 files
```
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
## Custom Credentials ID

By default, `dockerLogin()` uses the Jenkins credentials ID named:

**dockerhub-creds**

If your Docker Hub credentials are stored with a different ID, pass it as an argument:


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

---

## 📌 Summary

This Jenkins Shared Library provides reusable steps for:
- Secure Docker Hub login (`dockerLogin`)
- Build failure and recovery email notifications (`emailNotifications`)

Designed to keep Jenkinsfiles clean and maintainable.
