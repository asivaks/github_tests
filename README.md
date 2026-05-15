# github_tests

Small Java UI test project for practicing Selenide, JUnit 5, and Allure reports.

The tests live under `src/test/java/github` and automate public pages such as GitHub and the-internet.herokuapp.com. Because they depend on live external websites, selectors and expected content may need updates when those sites change.

## Run

```bash
gradle test
```
