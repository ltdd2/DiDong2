package com.example.exe4;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SoundEffectActivity extends AppCompatActivity {

    private Button btnBackMenu;
    private SoundPool soundPool;

    private AudioManager audioManager;

    // Số luồng âm thanh phát ra tối đa.
    private static final int MAX_STREAMS = 5;

    // Chọn loại luồng âm thanh để phát nhạc.
    private static final int streamType = AudioManager.STREAM_MUSIC;

    private boolean loaded;

    private int soundIdDestroy;
    private int soundIdGun;
    private int soundIDMusic;
    private int soundIdDun;
    private int soundIdEvil;
    private int soundIDFall;
    private int soundIdIll;
    private int soundIdSad;

    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_effects_activity);
        btnBackMenu = (Button) findViewById(R.id.btnBackMenu);
        btnBackMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SoundEffectActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Đối tượng AudioManager sử dụng để điều chỉnh âm lượng.
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Chỉ số âm lượng hiện tại của loại luồng nhạc cụ thể (streamType).
        float currentVolumeIndex = (float) audioManager.getStreamVolume(streamType);


        // Chỉ số âm lượng tối đa của loại luồng nhạc cụ thể (streamType).
        float maxVolumeIndex  = (float) audioManager.getStreamMaxVolume(streamType);

        // Âm lượng  (0 --> 1)
        this.volume = currentVolumeIndex / maxVolumeIndex;

        // Cho phép thay đổi âm lượng các luồng kiểu 'streamType' bằng các nút
        // điều khiển của phần cứng.
        this.setVolumeControlStream(streamType);

        // Với phiên bản Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder= new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }
        // Với phiên bản Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }

        // Sự kiện SoundPool đã tải lên bộ nhớ thành công.
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });

        // Tải file nhạc tiếng vật thể bị phá hủy (destroy.war) vào SoundPool.
        this.soundIdDestroy = this.soundPool.load(this, R.raw.destroy,1);

        // Tải file nhạc tiếng súng (gun.wav) vào SoundPool.
        this.soundIdGun = this.soundPool.load(this, R.raw.gun,1);

        this.soundIDMusic = this.soundPool.load(this, R.raw.music,1);

        this.soundIdDun = this.soundPool.load(this, R.raw.dunn,1);

        this.soundIdEvil = this.soundPool.load(this, R.raw.evil,1);

        this.soundIdIll = this.soundPool.load(this, R.raw.ill,1);

        this.soundIDFall = this.soundPool.load(this, R.raw.fall,1);

        this.soundIdSad = this.soundPool.load(this, R.raw.sad,1);


    }

    // Khi người dùng nhấn vào button "Gun".
    public void playSoundGun(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;
            // Phát âm thanh tiếng súng. Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdGun,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

    // Khi người dùng nhấn vào button "Destroy".
    public void playSoundDestroy(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdDestroy,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundDun(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdDun,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundEvil(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdEvil,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundFall(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIDFall,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundIll(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdIll,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundSad(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIdSad,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public void playSoundMusic(View view)  {
        if(loaded)  {
            float leftVolumn = volume;
            float rightVolumn = volume;

            // Phát âm thanh tiếng vật thể bị phá hủy.
            // Trả về ID của luồng mới phát ra.
            int streamId = this.soundPool.play(this.soundIDMusic,leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
}