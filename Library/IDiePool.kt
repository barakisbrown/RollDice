package Library

/**
  iDiePool Interface
  Base for all my DicePool classes like my IDie interface
  @author Matt "Barakis" Brown
*/

interface IDiePool : IDie
{
  abstract lateinit var diePool: Array<IDie>
  abstract fun getDiceString() : String  
}
