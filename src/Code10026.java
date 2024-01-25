import java.io.*;

public class Code10026 {
    static int[] dX = {0, 1, 0, -1};
    static int[] dY = {1, 0, -1, 0};
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, countR = 0, countG = 0, countB = 0, countRG = 0;
        String s;
        char[][] pic;
        try {
            n = Integer.parseInt(br.readLine());
            pic = new char[n][n];

            for(int i = 0; i < n; i++){
                s = br.readLine();
                pic[i] = s.toCharArray();
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(pic[i][j] == 'R'){
                        boundR(pic, j, i);
                        countR++;
                    }
                    if(pic[i][j] == 'G'){
                        boundG(pic, j, i);
                        countG++;
                    }
                    if(pic[i][j] == 'B'){
                        boundB(pic, j, i);
                        countB++;
                    }
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(pic[i][j] == 'r' || pic[i][j] == 'g'){
                        boundRG(pic, j, i);
                        countRG++;
                    }
                }
            }

            bw.write((countR + countG + countB) + " " + (countRG + countB));

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                bw.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    static void boundR(char[][] picture, int startX, int startY){
        int nX, nY;

        picture[startY][startX] = 'r';

        for(int i = 0; i < 4; i++){
            nX = startX + dX[i];
            nY = startY + dY[i];
            if(nX >= 0 && nX < picture[0].length && nY >= 0 && nY < picture.length){
                if(picture[nY][nX] == 'R'){
                    boundR(picture, nX, nY);
                }
            }
        }
    }

    static void boundG(char[][] picture, int startX, int startY){
        int nX, nY;

        picture[startY][startX] = 'g';

        for(int i = 0; i < 4; i++){
            nX = startX + dX[i];
            nY = startY + dY[i];
            if(nX >= 0 && nX < picture[0].length && nY >= 0 && nY < picture.length){
                if(picture[nY][nX] == 'G'){
                    boundG(picture, nX, nY);
                }
            }
        }
    }

    static void boundB(char[][] picture, int startX, int startY){
        int nX, nY;

        picture[startY][startX] = 'b';

        for(int i = 0; i < 4; i++){
            nX = startX + dX[i];
            nY = startY + dY[i];
            if(nX >= 0 && nX < picture[0].length && nY >= 0 && nY < picture.length){
                if(picture[nY][nX] == 'B'){
                    boundB(picture, nX, nY);
                }
            }
        }
    }

    static void boundRG(char[][] picture, int startX, int startY){
        int nX, nY;

        picture[startY][startX] = 'W';

        for(int i = 0; i < 4; i++){
            nX = startX + dX[i];
            nY = startY + dY[i];
            if(nX >= 0 && nX < picture[0].length && nY >= 0 && nY < picture.length){
                if(picture[nY][nX] == 'r' || picture[nY][nX] == 'g'){
                    boundRG(picture, nX, nY);
                }
            }
        }
    }

}
