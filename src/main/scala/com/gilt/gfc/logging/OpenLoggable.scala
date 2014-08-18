package com.gilt.gfc.logging

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
