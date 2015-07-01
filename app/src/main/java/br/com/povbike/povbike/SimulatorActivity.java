package br.com.povbike.povbike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

        Random rnd = new Random();
        rnd.setSeed(System.currentTimeMillis());

        List<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            bytes.add((byte) 0xff);
        }

        mLedBoard.setBytes(bytes);
    }
}
