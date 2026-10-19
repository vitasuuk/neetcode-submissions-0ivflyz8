class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        Map<Character, Integer> tFreq = new HashMap();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int curr = 0;
        int goal = tFreq.size();
        int shortestLength = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        Map<Character, Integer> windowMap = new HashMap();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (windowMap.get(c).equals(tFreq.getOrDefault(c, 0))) {
                curr++;
            }

            while (curr == goal) {
                if (r - l + 1 < shortestLength) {
                    shortestLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char left = s.charAt(l);
                windowMap.put(left, windowMap.get(left) - 1);
                if (windowMap.getOrDefault(left, 0) < tFreq.getOrDefault(left, 0)) {
                    curr--;
                }
                
                l++;
            }
        }

        return shortestLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
