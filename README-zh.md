# hargutil
处理命令行参数的工具

## 安装
通过 maven 或 gradle 安装（推荐用这种方法）
```maven
<dependency>
    <groupId>io.github.horange321</groupId>
    <artifactId>hargutil</artifactId>
    <version>1.1.3</version>
</dependency>
```
同时需要添加仓库
```maven
<repository>
    <id>github-hargutil</id>
    <url>https://horange321.github.io/hargutil-kotlin/maven-repo</url>
</repository>
```
或者从 [maven]() 或 Github 下载。

## 用法
### New
首先，创建一个 `Hargs` 对象，并且设置一些参数，例如：\
Java: `Hargs argv = new Hargs(args);`\
Kotlin: `val argv = Hargs(args)`


### Hargs.add()
加入参数映射，使用函数`Hargs.add(short:String, long:String, map: String)`\
参数说明：\
`short` 短参数，类似 `-o=output.txt`\
`long` 长参数，类似 `--input-file=input.txt`\
`map` 映射值，为方便调用，随便取。\
举例：
```Java
hargs.add('v', 'version', 'v')
    .add('f', 'file', 'f')
    .add('o', 'output', 'o')
    .add('', 'force', 'ff')
//  ... ...
```
值得注意的是：短参数和长参数不能同时为`""`，映射值不能为`""`

### Hargs.to_dict()
此时可将`hargs`转为`dict`\
Java: `var mhargs = hargs.toMap();`\
Kotlin: `val mhargs = hargs.toMap()`\
例如：\
`-v -o=output.txt --force` 将会变成
```Java
{
        "v": "",
        "f": null,
        "o": "output.txt",
        "ff": ""
        }
```