# LogApplication
1.使用本库需先在project级别的build.gradle中添加如下代码
```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
2.在module级别build.gradle添加依赖
`compile 'com.github.rgf456:LogApplication:1.0.5'`

3.初始化配置
目前支持的配置包括：
1. 是否输出日志(默认在debug输出，release不输出)
2. 是否输出边框(默认不输出)
3. 是否输出栈信息(默认输出)
```
LogConfig logConfig = new LogConfig.Builder()
                .isDebug(true)
                .outputRect(true)
                .outputStackInfo(false)
                .build();
```
4.应用配置
`LogUtil.init(logConfig);`
