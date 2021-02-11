package prog

import java.nio.file.{Files, Path, Paths}

object FileChecker {
  /**
   *
   * @param name name of the file
   * @param full = true - check all
   *             false - wouldn't check ability to write to the file
   * @return true if having some problems otherwise false
   */
  def check(name: String, full: Boolean = true): Boolean = {
    if (name.isEmpty) {
      Console.err.println("\tdude, i need a file's name")
      return true
    }
    val path: Path = Paths.get(name)
    if (!Files.exists(path)){
      Console.err.println("\tdude, file doesn't exist")
      return true
    }
    if(!Files.isReadable(path)) {
      Console.err.println("\tdude, i can't read the file")
      return true
    }
    if (full && (!Files.isWritable(path))){
      Console.err.println("\tdude, i haven't ability to write to the file")
      return true
    }
    false
  }
}
