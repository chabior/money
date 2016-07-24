package org.chabior.money

import org.scalatest.{BeforeAndAfter, FunSuite}

class MoneyTest extends FunSuite with BeforeAndAfter {

  val currency : Currency =  EUR

  test("add money")  {
    val base = new Money(10, currency)
    val expected = new Money(20, currency)
    assert(expected.equals(base.add(base)))
  }

  test("substract money") {
    val base = new Money(40, currency)
    val expected = new Money(10, currency)

    assert(expected.equals(base.substract(new Money(30, currency))))
  }

  test("multiply") {
    val base = new Money(100, currency)
    val expected = new Money(200, currency)

    assert(expected.equals(base.multiply(2)))
  }

  test("divide") {
    val base = new Money(100, currency)
    val expected = new Money(50, currency)

    assert(expected.equals(base.divide(2)))
  }

  test("+") {
    val base = new Money(20, currency)
    val expected = new Money(40, currency)

    assert(expected.equals(base + base))
  }

  test("-") {
    assert( new Money(10, currency) == new Money(40, currency) - new Money(30, currency))
  }

  test("/") {
    assert(new Money(50, currency) == new Money(100, currency) / 2)
  }

  test("*") {
    assert(new Money(100, currency) == new Money(50, currency) * 2)
  }

  test(">") {
    assert(new Money(100, currency) > new Money(90, currency))
  }

  test("<") {
    assert(new Money(90, currency) < new Money(120, currency))
  }

  test(">=") {
    assert(new Money(120, currency) >= new Money(1, currency))
    assert(new Money(120, currency) >= new Money(120, currency))
  }

  test("<=") {
    assert(new Money(2, currency) <= new Money(50, currency))
    assert(new Money(2, currency) <= new Money(2, currency))
  }

  test("isZero") {
    val base = new Money(0, currency)
    assert(base.isZero())
  }

  test("diffrent currency") {
    intercept[InvalidCurrencyException] {
      new Money(10, currency) + new Money(10, USD)
    }
  }
}
