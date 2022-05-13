/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */
public class StateCounter implements Comparable<StateCounter> {
  String state;
  Integer count;

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
