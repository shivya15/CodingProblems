public class PrintShortestCommonSupersequence {
    public static void main(String args[]){
        String s1= "abac";
        String s2= "cab";
        //SCS=cabac
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int ans=n+m-dp[n][m];
        System.out.println("SCS is "+ans);
        //code for printing lcs
        String s="";
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                s=s1.charAt(i-1)+s;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    s=s1.charAt(i-1)+s;
                    i--;
                }
                else{
                    s=s2.charAt(j-1)+s;
                    j--;
                }
            }
        }
        while(i>0){
            s=s1.charAt(i-1)+s;
            i--;
        }
        while(j>0){
            s=s2.charAt(j-1)+s;
            j--;
        }
        System.out.println("printing shortest common supersequence: "+s);
    }
}
