package net.flow9.rxandroidbasic01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    Subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        // 서브젝트 생성
        subject = new Subject();
        // 서브젝트 동작시작
        subject.start();
    }

    int count = 0;
    private void initView() {
        button = (Button) findViewById(R.id.button);
        // 버튼이 클릭될 때 마다 Subject에 옵저버를 추가
        button.setOnClickListener(v->{
            count++;
            subject.addObserver(new ObserverImpl("Observer"+count));
        });
    }

    // 옵저버의 구현체
    public class ObserverImpl implements Subject.Observer {
        String myName = "";

        public ObserverImpl(String name){
            myName = name;
        }

        @Override
        public void notification(String msg) {
            System.out.println(myName+":"+msg);
        }
    }
}
