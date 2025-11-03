import java.util.*;
import java.util.stream.Collectors;
//풀이수준 : B, 처음에 이중배열로 다 만들어놓고 순회하면서 합쳐야된다고 생각함.
//위아래로 계속왔다갔다하면서, row 크기만큼 선언된 StringBuilder에 하나씩 넣어주기만하면되는데..
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuilder();
        }
        int y = 0;
        int dir = 1;
        for (int i = 0; i < s.length(); i++) {
            sbArr[y].append(s.charAt(i));
            //이동
            if(y == 0) dir = 1;
            else if (y == numRows -1) dir = -1;
            //이동 결과 초과시 방향전환
            y+= dir;
        }
        return Arrays.stream(sbArr).map(StringBuilder::toString).collect(Collectors.joining());
    }
}