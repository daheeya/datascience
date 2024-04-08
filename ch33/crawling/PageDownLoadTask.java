package ch33.crawling;

import javax.swing.plaf.basic.BasicListUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.concurrent.*;

public class PageDownLoadTask implements Runnable{  // 페이지를 다운받는 스레드

    private String url;
    private BlockingQueue<String> queue;
    public PageDownLoadTask(String url,BlockingQueue<String> queue){
        this.url=url;
        this.queue=queue;
    }

    @Override
    public void run() {
        try {
            URLConnection connection=new URL(url).openConnection();  // 자바에서 URL을 받아오려면 connection 사용하는구나~
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // InputStreamReadr: 문자로 받아오기, getInputStream(): 바이트크기로 받아와야 하니까

            StringBuilder content = new StringBuilder();
            String line;
            while((line = reader.readLine())!= null) content.append(line);

            queue.put(content.toString());

        } catch (InterruptedException | IOException e) {  // art+Enter : collapse Exception
            throw new RuntimeException(e);
        }

    }
}

class PageAnalysisTack implements Runnable{  // 페이지가 다운된 것을 분석하는 스레드

    private BlockingQueue<String> queue;
    public PageAnalysisTack(BlockingQueue<String> queue){
        this.queue=queue;
    }

    @Override
    public void run() {
        String content = null;
        try {
            content = queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("analysis web page : " + content);

    }
}

class AppUI{  // 메인 스레드
    public static void main(String[] args) {
        int num_thread = 4;
        String[] urls = {"https://www.daegu.ac.kr/main"};
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();  // 자바에서는 큐를 사용하려면 링크드리스트로,, 그래서 Linked~~~tkdyd
        // 공통의 자원(Blockingqueue) 을 여러개의 스레드로 병렬적 실행을 시킬 것 : Blockingqueue 사용

        ExecutorService executorService = Executors.newFixedThreadPool(num_thread);

        for(var url:urls) {
            executorService.execute(new PageDownLoadTask(url,queue));  // 스레드는 다르지만 같은 큐를 바라보고 있음.
        }

        for(int i=0;i<num_thread;i++){
            executorService.execute(new PageAnalysisTack(queue));
        }
        executorService.shutdown();
        System.out.println("Main thread end ...........");
        // 이렇게 하면 스레드가 알아서 교통정리를 해준다.
    }
}