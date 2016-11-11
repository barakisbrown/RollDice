package Library

/**
  iDiePool Interface
  @author Matt "Barakis" Brown
*/

Interface iDiePool : iDie
{
  abstract lateinit var diePool: Array<IDie>
  abstract fun getDiceString() : String  
}
