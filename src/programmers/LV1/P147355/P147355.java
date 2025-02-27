package programmers.LV1.P147355;

public class P147355 {
  public int solution(String t, String p) {
    int count = 0;
    int pLength = p.length();
    long pValue = Long.parseLong(p);

    for (int i = 0; i <= t.length() - pLength; i++){
      String substring = t.substring(i, i + pLength);
      long substringValue = Long.parseLong(substring);

      if (substringValue <= pValue) {
        count++;
      }
    }
    return count;
  }
}
