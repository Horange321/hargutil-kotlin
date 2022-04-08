# hargutil
A tool for dealing args.
Read [Chinese version](./README-zh.md) if possible.\
请尽可能看[中文版本](./README-zh.md)。

## Install
The package can be installed through maven and gradle (this is the recommended method)
```maven
<dependency>
    <groupId>horange.hargutil</groupId>
    <artifactId>hargutil</artifactId>
    <version>1.1.1</version>
</dependency>
```
Also need to add repository.
```maven
<repository>
    <id>github-hargutil</id>
    <url></url>
</repository>
```
Or downloading the release from [maven]() or Github

## Usage
### New
First, create a `Hargs` class:\
Java: `Hargs argv = new Hargs(args);`\
Kotlin: `val argv = Hargs(args)`

### Hargs.add()
To add some switches, use function `Hargs.add(short:String, long:String, map: String)`\
Args instructions:\
`short` like `-o=output.txt`\
`long` like `--input-file=input.txt`\
`map` For convincing of using. Depend by yourself.\
Example:
```Java
hargs.add('v', 'version', 'v') \
    .add('f', 'file', 'f') \
    .add('o', 'output', 'o') \
    .add('', 'force', 'ff') \
#   ... ...
```
It's worth noticing that `short` and `long` can't be `''` at the same time.\
`map` can't be `''`

### Hargs.toMap()
Then `hargs` can be transformed into `Map<String, String>`:\
Java: `var mhargs = hargs.toMap();`\
Kotlin: `val mhargs = hargs.toMap()`\
Example:\
`-v -o=output.txt --force` will turn into
```Java
{
    "v": "",
    "f": null,
    "o": "output.txt",
    "ff": ""
}
