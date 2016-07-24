package org.chabior.money


/**
  * Created by Pawel on 23.07.2016.
  */
class Money (amount: BigInt, currency: Currency) extends Comparable[Money]{

  /**
    *
    * @param addend
    * @return
    */
  def add(addend: Money) : Money = {
    assertCurrency(addend.getCurrency())

    return new Money(amount + addend.getAmount(), currency)
  }

  /**
    *
    * @param substractor
    * @return
    */
  def substract(substractor: Money) : Money = {
    assertCurrency(substractor.getCurrency())

    return new Money(amount - substractor.getAmount(), currency)
  }

  /**
    *
    * @param dividor
    * @return
    */
  def divide(dividor: BigInt) : Money = {
    return new Money(amount / dividor, currency)
  }

  /**
    *
    * @param multiply
    * @return
    */
  def multiply(multiply: BigInt) : Money = {

    return new Money(amount * multiply, currency)
  }

  /**
    *
    * @param o
    * @return
    */
  def graterThan(o: Money): Boolean = {
    return compareTo(o) == 1
  }

  /**
    *
    * @param o
    * @return
    */
  def lessThan(o: Money): Boolean = {
    return compareTo(o) == -1
  }

  /**
    *
    * @param o
    * @return
    */
  def equals(o: Money): Boolean = {
    return compareTo(o) == 0
  }

  /**
    *
    * @param o
    * @return
    */
  def isSameCurrency(o: Money): Boolean = {
    return currency.equals(o.getCurrency())
  }

  /**
    *
    * @return
    */
  def isZero(): Boolean = {
    return amount == 0
  }

  /**
    *
    * @return
    */
  def isGreaterThanZero(): Boolean = {
    return amount > 0
  }

  /**
    *
    * @return
    */
  def isLessThanZero(): Boolean = {
    return amount < 0
  }

  /**
    *
    * @return
    */
  def getAmount(): BigInt = {
    return amount
  }

  /**
    *
    * @return
    */
  def getCurrency(): Currency = {
    return currency
  }

  /**
    *
    * @param addend
    * @return
    */
  def +(addend: Money) : Money = {
    return add(addend)
  }

  /**
    *
    * @param substractor
    * @return
    */
  def -(substractor: Money): Money = {
    return substract(substractor)
  }

  /**
    *
    * @param dividor
    * @return
    */
  def /(dividor: BigInt): Money = {
    return divide(dividor)
  }

  /**
    *
    * @param multiplier
    * @return
    */
  def *(multiplier: BigInt): Money = {
    return multiply(multiplier)
  }

  /**
    *
    * @param o
    * @return
    */
  def >(o: Money): Boolean = {
    assertCurrency(o.getCurrency())

    return amount > o.getAmount()
  }

  /**
    *
    * @param o
    * @return
    */
  def >=(o: Money): Boolean = {
    assertCurrency(o.getCurrency())

    return amount >= o.getAmount()
  }

  /**
    *
    * @param o
    * @return
    */
  def ==(o: Money): Boolean = {
    assertCurrency(o.getCurrency())

    return amount == o.getAmount()
  }

  /**
    *
    * @param o
    * @return
    */
  def <(o: Money): Boolean = {
    assertCurrency(o.getCurrency())

    return amount < o.getAmount()
  }

  /**
    *
    * @param o
    * @return
    */
  def <=(o: Money): Boolean = {
    assertCurrency(o.getCurrency())

    return amount <= o.getAmount()
  }

  /**
    *
    * @param o
    * @return
    */
  override def compareTo(o: Money): Int = {
    if (amount > o.getAmount()) {
      return 1
    } else if (amount < o.getAmount()) {
      return -1
    } else {
      return 0
    }
  }

  /**
    *
    * @param assert
    * @return
    */
  private def assertCurrency(assert: Currency) : Boolean = {
    if (!currency.equals(assert)) {
      throw new InvalidCurrencyException()
    }
    return true
  }
}
