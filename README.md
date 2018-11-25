# spring-boot-devtools-issue

1. Run `gradlew`
2. Open `localhost:8080` in a web browser to reproduce the problem.
3. Terminate the program and comment out `spring-boot-devtools` dependency in build.gradle file
3. Run `gradlew` again and open `localhost:8080` that returns OK.
