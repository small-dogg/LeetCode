class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted((a,b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(collect.get(i).getKey());
        }

        return list.stream()
                .mapToInt(a -> a)
                .toArray();
    }
}