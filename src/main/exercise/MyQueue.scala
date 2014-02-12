package exercise

import scala.collection.mutable.ListBuffer

class MyStack {
  val value = new ListBuffer[String]
  def push(pushValue: String) = {
    value += pushValue
  }
  def pull = {
    if(isNotEmpty) value.remove(value.size - 1)
    else throw new Exception("キューは空っぽです。")

  }

  def isNotEmpty = {
    value.size > 0
  }
}

class MyQueue {
  val stack1 = new MyStack
  val stack2 = new MyStack

  def push(pushValue: String) = {
    stack1.push(pushValue)
  }

  def pull: String = {
    move(stack1, stack2)
    val pullStr = stack2.pull
    move(stack2, stack1)
    pullStr
  }

  def move(from: MyStack, to: MyStack) {
    if (from.isNotEmpty) {
        to.push(from.pull)
        move(from, to)
    }
  }
}