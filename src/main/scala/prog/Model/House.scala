package prog.Model

class House(name: String, year: Int, numberOfFloors: Int){
  if (year <= 0) throw new IllegalArgumentException("year must be more than 0")
  if (numberOfFloors <= 0) throw new IllegalArgumentException("numberOfFloors must be more than 0")
  if (numberOfFloors > 47) throw new IllegalArgumentException("numberOfFloors must be less than 48")

  override def toString: String = {
    "House " + name +
    "(year: " + year +
    ", number of floors: " + numberOfFloors + ")"
  }
}
