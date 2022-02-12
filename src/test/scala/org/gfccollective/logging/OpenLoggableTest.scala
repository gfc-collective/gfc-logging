package org.gfccollective.logging;

import org.scalatest.flatspec.AnyFlatSpec;

class OpenLoggableTest extends AnyFlatSpec {
    behavior of "a Loggable class"

    it should "log" in {
        val hello = new HelloOpenLoggable()
        hello.logEverything()
    }
    
}

class HelloOpenLoggable extends OpenLoggable {
    def logEverything(): Unit = {
        val throwable = new DummyException()
        trace("Hello trace")
        trace("Hello trace with Throwable", throwable)
        debug("Hello debug")
        debug("Hello debug with Throwable", throwable)
        info("Hello info")
        info("Hello info with Throwable", throwable)
        warn("Hello warn")
        warn("Hello warn with Throwable", throwable)
        error("Hello error")
        error("Hello error with Throwable", throwable)
    }
}