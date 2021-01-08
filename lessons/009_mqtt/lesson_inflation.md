## Custom ListView rows
{: .reading}

Last time we used the ``ListView`` widget (in the Lifecycler app), we used the ``ArrayAdapter`` class to display ``Strings`` in a simple row of text. That was fine then, but usually you'll want something more sophisticated in your apps.\

This is where **layout inflation** comes into play. It works similarly to when we created the layout for the input dialog in the Lyrics4Me app.

### Layout Inflation
When we create a layout in the layout code view, we directly see what such a layout actually is: a XML file describing the layout. The layout editor goes a step further and uses this xml description to display a preview of how the layout will look like in the app. However, the important part to keep in mind is that also for the graphical layout editor, you only create an XML description in the end, not the UI itself.

![layout inflation](../../assets/img/009_mqtt/layout_inflation.png)

The process of creating the UI out of the XML is whats known as **inflating** the layout. This is done automatically when an activity or a dialog is created, but we can also do it anytime we want by using the utility class ``LayoutInflater``.

In general, the ``LayoutInflater`` is used like this:
````java
LayoutInflater.from(context).inflate(layout, parent);
````

The main use case is to use the current activity as the ``context`` and a layout definition from ``R.layout`` as the ``layout`` to inflate. The ``parent`` usually can either be a dialog, a placeholder view inside another layout or a list element. In a more practical way, the ``LayoutInflater`` could look like this:

````java
LayoutInflater.from(this).inflate(R.layout.list_item, parentView);
````

### Custom ArrayAdapter

Now we want to use layout inflation to implement a custom look for our row inside a ``ListView``. We are going to use a ``ArrayAdapter`` as our basis and create a custom subclass. In the subclass, we have to override the method

````java
public View getView(int position, View convertView, ViewGroup parent)
````

to inject our custom layout. Inside the ``getView`` method, we inflate our custom layout and fill it with the appropriate data:

````java
public View getView(int position, View convertView, ViewGroup parent)

    ...

    // inflate custom layout
    listItem = LayoutInflater.from(this.getContext())
                            .inflate(R.layout.list_view_item, parent, false);

    ...

    // fill data
    TextView txtUser = listItem.findViewById(R.id.txtUser);
    txtUser.setText("My own text");

    ...

    // return the object
    return listitem;
}
````
