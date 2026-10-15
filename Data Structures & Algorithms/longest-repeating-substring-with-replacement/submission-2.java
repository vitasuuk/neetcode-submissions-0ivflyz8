class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> fmap = new HashMap();
        int l = 0;
        int maxf = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            fmap.put(s.charAt(r), fmap.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, fmap.get(s.charAt(r)));

            while ((r - l + 1) - maxf > k) {
                fmap.put(s.charAt(l), fmap.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
