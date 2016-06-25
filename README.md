[![](https://jitpack.io/v/AleksanderMielczarek/PermissionsDialogs.svg)](https://jitpack.io/#AleksanderMielczarek/PermissionsDialogs)

# PermissionsDialogs

PermissionsDialogs works with great [PermissionsDispatcher](http://hotchemi.github.io/PermissionsDispatcher/).

Show dialog with info for @OnShowRationale and @OnNeverAskAgain callbacks. Additionally for @OnNeverAskAgain user will be redirected to app settings.

## Usage

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Add the dependency

```groovy
dependencies {
    compile 'com.github.AleksanderMielczarek:PermissionsDialogs:0.1.0'
}
```

## Example

```java
@OnShowRationale(Manifest.permission.CAMERA)
void showRationaleForCamera(PermissionRequest request) {
    PermissionsDialogs.showRationaleDialog(this, request, R.string.rationaleText, R.string.dialogOk, R.string.dialogCancel);
}

@OnNeverAskAgain(Manifest.permission.CAMERA)
void showNeverAskForCamera() {
    PermissionsDialogs.showNeverAskAgainDialog(this, R.string.neverAskText, R.string.dialogOk, R.string.dialogCancel);
}
```
 
## License

    Copyright 2016 Aleksander Mielczarek

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
