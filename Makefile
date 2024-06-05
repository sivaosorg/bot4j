.PHONY: build test jar clean

build:
	./gradlew jar

clean:
	./gradlew clean

jar: build

list-task:
	./gradlew tasks

test:
	./gradlew test

groovy:
	./gradlew build
