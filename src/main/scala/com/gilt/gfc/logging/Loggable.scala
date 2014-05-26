package com.gilt.gfc.logging

import org.slf4j.LoggerFactory
import org.slf4j.MarkerFactory

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

/**
 * Opens up protected log functions in Loggable so they are accessible e.g. through a companion object,
 * reducing the number of logger instances:
 *
 * object Foo extends OpenLoggable
 *
 * class Foo {
 *   import Foo._
 *   info("bar")
 * }
 */
trait OpenLoggable extends Loggable {
  override def trace(message: => String) = super.trace(message)
  override def trace(message: => String, ex:Throwable) = super.trace(message, ex)
  override def debug(message: => String) = super.debug(message)
  override def debug(message: => String, ex:Throwable) = super.debug(message, ex)
  override def info(message: => String) = super.info(message)
  override def info(message: => String, ex:Throwable) = super.info(message, ex)
  override def warn(message: => String) = super.warn(message)
  override def warn(message: => String, ex:Throwable) = super.warn(message, ex)
  override def error(ex:Throwable) = super.error(ex)
  override def error(message: => String) = super.error(message)
  override def error(message: => String, ex:Throwable) = super.error(message, ex)
  override def fatal(ex:Throwable) = super.fatal(ex)
  override def fatal(message: => String) = super.fatal(message)
  override def fatal(message: => String, ex: Throwable) = super.fatal(message, ex)
}
