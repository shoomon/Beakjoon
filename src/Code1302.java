import java.io.*;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

class Book implements Comparable<Book>{
    String title;
    int count = 1;
    public Book(String t){
        this.title = t;
    }

    public void selling(){
        this.count++;
    }
    @Override
    public int compareTo(Book o) {
        if(o.count == this.count){
            return this.title.compareTo(o.title);
        }else{
            return o.count - this.count;
        }
    }
}
public class Code1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        TreeMap<Book, String> map = new TreeMap<>();
        HashMap<String, Book> hMap = new HashMap<>();


        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            Book b = new Book(br.readLine());
            if(hMap.containsKey(b.title)){
                hMap.get(b.title).selling();
            }else{
                hMap.put(b.title, b);
            }
        }

        for(Entry<String, Book> e : hMap.entrySet()){
            map.put(e.getValue(), e.getKey());
        }

        bw.write(map.firstKey().title);
        br.close();
        bw.close();

    }
}
