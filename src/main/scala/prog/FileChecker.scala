package prog

import prog.Main.args

import java.nio.file.{Files, Path, Paths}

object FileChecker {
  def check(name: String): Unit ={
    if (name.isEmpty) {
      println("dude, i need a file's name")
      sys.exit()
    }
    val path: Path = Paths.get(name)
    if (!Files.exists(path)){
      println("dude, file doesn't exist")
      sys.exit()
    }
    if(!Files.isReadable(path) || (!Files.isWritable(path))) {
      println("dude, i can't access the file")
      sys.exit()
    }
  }
}
