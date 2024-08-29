class PrintLcsRecursively {
    public static int lcs(String text1, String text2, int n, int m, int dp[][],String s[]){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        else if(text1.charAt(n-1)==text2.charAt(m-1)){
            s[0]=text1.charAt(n-1)+s[0];
            return dp[n][m]=1+lcs(text1,text2,n-1,m-1,dp,s);
        }
        else{
            return dp[n][m]=Math.max(lcs(text1,text2,n-1,m,dp,s),lcs(text1,text2,n,m-1,dp,s));
        }
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        String s1= "abcde";
        String s2= "bdgek";
        s1 = "abcde";
        s2 = "ace";
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        String s[]=new String[1];
        
        s[0]="";
        System.out.print("The Longest Common Subsequence is ");
        System.out.println(lcs(s1,s2,n,m,dp,s));
        System.out.println(s[0]);
    }
}
