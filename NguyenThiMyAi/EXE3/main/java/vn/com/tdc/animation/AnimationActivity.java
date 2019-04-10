package vn.com.tdc.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnHien, btnAn, btnRepl, btnZInt, btnZOut, btnXoay, btnLen, btnXuong;
    ImageView imageView;
    Animation anim_Hien, anim_An, anim_Repl, anim_Zoom, anim_Zoomout, anim_Xoay, anim_Len, anim_Xuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);
        HienXa();
        Nhan();
        Animation();
    }
    private void Nhan(){
        btnHien.setOnClickListener(this);
        btnAn.setOnClickListener(this);
        btnRepl.setOnClickListener(this);
        btnZInt.setOnClickListener(this);
        btnZOut.setOnClickListener(this);
        btnLen.setOnClickListener(this);
        btnXuong.setOnClickListener(this);
        btnXoay.setOnClickListener(this);
    }
    private void Animation(){
            anim_Hien = AnimationUtils.loadAnimation(this, R.anim.anim_hien);
            anim_An = AnimationUtils.loadAnimation(this, R.anim.anim_an);
            anim_Repl = AnimationUtils.loadAnimation(this,R.anim.anim_repl);
            anim_Zoom = AnimationUtils.loadAnimation(this,R.anim.anim_zoom);
            anim_Zoomout = AnimationUtils.loadAnimation(this, R.anim.anim_zoomout);
            anim_Xoay = AnimationUtils.loadAnimation(this, R.anim.anim_xoay);
            anim_Len = AnimationUtils.loadAnimation(this, R.anim.anim_len);
            anim_Xuong = AnimationUtils.loadAnimation(this, R.anim.anim_xuong);
    }
    private void HienXa(){
        imageView = (ImageView) findViewById(R.id.imageView2) ;
        btnHien = (Button) findViewById(R.id.btnHien);
        btnAn = (Button) findViewById(R.id.btnAn);
        btnRepl = (Button) findViewById(R.id.btnRepl);
        btnZInt =(Button) findViewById(R.id.btnZInt);
        btnZOut = (Button) findViewById(R.id.btnZOut);
        btnLen = (Button) findViewById(R.id.btnLen);
        btnXuong = (Button) findViewById(R.id.btnXuong);
        btnXoay = (Button) findViewById(R.id.btnXoay);
    }
    @Override
    public void onClick(View v) {
        if (v == btnHien){
            imageView.startAnimation(anim_Hien);
        }
        if (v == btnAn){
            imageView.startAnimation(anim_An);
        }
        if (v ==btnRepl){
            imageView.startAnimation(anim_Repl);
        }
        if (v ==btnZInt){
            imageView.startAnimation(anim_Zoom);
        }
        if (v ==btnZOut){
            imageView.startAnimation(anim_Zoomout);
        }

        if (v ==btnXoay){
            imageView.startAnimation(anim_Xoay);
        }
        if (v ==btnLen){
            imageView.startAnimation(anim_Len);
        }
        if (v ==btnXuong){
            imageView.startAnimation(anim_Xuong);
        }
    }
}
