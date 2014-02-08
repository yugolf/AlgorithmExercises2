object Exercise {
  def main(args: Array[String]): Unit = {
    println(isSubstring("abcdefgabe","gab"))
  }

  def isSubstring (full:String, part:String) = {
    def check(full: String, fullPos: Int, part: String, partPos: Int):Int ={
      if(fullPos == full.length || partPos == part.length) partPos
      else if(full(fullPos) == part(partPos)) check(full, fullPos + 1, part, partPos + 1)
      else check(full, fullPos + 1, part, 0)
    }

    check(full, 0, part, 0) == part.length
  }
}
