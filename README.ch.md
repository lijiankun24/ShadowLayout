# ShadowLayout

![](https://img.shields.io/badge/language-java-brightgreen.svg) [ ![Download](https://api.bintray.com/packages/lijiankun/maven/shadowlayout/images/download.svg) ](https://bintray.com/lijiankun/maven/shadowlayout/_latestVersion)

*Read this in other languages: [中文](README.ch.md), [English](README.md)* 

## 简介

看一张使用 `ShadowLayout` 库实现的各种阴影的效果图，如下图所示：
<div align=center>
    <img src="screenshot/ShowShadowLayout.png" width="600" height="997"/>
</div>

通过使用 `ShadowLayout` 可以控制阴影的颜色、范围、显示边界（上下左右四个边界）、x 轴和 y 轴的偏移量。

还可以动态的改变阴影的颜色和范围，如下图所示：
<div align=center>
    <img src="screenshot/DynamicChange.gif" width="600" height="800"/>
</div>

## ShadowLayout 的使用

### 添加依赖
Gradle:
``` groovy
    implementation 'com.lijiankun24:shadowlayout:x.y.z'
```

Maven:
``` groovy
    <dependency>
      <groupId>com.lijiankun24</groupId>
      <artifactId>shadowlayout</artifactId>
      <version>x.y.z</version>
      <type>pom</type>
    </dependency>
```
>替换上面的 `x` 、 `y` 和 `z`为最新的版本号:[![Download](https://api.bintray.com/packages/lijiankun/maven/shadowlayout/images/download.svg)](https://bintray.com/lijiankun/maven/shadowlayout/_latestVersion)

### 阴影的展示
在 xml 中添加如下布局文件：
``` xml
    <com.lijiankun24.shadowlayout.ShadowLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="30dp"
        app:shadowColor="#66000000"
        app:shadowShape="rectangle"
        app:shadowDx="0dp"
        app:shadowDy="3dp"
        app:shadowRadius="10dp"
        app:shadowSide="all">

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@android:color/white"
            android:contentDescription="@null"
            android:src="@mipmap/ic_launcher"/>
    </com.lijiankun24.shadowlayout.ShadowLayout>
```
上面 xml 布局文件实现的效果如下图所示：
<div align=center>
    <img src="screenshot/shadowlayout1.png" width="180" height="140"/>
</div>

如上面 xml 中代码显示的那样，总共有 6 个自定义属性，其含义分别如下：
* `app:shadowColor="#66000000"` 控制阴影的颜色，**注意：颜色必须带有透明度的值**
* `app:shadowShape="rectangle|oval"` 控制阴影的形状：圆角矩形|圆形
* `app:shadowDx="0dp"` 控制阴影 x 轴的偏移量
* `app:shadowDy="3dp"` 控制阴影 y 轴的偏移量
* `app:shadowRadius="10dp"` 控制阴影的范围
* `app:shadowSide="all|left|right|top|bottom"` 控制阴影显示的边界，共有五个值

### 阴影的动态改变
``` java
// 改变阴影颜色
ShadowLayout slOval = findViewById(R.id.sl_oval);
slOval.setShadowColor(ContextCompat.getColor(this, R.color.drak_yellow))

// 改变阴影颜色
ShadowLayout slRectangle = findViewById(R.id.sl_rectangle)
slRectangle.setShadowColor(Color.parseColor("#EE00FF7F"));

// 改变阴影范围
ShadowLayout slRadius = findViewById(R.id.sl_radius);
slRadius.setShadowRadius(dip2px(12))
```

效果如下图所示：
<div align=center>
    <img src="screenshot/DynamicChange.gif" width="600" height="800"/>
</div>

欢迎 star 和 fork，也欢迎下载[ShadowLayoutExample.apk](https://github.com/lijiankun24/ShadowLayout/blob/master/ShadowLayoutExample.apk)体验，如果有什么问题欢迎指出。我的工作邮箱：jiankunli24@gmail.com


## License

> ```
> Copyright 2018 lijiankun24
>
> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at
>
>    http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
> ```
