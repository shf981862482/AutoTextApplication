# AutoTextApplication

欢迎看我的博客

配置我们的app下的 build.gradle

```
android {
	defaultConfig {
		testInstrumentationRunner 'android.support.test.runner.AndroidJUnitRunner'
	}
}
```


添加packagingOptions 代码解决冲突。不然会报以下错误
> Duplicate files copied in APK META-INF/maven/com.google.guava/guava/pom.properties
```
android {
    packagingOptions {
        pickFirst('META-INF/maven/com.google.guava/guava/pom.xml')
        pickFirst('META-INF/maven/com.google.guava/guava/pom.properties')
    }
}
```

```
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    androidTestCompile 'com.android.support.test:runner:0.5'
    androidTestCompile 'com.android.support.test:rules:0.5'
    androidTestCompile 'com.android.support.test.espresso:espresso-core:2.2.2'

}
```

添加configurations.all代码解决冲突。不然会报以下错误


> Conflict with dependency 'com.android.support:support-annotations'. Resolved versions for app (23.1.0) and test app (23.0.1) differ

```
configurations.all {
    resolutionStrategy.force 'com.android.support:support-annotations:23.1.0'
}
```
或者尝试

```
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
```

环境搭建好了
