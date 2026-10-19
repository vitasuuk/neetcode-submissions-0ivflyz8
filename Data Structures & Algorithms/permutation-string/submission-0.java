class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Freq = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Freq.put(c, s1Freq.getOrDefault(c, 0) + 1);
        }

        int goal = s1Freq.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> s2Freq = new HashMap();
            int curr = 0;

            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);
                s2Freq.put(c, s2Freq.getOrDefault(c, 0) + 1);

                if (s2Freq.get(c) > s1Freq.getOrDefault(c, 0))
                    break;

                if (s2Freq.get(c) == s1Freq.getOrDefault(c, 0)) {
                    curr++;
                }

                if (curr == goal) {
                    return true;
                }
            }
        }
        return false;
    }
}
