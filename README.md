# bot4j

## Introduction

bot4j: a robust designed for sending notifications to various messaging platforms such as Telegram, Discord, and Slack.

## Features

- Comprehensive set of utility functions.
- Written in Java 1.8.
- Well-documented code for easy understanding.
- Regular updates and maintenance.

## Installation

```bash
git clone --depth 1 https://github.com/sivaosorg/bot4j.git
```

## Generation Plugin Java

```bash
curl https://gradle-initializr.cleverapps.io/starter.zip -d type=groovy-gradle-plugin  -d testFramework=testng -d projectName=bot4j -o bot4j.zip
```

## Modules

Explain how users can interact with the various modules.

### Tidying up

To tidy up the project's Java modules, use the following command:

```bash
./gradlew clean
```

or

```bash
make clean
```

### Building SDK

```bash
./gradlew jar
```

or

```bash
make jar
```

### Upgrading version

- file `gradle.yml`

```yaml
ng:
  name: bot4j
  version: v1.0.0
  enabled_link: false # enable compression and attachment of the external libraries
  jars:
    # unify4J: Java 1.8 skeleton library offering a rich toolkit of utility functions
    # for collections, strings, date/time, JSON, maps, and more.
    - enabled: false # enable compression and attachment of the external libraries
      source: "./../libs/unify4j-v1.0.0.jar"
    # alpha4J: is a Java 8 library featuring common data structures and algorithms.
    # Enhance your projects with efficient and easy-to-use implementations designed for performance and clarity.
    - enabled: true
      source: "./../libs/alpha4j-v1.0.0.jar"
```

## Integration

1. Add dependency into file `build.gradle`

```gradle
implementation files('libs/bot4j-v1.0.0.jar') // filename based on ng.name and ng.version
```
