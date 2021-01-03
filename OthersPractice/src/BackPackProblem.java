import java.util.Scanner;

public class BackPackProblem {
    private static class good{
        public int v;
        public int p;
        public int q;

        public int a1 = 0;
        public int a2 = 0;

        public good(int v, int p, int q){
            this.v = v;
            this.p = p;
            this.q = q;
        }
        public void setA1(int a1){
            this.a1 = a1;

        }

        public void setA2(int a2){
            this.a2 = a2;
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if(n<=0||money<=0){
            System.out.println(0);
        }
        good[] list = new good[n+1];
        for(int i = 1; i<=n; i++){
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            list[i] = new good(v,p,q);

            if(q>0){
                if(list[q].a1 == 0){
                    list[q].setA1(i);
                }else{
                    list[q].setA2(i);
                }
            }
        }
        int[][] dp = new int[n+1][money+1];
        for(int i = 1; i<= n; i++){
            int v,v1=0,v2=0,v3=0,tempdp,tempdp1=0,tempdp2=0,tempdp3=0;
            v = list[i].v;
            tempdp = list[i].p * v;
            if(list[i].a1 != 0){
                v1 = list[list[i].a1].v+v;
                tempdp1 = tempdp + list[list[i].a1].v*list[list[i].a1].p;
            }
            if(list[i].a2 != 0){
                v2 = list[list[i].a2].v+v;
                tempdp1 = tempdp + list[list[i].a2].v*list[list[i].a2].p;
            }
            if(list[i].a1 != 0 && list[i].a2 != 0){
                v3 = list[list[i].a1].v+list[list[i].a2].v+v;
                tempdp3 = tempdp + list[list[i].a1].v*list[list[i].a1].p+
                        list[list[i].a2].v*list[list[i].a2].p;
            }
            for(int j=1; j<=money;j++){
                if(list[i].q>0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                    if(j>=v&&v!=0)
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v]+tempdp);
                    if(j>=v1&&v1!=0)
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v1]+tempdp1);
                    if(j>=v2&&v2!=0)
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v2]+tempdp2);
                    if(j>=v3&&v3!=0)
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v3]+tempdp3);
                }
            }
        }
        System.out.println(dp[n][money]);
    }


}