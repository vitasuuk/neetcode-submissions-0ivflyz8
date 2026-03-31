class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {   
        Map<String, List<String>> anam = new HashMap<>();    
        for(String s : strs)
        {
            char[] carr = s.toCharArray();
            Arrays.sort(carr);
            String sorted = new String(carr);
            anam.putIfAbsent(sorted, new ArrayList<>());
            anam.get(sorted).add(s);
        }
        return new ArrayList<>(anam.values());
    }

   
}
