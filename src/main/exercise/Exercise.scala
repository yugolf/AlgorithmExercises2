package exercise

object Exercise extends App {

  println("isSubstring:" + isSubstring("maede", "ed"))
  println("isOverlap:" + isOverlap("abcdee"))
  println("isTurn:" + isTurn("abcdefg", "cdefgab"))
  println(Calculation.add(3, 5))
  println(Calculation.minus(5, 3))
  println(Calculation.multiple(3, 5))
  println(Calculation.divide(13, 3))

  val q = new MyQueue()
  q.push("aaa")
  q.push("bbb")
  q.push("ccc")
  println(q.pull)
  q.push("ddd")
  println(q.pull)
  println(q.pull)
  println(q.pull)

  def isOverlap(target: String) = {
    def compare(basePos: Int, checkPos: Int): (Boolean) = {
      if (basePos >= target.length) false
      else if (basePos == checkPos) compare(basePos, checkPos + 1)
      else if (checkPos >= target.length) compare(basePos + 1, 0)
      else if (target(basePos) != target(checkPos)) compare(basePos, checkPos + 1)
      else true
    }
    compare(0, 0)
  }

  def isSubstring(full: String, part: String) = {
    def check(fullPos: Int, partPos: Int): Int = {
      if (fullPos == full.length || partPos == part.length) partPos
      else if (full(fullPos) == part(partPos)) check(fullPos + 1, partPos + 1)
      else check(fullPos + 1, 0)
    }
    check(0, 0) == part.length
  }

  def isTurn(base: String, target: String) = {
    def turnPoint(part: String): Int = {
      if (part.length == 0) 0
      else if (isSubstring(base, part)) part.length
      else turnPoint(part.tail)
    }
    def check(basePos: Int, targetPos: Int): Boolean = {
      if (basePos >= base.length) true
      else if (targetPos >= target.length) check(basePos, 0)
      else if (base(basePos) == target(targetPos)) check(basePos + 1, targetPos + 1)
      else false
    }

    check(0, target.length - turnPoint(target))
  }
}

