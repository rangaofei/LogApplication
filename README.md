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
`compile 'com.github.rgf456:LogApplication:1.0.6'`

3.初始化配置
目前支持的配置包括：
1. 是否输出日志(默认在debug输出，release不输出)
2. 是否输出边框(默认不输出)
3. 是否输出栈信息(默认输出)
4. 设置输出标签(默认是包名)
```
LogConfig logConfig = new LogConfig.Builder()
                .isDebug(true)
                .outputRect(true)
                .outputStackInfo(false)
                .build();
```
4.应用配置
`LogUtil.init(logConfig);`
然后就可以输出日志了。

这里有一个小技巧可以自定义是否输出日志
在buildConfig文件中可以根据当前打包版本（debug还是release）来设置是否输出日志

![](https://github.com/rgf456/LogApplication/blob/master/Thumb/1.png)

### 9月5日更新
新增实体bean类输出
只需添加@LogEntity即可
```
@LogEntity
public class UserName {
    private String user;
    private String address;

    public UserName(String user, String address) {
        this.user = user;
        this.address = address;

```
在方法中调用：
```
LogUtil.object(new UserName("saka","123"));
```
![](https://github.com/rgf456/LogApplication/blob/master/Thumb/2.png)