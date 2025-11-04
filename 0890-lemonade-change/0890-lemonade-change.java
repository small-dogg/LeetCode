//풀이수준 : A-, 그리디
class Solution {
    public boolean lemonadeChange(int[] bills) {
        //레모네이드 가격은 5달러, 한명당 1잔씩만 팔 수 있음
        //bills 배열은 레모네이드 살라고 줄서있는 사람이 지불한 돈
        //거스름돈을 올바르게 줄수 있는지를 검증
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            switch (bill) {
                case (5):
                    five++;
                    break;
                case (10): {
                    if (five > 0) {
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                    break;
                }
                case (20): {
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    } else if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }
}