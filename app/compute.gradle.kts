import com.rahul.jott.gradle.Android

fun computeVersionName(): String {
    var versionNameResult = "${Android.versionMajor}.${Android.versionMinor}"

    versionNameResult = when {
        project.properties.containsKey("overrideVersionName") -> {
            project.properties["overrideVersionName"] as String
        }
        project.properties.containsKey("versionNameSuffix") -> {
            versionNameResult + "." + project.properties["versionNameSuffix"]
        }
        else -> {
            versionNameResult + "." + Android.versionPatch
        }
    }

    println("version name: $versionNameResult")

    return versionNameResult
}

fun computeVersionCode(): Int {
    var versionCodeResult = Android.versionMajor * 10000 + Android.versionMinor * 1000 + Android.versionPatch * 100 + com.rahul.jott.gradle.Android.versionBuild(rootDir)

    if (project.properties.containsKey("overrideVersionCode")) {
        versionCodeResult = (project.properties["overrideVersionCode"]).toString().toInt()
    }

    println("version code: $versionCodeResult")

    return versionCodeResult
}

extra["computeVersionName"] = this::computeVersionName
extra["computeVersionCode"] = this::computeVersionCode
