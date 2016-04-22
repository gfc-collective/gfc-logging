package com.gilt.gfc.logging

import org.slf4j.{LoggerFactory, MarkerFactory}

object Loggable {
  private val LvlFatal = MarkerFactory.getDetachedMarker("FATAL")
}

trait Loggable {
  import Loggable.LvlFatal

  @transient private[this] val logger = LoggerFactory.getLogger(getClass.getName)

  protected def trace(message: => String) = if (logger.isTraceEnabled) logger.trace(message)
  protected def trace(message: => String, ex:Throwable) = if (logger.isTraceEnabled) logger.trace(message,ex)

  protected def debug(message: => String) = if (logger.isDebugEnabled) logger.debug(message)
  protected def debug(message: => String, ex:Throwable) = if (logger.isDebugEnabled) logger.debug(message,ex)

  protected def info(message: => String) = if (logger.isInfoEnabled) logger.info(message)
  protected def info(message: => String, ex:Throwable) = if (logger.isInfoEnabled) logger.info(message,ex)

  protected def warn(message: => String) = if (logger.isWarnEnabled) logger.warn(message)
  protected def warn(message: => String, ex:Throwable) = if (logger.isWarnEnabled) logger.warn(message,ex)

  protected def error(ex:Throwable) = if (logger.isErrorEnabled) logger.error(ex.toString,ex)
  protected def error(message: => String) = if (logger.isErrorEnabled) logger.error(message)
  protected def error(message: => String, ex:Throwable) = if (logger.isErrorEnabled) logger.error(message,ex)

  /* FATAL level is not supported anymore by SLF4j. As a replacement we use a 'marker' called FATAL.
   * Please note that only Logback supports markers.
   */
  protected def fatal(ex:Throwable) = if (logger.isErrorEnabled) logger.error(LvlFatal, ex.toString, ex)
  protected def fatal(message: => String) = if (logger.isErrorEnabled) logger.error(LvlFatal, message)
  protected def fatal(message: => String, ex: Throwable) = if (logger.isErrorEnabled) logger.error(LvlFatal, message, ex)
}
