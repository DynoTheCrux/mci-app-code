## Color Picker
{: .reading}

### Setup

#### Add repository
In your **project** `build.gradle (Project)` add
````
maven { url "https://jitpack.io" }
````
to `allprojects/repositories` so that it looks like this:

````
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
````

#### Add dependency
In your **module** `build.gradle (Project.app)` add
````
implementation 'com.github.kizitonwose.colorpreference:core:1.1.0'
````
to the `dependencies`.

### Usage
```` xml
<com.kizitonwose.colorpreference.ColorPreference
	android:defaultValue="@color/color_default"
	android:key="@string/pref_key"
	android:summary="@string/pref_summary"
	android:title="@string/pref_title"
	app:colorShape="circle"
	app:colorChoices="@array/color_choices"
	app:viewSize="large"
	app:numColumns="5"
	app:showDialog="true" />
````

> See [Documentation on github](https://github.com/kizitonwose/colorpreference) for details.