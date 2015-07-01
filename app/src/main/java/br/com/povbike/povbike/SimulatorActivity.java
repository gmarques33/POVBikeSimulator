package br.com.povbike.povbike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.povbike.povbike.customview.LedBoard;

public class SimulatorActivity extends AppCompatActivity {

    private LedBoard mLedBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulator);
        mLedBoard = (LedBoard) findViewById(R.id.led_board);

        mLedBoard.setBytes(generateBytes(16));
        mLedBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLedBoard.setBytes(generateBytes(16));
                mLedBoard.invalidate();
            }
        });
    }

    private List<Byte> generateBytes(int size) {
        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        List<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bytes.add((byte) rnd.nextInt(255));
        }

        return bytes;
    }

}
