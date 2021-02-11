package prog.IO

import prog.Main._

import java.io.{FileOutputStream, OutputStreamWriter}

object WriteToFile {

  def writeToFile() : Unit = {
    try {
      val streamWriter = new OutputStreamWriter(new FileOutputStream(filename))
      streamWriter.write("<file>\n")
      collection.foreach(x => streamWriter.write(x.toXml.toString())) // Writing to the file each element of collection
      streamWriter.write("\n</file>")
      streamWriter.close()
      println("Data was written to " + filename)
    } catch {
      case e: Throwable => Console.err.println("\tProblem with writing collection to file\n\t" + e.getMessage)
    }
  }
}
