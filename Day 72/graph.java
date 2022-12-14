//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int[] prime;
    int numSize = 4;
    Solution()
    {
        int n = 10000;
        prime = new int[n];
        Arrays.fill(prime,1);
        for(int i = 2;i < Math.sqrt(n);i++)
        {
            for(int j = 2; j < n;j++)
            {
                if((i * j) >= n)
                {
                    break;
                }
                prime[i*j] = 0;
            }
        }
        
    }
    public int getNum(int arr[])
    {
        String num = arr[0] +""+arr[1]+""+arr[2] +""+arr[3];
        return Integer.parseInt(num);
    }
    public int[] getArr(int num)
    {
        int n = numSize;
        int arr[] = new  int[n];
        String temp = num + "";
        for(int i = 0;i < n;i++)
        {
            arr[i] = temp.charAt(i) - '0';
        }
        return arr;
    }
    public void getPossibleNum(int num , Queue<Integer> q)
    {
        for(int i = 0;i < numSize;i++)
        {
            int arr[] = getArr(num);
            for(int j = 0; j < 10; j++)
            {
                if(i == 0 && j == 0) continue;
                arr[i] = j;
                int newNum = getNum(arr);
                if(prime[newNum] == 1)
                {
                    q.add(newNum);
                }
                
            }
        }
    }
    public int shortestPath(int Num1,int Num2){
        
        if(Num1 == Num2) return 0;
        int level = 1;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        getPossibleNum(Num1,q);
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0;i < n;i++)
            {
                int queueNum = q.remove();
                if(queueNum == Num2)
                {
                    return level;
                }
                if(set.contains(queueNum)) continue;
                set.add(queueNum);
                getPossibleNum(queueNum,q);
            }
            
            level++;
        }
        return level;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends
