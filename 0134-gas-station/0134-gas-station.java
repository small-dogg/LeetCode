class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //n개의 circular route 주유소가 있음
        //그리고 i번째 주유소의 가스 가격이 cost i번째에 존재
        //무제한 가스탱크를 갖은 자동차 있음. 그리고

        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas <totalCost) return -1;

        int startIndex = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];//현재 주유소에 도달하면서 발생된 비용과 채워진 기름
            if (tank < 0) {
                startIndex = i + 1;
                tank = 0;
            }
        }

        return startIndex;
    }
}