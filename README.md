# gfc-logging [![Build Status](https://travis-ci.org/gilt/gfc-logging.svg?branch=master)](https://travis-ci.org/gilt/gfc-logging) [![Coverage Status](https://coveralls.io/repos/gilt/gfc-logging/badge.svg?branch=master&service=github)](https://coveralls.io/github/gilt/gfc-logging?branch=master) [![Join the chat at https://gitter.im/gilt/gfc](https://badges.gitter.im/gilt/gfc.svg)](https://gitter.im/gilt/gfc?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

A library that contains logging related scala utility classes. Part of the [Gilt Foundation Classes](https://github.com/gilt?query=gfc).

## Getting gfc-logging

The latest version is 0.0.7, which is cross-built against Scala 2.10.x, 2.11.x and 2.12.x.

If you're using SBT, add the following line to your build file:

```scala
libraryDependencies += "com.gilt" %% "gfc-logging" % "0.0.7"
```

For Maven and other build tools, you can visit [search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Ccom.gilt%20gfc).
(This search will also list other available libraries from the gilt fundation classes.)

## Contents and Example Usage

### com.gilt.gfc.logging.Loggable

The com.gilt.gfc.logging.Loggable trait can be mixed in to add a logger instance to a type that
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
Copyright 2014 Gilt Groupe, Inc.

Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
