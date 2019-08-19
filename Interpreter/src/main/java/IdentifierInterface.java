
interface IdentifierInterface {

/*
 *
 * Elements: Consists of characters
 * Structure: Linear
 * Domain: Identifier has to start with a letter and proceed with alphanumerical
           characters.
 *
 * constructors
 *
 * Identifier(char c);
 *   PRE  - C is letter.
 *   POST - A new Identifier-object has been made and contains a c.
 *
 * Identifier(Identifier src);
 *   PRE  -
 *   POST - A new Identifier-object has been made and contains a copy of src.
 *
 */

void init(char c);
/* PRE -  C is letter
   POST - Contains character c.
*/

String getIdentifier();
/* PRE -
   POST - Contains identifier.
*/

char getCharacter(int i);
/* PRE -  Not larger than the identifier length.
   POST - Contains character at position i of identifier.
*/

int getSize();
/* PRE -
   POST - Contains size of identifier.
*/

void addChar(char c);
/* PRE  -  c has to be alphanumerical.
   POST -  Concates c to identifier.
*/

boolean isEqual(Identifier i);
/* PRE -
   POST - true:  Identifier is identical to i.
          false: Identifier is not identical to i.
*/

}
