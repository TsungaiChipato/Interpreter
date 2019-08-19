public class Identifier {
  private String name;

  Identifier () {
    name = "default";
  }

  Identifier (String s) {
    name = s;
  }

  Identifier (Identifier src) {                                 //i.identifier is private
    name = src.name;
  }

  public void init(String s) {
    name = s;
  }

  public String getName() {
    return name;
  }

  public char getCharacter(int i) {                             //i cant be bigger than name.size()
    return name.charAt(i);
  }

  public int getSize() {
    return name.length();
  }

  public void addChar(char c) {
    name += c + "";
  }

  public boolean isEqual(Identifier i) {                        //i.identifier is private
     if (name.equals(i.getName())) {
       return true;
     }
     return false;
   }
}
