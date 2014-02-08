object Exercise {
  def main(args: Array[String]): Unit = {
    println(isSubstring1("abcdefgabe","gab"))
  }

  def isSubstring1 (full:String, part:String) = {
    def check(full: String, fullPos: Int, part: String, partPos: Int):Int ={
      if(fullPos == full.length || partPos == part.length) partPos
      else if(full(fullPos) == part(partPos)) check(full, fullPos + 1, part, partPos + 1)
      else check(full, fullPos + 1, part, 0)
    }

    check(full, 0, part, 0) == part.length
  }

  def isSubstring2(s1: String, s2: String):Boolean = {

    val s2l = s2.length -1
    println("s2l:" + s2l)

    var s2count = 0

      for(j <- 0 until s1.length){
        if(s2(s2count) == s1(j)) {
          println("part:" + s2count + ":" + s2(s2count)+ ",full:"+ j +":" + s1(j)+ "s2count:" + s2count)
          if(s2count == s2l) return true
          s2count = s2count + 1
        } else {
          s2count = 0
        }
      }
      s2count = s2count + 1
      println(s2(s2count) + "s2count" + s2count)
    false
  }


}
