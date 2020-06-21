package com.example.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.demo.R;
import com.example.demo.model.AppContext;
import com.example.demo.model.Goods;

public class GoodsShoppingActivity extends AppCompatActivity {

    private Goods goods = new Goods();

    /**
     * 购买个数
     */
    private int shoppingCount = 1;

    private TextView tvName;
    private TextView tvDesc;
    private TextView tvPrice;
    // 结算显示框
    private TextView tvCnt;

    private Button btnAdd;
    private Button btnRdu;
    private Button btnBuy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_goods_shopping);

        // 新建的Activity添加到列表以便退出时关闭
        AppContext.activityList.add(this);

        // 获取选中的商品数据
        Intent intent = getIntent();
        goods.id = intent.getIntExtra("id", 0);
        goods.name = intent.getStringExtra("name");
        goods.description = intent.getStringExtra("description");
        goods.price = intent.getFloatExtra("price", 0);

        // 绑定视图
        tvName = findViewById(R.id.shopping_name);
        tvDesc = findViewById(R.id.shopping_desc);
        tvPrice = findViewById(R.id.shopping_price);
        tvCnt = findViewById(R.id.shopping_cnt);
        btnAdd = findViewById(R.id.shopping_add);
        btnRdu = findViewById(R.id.shopping_rdu);
        btnBuy = findViewById(R.id.shopping_buy);

        // 设置数据
        tvName.setText(goods.name);
        tvDesc.setText(goods.description);
        tvPrice.setText("￥" + goods.price);
        tvCnt.setText(shoppingCount + " * " + goods.price + " = " + (shoppingCount * goods.price));

        // 绑定多一个商品和少一个商品的事件
        btnAdd.setOnClickListener(view -> {
            shoppingCount += 1;
            tvCnt.setText(shoppingCount + " * " + goods.price + " = " + (shoppingCount * goods.price));
        });
        btnRdu.setOnClickListener(view -> {
            if (shoppingCount == 1) {
                // 不能少于1件
                return;
            }
            shoppingCount -= 1;
            tvCnt.setText(shoppingCount + " * " + goods.price + " = " + (shoppingCount * goods.price));
        });
        // 结算
        btnBuy.setOnClickListener(view -> {
            // TODO 结算
        });
    }
}
