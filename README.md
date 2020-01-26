# gfc-logging [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.gfccollective/gfc-logging_2.12/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/org.gfccollective/gfc-logging_2.12) [![Build Status](https://github.com/gfc-collective/gfc-logging/workflows/Scala%20CI/badge.svg)](https://github.com/gfc-collective/gfc-logging/actions) [![Coverage Status](https://coveralls.io/repos/gfc-collective/gfc-logging/badge.svg?branch=master&service=github)](https://coveralls.io/github/gfc-collective/gfc-logging?branch=master)

A library that contains logging related scala utility classes.
A fork and new home of the now unmaintained Gilt Foundation Classes (`com.gilt.gfc`), now called the [GFC Collective](https://github.com/gfc-collective), maintained by some of the original authors.


## Getting gfc-logging

The latest version is 1.0.0, released on 21/Jan/2020 and cross-built against Scala 2.12.x and 2.13.x.

If you're using SBT, add the following line to your build file:

```scala
libraryDependencies += "org.gfccollective" %% "gfc-logging" % "1.0.0"
```

For Maven and other build tools, you can visit [search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Corg.gfccollective).
(This search will also list other available libraries from the GFC Collective.)

## Contents and Example Usage

### org.gfccollective.logging.Loggable

The org.gfccollective.logging.Loggable trait can be mixed in to add a logger instance to a type that
uses slf4j to abstract the underlying logging framework and supports lazy log message computation.

A logger instance with each instance of this trait:

    trait SomeTrait extends AnotherTrait with Loggable {
      def logSomething: Unit = {
        info("This " + "String" + " is " + "constructed" + " lazily")
      }
    }

A logger singleton for all instances of the companion class:

    object SomeThing extends OpenLoggable

    class SomeThing {
      import SomeThing._

      def logSomething: Unit = {
        info("This " + "String" + " is " + "constructed" + " lazily")
      }
    }

## License

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
