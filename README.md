# Work5

##Yêu cầu
![BTVN-Button biến hình](http://i477.photobucket.com/albums/rr132/trungepu/Cha%20BTVN-Button-Bin%20higravenh%20-%20CanhBX_zpsmod3g6sq.jpg)

##Chú ý khi code
+ Vẽ hình bình hành
```
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
 <item>
    <rotate android:fromDegrees="116"
            android:pivotX="50%"
            android:pivotY="50%"
    >
        <shape android:shape="rectangle">
            <solid android:color="@color/colorBackground">
            </solid>
        </shape>
    </rotate>
 </item>
</selector>
```

##Tham khảo
+ [How to get the action bar height](http://stackoverflow.com/questions/12301510/how-to-get-the-actionbar-height)
+ [Animation resources](https://developer.android.com/guide/topics/resources/animation-resource.html)
