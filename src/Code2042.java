import java.io.*;
import java.util.*;
//24.10.14
//설계 시간: 답지 참조
//구현 시간: 분
//메모리: kb
//시간: ms
//배열 인덱스 맞추기 헷갈림
public class Code2042 {
    static int N,M,K;
    static long[] nums, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new long[N];
        tree = new long[4*N+1];

        for(int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        makeTree(0,N-1,1);

        for(int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                if(b < 1 || b > N) continue;
                long diff = c-nums[(int)b-1];
                update(0,N-1,1,(int)b-1,diff);
                nums[(int)b-1] = c;
            }else if(a == 2) {
                bw.write(getSum(0,N-1,1,(int)b-1,(int)c-1)+"\n");
            }
        }

        bw.close();
    }

    static long makeTree(int start, int end, int idx) {
        //리프노드인 경우
        if(start == end) {
            //nums의 값을 삽입 (구간 1)
            return tree[idx] = nums[start];
        }
        //리프노드가 아닌 경우
        int mid = (start+end)/2;
        //왼쪽 자식과 오른쪽 자식 값 합
        return tree[idx] = makeTree(start,mid,idx*2) + makeTree(mid+1,end,idx*2+1);
    }
    //b번째 값을 c로 업데이트
    static void update(int start, int end, int idx, int b, long diff) {
        //변경할 idx 값이 범위 밖에면 확인 불필요
        if(b < start || b > end) return;
        //원래 값과 변경 값의 차 더하기
        tree[idx] += diff;
        //리프노드이면 리턴
        if(start == end) return;
        //리프노드가 아니면 자식들도 확인
        int mid = (start+end)/2;
        update(start,mid,idx*2,b,diff);
        update(mid+1,end,idx*2+1,b, diff);
    }
    //b부터 c구간까지 합 구하기
    static long getSum(int start, int end, int idx, int b, int c) {
        if(b > end || c < start) return 0;

        if(b <= start && end <= c) return tree[idx];

        int mid = (start+end)/2;
        return getSum(start,mid,idx*2,b,c)+getSum(mid+1,end,idx*2+1,b,c);
    }
}
