package org.gfccollective.logging;

import org.scalatest.flatspec.AnyFlatSpec;

class LoggableTest extends AnyFlatSpec {
    behavior of "a Loggable class"

    it should "log" in {
        val hello = new HelloWorld()
        hello.logEverything()
    }
    
}

class HelloWorld extends Loggable {
    def logEverything(): Unit = {
        trace("Hello trace")
        debug("Hello debug")
        info("Hello info")
        warn("Hello warn")
        error("Hello error")
    }
}