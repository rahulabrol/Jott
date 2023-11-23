# Jott
This is a TODO android application.

# Build Commands

# Owsap - helps you protect your systems, your data and your users
    ./gradlew dependencyCheckAnalyze --info

# Spotless - allows us to format (and check rules) code in multiple languages
    ./gradlew -q spotlessApply
    ./gradlew -q spotlessCheck

# Cloc - counts blank lines, comment lines, and physical lines of source code
    cloc/run-cloc

# Unit test - all the unit tests in all the modules will run
    ./gradlew testRelease

# Release - This creates a release build of your app.
    ./gradlew -q clean assembleRelease 
