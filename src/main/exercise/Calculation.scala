package exercise

object Calculation {
  def add(base: Int, target: Int) = {
    base + target
  }

  def minus(base: Int, target: Int) = {
    base + (-target)
  }

  def multiple(base: Int, target: Int) = {
    def calculate(sum: Int, cnt: Int): Int = {
      if (cnt == target) sum
      else calculate(sum + base, cnt + 1)
    }
    calculate(0, 0)
  }

  def divide(base: Int, target: Int) = {
    def calculate(sum: Int, cnt: Int): Int = {
      if (sum > base) cnt
      else calculate(sum + target, cnt + 1)
    }
    calculate(target, 0)
  }
}

