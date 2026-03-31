class Solution {

    public String encode(List<String> strs) 
    {
        StringBuilder s = new StringBuilder();
        for(String word: strs) {
            s.append(word.length() + "#" + word);
        }
        System.out.println(s.toString());
        return s.toString();
    }

    public List<String> decode(String str) 
    {
        StringBuilder sb = new StringBuilder();
        List<String> s = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            sb.setLength(0);
			String num = "";
            for(int j = i; j < str.length(); j++) {
                if(Character.isDigit(str.charAt(j))) {
                    num += str.charAt(j);
                } else {
                    break;
                }
            }

            int n = Integer.parseInt(num);
            if(str.charAt(i + num.length()) == '#') {
                for(int ind = i + num.length() + 1; ind <= i + n + num.length(); ind++) {
                    sb.append(str.charAt(ind));
                }
            }
            s.add(sb.toString());
            i += n + num.length() + 1;
        }
        return s; 
    }
}
