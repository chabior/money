package org.chabior.money

trait Enum[A] {
  trait Value { self: A =>
    _values :+= this
  }
  private var _values = List.empty[A]
  def values = _values
}

object Currency extends Enum[Currency]
sealed trait Currency extends Currency.Value
case object EUR extends Currency
case object GBP extends Currency
case object USD extends Currency
case object PLN extends Currency