/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */
// Returns the count of a string state.
public class StateCounter implements Comparable<StateCounter> {
  String state;
  Integer count;

  // Sets the state and count of the state. (Constructor)
  public StateCounter(String state, Integer count) {
    this.state = state;
    this.count = count;
  }

  
  /** 
   * @param o
   * @return int
   */
  @Override
  public int compareTo(StateCounter o) {
    return this.count - o.count;
  }
  

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
    return this.state + "\t" + this.count;
  }
}
